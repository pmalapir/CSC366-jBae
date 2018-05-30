CREATE TABLE users (
   -- credentials
   username VARCHAR(25),
   password VARCHAR(50) NOT NULL,
   -- personal info
   first_name TEXT NOT NULL,
   last_name TEXT NOT NULL,
   email TEXT,
   -- address
   -- street_number INT CHECK (street_number > 0),
   -- street TEXT,
   -- city TEXT,
   -- zip_code INT CHECK (zip_code > 0),
   -- site related info
   admin BOOL NOT NULL,
   wallet INT CHECK (wallet > 0),
   -- definitions
   PRIMARY KEY (username)
);

CREATE TABLE items (
   item_id INT CHECK (item_id > 0),
   description TEXT,
   -- definitions
   PRIMARY KEY (item_id)
);

CREATE TABLE autos (
   item_id INT CHECK (item_id > 0),
   make TEXT NOT NULL,
   model TEXT NOT NULL,
   year INT NOT NULL,
   PRIMARY KEY (item_id),
   FOREIGN KEY (item_id) REFERENCES items (item_id)
);

CREATE TABLE books (
   item_id INT CHECK (item_id > 0),
   title TEXT NOT NULL,
   author TEXT NOT NULL,
   genre TEXT NOT NULL,
   PRIMARY KEY (item_id),
   FOREIGN KEY (item_id) REFERENCES items (item_id)
);

CREATE TABLE video_games (
   item_id INT CHECK (item_id > 0),
   title TEXT NOT NULL,
   rating INT CHECK (rating >= 0 AND rating <= 10) NOT NULL,   -- may not work
   genre TEXT NOT NULL,
   PRIMARY KEY (item_id),
   FOREIGN KEY (item_id) REFERENCES items (item_id)
);

CREATE TABLE shoes (
   item_id INT CHECK (item_id > 0),
   brand TEXT NOT NULL,
   model TEXT NOT NULL,
   size INT CHECK (size > 0) NOT NULL,
   PRIMARY KEY (item_id),
   FOREIGN KEY (item_id) REFERENCES items (item_id)
);

CREATE TABLE listings (
   listing_id INT CHECK (listing_id > 0),
   item INT NOT NULL,
   seller VARCHAR(25) NOT NULL,
   post_date TIMESTAMP NOT NULL,
   experation_date TIMESTAMP NOT NULL,
   status TEXT NOT NULL,  -- active, closed
   -- definitions
   PRIMARY KEY (listing_id),
   FOREIGN KEY (item) REFERENCES items (item_id),
   FOREIGN KEY (seller) REFERENCES users (username)
);

CREATE TABLE buy_it_now_listings (
   -- listing parent class attributes
   listing_id INT CHECK (listing_id > 0),
   -- buy it now specific attributes
   price REAL CHECK (price > 0) NOT NULL,
   -- definitions
   PRIMARY KEY (listing_id),
   FOREIGN KEY (listing_id) REFERENCES listings (listing_id)
);

CREATE TABLE auction_listings (
   -- listing parent class attributes
   listing_id INT CHECK (listing_id > 0),
   -- auction specific attributes
   current_bid REAL CHECK (current_bid > 0) NOT NULL,
   reserve REAL CHECK (reserve > 0) NOT NULL,
   -- definitions
   PRIMARY KEY (listing_id),
   FOREIGN KEY (listing_id) REFERENCES listings (listing_id)
);

CREATE TABLE sales (
   listing INT CHECK (listing > 0),
   seller VARCHAR(25) NOT NULL,
   buyer VARCHAR(25) NOT NULL,
   sell_date TIMESTAMP NOT NULL,
   PRIMARY KEY (listing),
   FOREIGN KEY (listing) REFERENCES listings (listing_id),
   FOREIGN KEY (seller) REFERENCES users (username),
   FOREIGN KEY (buyer) REFERENCES users (username)
);
