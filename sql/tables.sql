-- delete listings

delete from books;
delete from shoes;
delete from video_games;
delete from autos;
delete from listings;
delete from items;

-- quick clear
-- change 'buy_now_listing' to 'buy_it_now_listing', I shortened the name later on
DROP TABLE autos, books, shoes, video_games, sales, listings, users, items;

CREATE TABLE users (
   -- credentials
   username VARCHAR(25),
   password VARCHAR(50) NOT NULL,
   -- personal info
   first_name TEXT NOT NULL,
   last_name TEXT NOT NULL,
   email TEXT NOT NULL,
   -- site related info
   wallet REAL CHECK (wallet > 0) NOT NULL,
   admin BOOL NOT NULL,
   -- definitions
   PRIMARY KEY (username)
);

CREATE TABLE items (
   item_id SERIAL,
   image TEXT,
   -- definitions
   PRIMARY KEY (item_id)
);

CREATE TABLE autos (
   item_id INT,
   make TEXT NOT NULL,
   model TEXT NOT NULL,
   year INT NOT NULL,
   PRIMARY KEY (item_id),
   FOREIGN KEY (item_id) REFERENCES items (item_id)
);

CREATE TABLE books (
   item_id INT,
   title TEXT NOT NULL,
   author TEXT NOT NULL,
   genre TEXT NOT NULL,
   PRIMARY KEY (item_id),
   FOREIGN KEY (item_id) REFERENCES items (item_id)
);

CREATE TABLE video_games (
   item_id INT,
   title TEXT NOT NULL,
   rating INT CHECK (rating >= 1 AND rating <= 10) NOT NULL,
   genre TEXT NOT NULL,
   PRIMARY KEY (item_id),
   FOREIGN KEY (item_id) REFERENCES items (item_id)
);

CREATE TABLE shoes (
   item_id INT,
   brand TEXT NOT NULL,
   model TEXT NOT NULL,
   size INT CHECK (size > 0) NOT NULL,
   PRIMARY KEY (item_id),
   FOREIGN KEY (item_id) REFERENCES items (item_id)
);

CREATE TABLE listings (
   listing_id SERIAL,
   price REAL CHECK (price > 0) NOT NULL, -- moved price here for simplicity, acts as both (price & current bid)
   title TEXT NOT NULL,
   description TEXT,
   post_date TIMESTAMP NOT NULL,
   exp_date TIMESTAMP NOT NULL,
   status TEXT NOT NULL,  -- (active/closed)
   item_type TEXT NOT NULL,
   item INT NOT NULL,   -- (autos/books/video games/shoes)
   seller VARCHAR(25) NOT NULL,
   -- definitions
   PRIMARY KEY (listing_id),
   FOREIGN KEY (item) REFERENCES items (item_id),
   FOREIGN KEY (seller) REFERENCES users (username)
);

CREATE TABLE sales (
   listing INT,
   buyer VARCHAR(25) NOT NULL,
   sale_date TIMESTAMP NOT NULL,
   PRIMARY KEY (listing),
   FOREIGN KEY (listing) REFERENCES listings (listing_id),
   FOREIGN KEY (buyer) REFERENCES users (username)
);
