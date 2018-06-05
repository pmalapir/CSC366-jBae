-- use to reset SERIAL column values to 1
ALTER SEQUENCE <table>_<column>_seq RESTART WITH 1;
ALTER SEQUENCE items_item_id_seq RESTART WITH 1;
ALTER SEQUENCE listings_listing_id_seq RESTART WITH 1;

INSERT INTO users (username, password, first_name, last_name, email, wallet, admin)
VALUES
('js', 'password', 'Japji', 'Singh', 'jsingh29@calpoly.edu', 69, 'TRUE'),
('dl', 'password', 'Derek', 'Lung', 'nastyeggrolls@hotmail.com', 100, 'FALSE'),
('pm', 'password', 'Patrick', 'Malapira', 'pmalpir@calpoly.edu', 666, 'FALSE'),
('nh', 'password', 'Nathan', 'Hong', 'nahong@calpoly.edu', 999, 'FALSE');

INSERT INTO items (image)
VALUES
('auto1'),
('auto2'),
('auto3'),
('auto4'),
('auto5'),
('book1'),
('book2'),
('book3'),
('book4'),
('book5'),
('game1'),
('game2'),
('game3'),
('game4'),
('game5'),
('shoe1'),
('shoe2'),
('shoe3'),
('shoe4'),
('shoe5');

INSERT INTO autos (item_id, make, model, year)
VALUES
(1, 'Toyota', '4runner', 2001),
(2, 'Datsun', '280z', 1976),
(3, 'Nissan', 'Altima', 2013),
(4, 'Honda', 'Pilot', 2011),
(5, 'Ram', '1500', 2016);

INSERT INTO books (item_id, title, author, genre)
VALUES
(6, 'The Cat in the Hat', 'Dr. Seuss', 'childrens'),
(7, 'Green Eggs and Ham', 'Dr. Seuss', 'anime'),
(8, 'How the Grinch Stole Christmas', 'Dr. Seuss', 'christmas'),
(9, 'Fox in Socks', 'Dr. Seuss', 'drama'),
(10, 'The Lorax', 'Dr. Seuss', 'action');

INSERT INTO video_games (item_id, title, rating, genre)
VALUES
(11, 'Grand Theft Auto V', 7, 'action'),
(12, 'The Legend of Zelda', 9, 'adventure'),
(13, 'Super Mario Odyssey', 8, 'platform'),
(14, 'Minecraft', 10, 'sandbox'),
(15, 'Cuphead', 8, 'Shoot em up');

INSERT INTO shoes (item_id, brand, model, size)
VALUES
(16, 'Nike', 'Jordan 1 Retro High Off-White', 9),
(17, 'Adidas', 'Yeezy 500 Blush', 8),
(18, 'Puma', 'Thunder Spectra Black', 10),
(19, 'Diadora', 'Titan II Extra Butter', 11),
(20, 'Converse', 'Chuck Taylor', 9);

INSERT INTO listings (price, title, description, post_date, exp_date, status, item, seller)
VALUES
(6000, '2001 4runner', 'ODO 240,000, excellent condition', CURRENT_DATE, '2018-07-01', 'active', 1, 'nh'),
(25, '1st Ed. Fox in Sock', 'Rare and 1 of 100', CURRENT_DATE, '2018-08-01', 'active', 9, 'dl'),
(700, 'Size 9 Jordan 1 Retro High Off-White', 'Flex or re-sell with this you hypebeast filth', CURRENT_DATE, '2018-09-01', 'active', 16, 'pm'),
(2500, 'Minecraft on VHS', 'RIP', CURRENT_DATE, '2018-10-01', 'active', 14, 'js');
