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
(5, 'Dodge', 'Ram 1500', 2016);

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

INSERT INTO listings (price, title, description, post_date, exp_date, status, item_type, item, seller)
VALUES
(6000, '2001 4runner', 'ODO 240,000, excellent condition', CURRENT_DATE, '2018-07-01', 'active', 'auto', 1, 'nh'),
(9000, '1976 280z', 'ODO ~160,000 runs and drives, good condition', CURRENT_DATE, '2018-07-10', 'active', 'auto', 2, 'nh'),
(13500, 'Altima', '2013, excellent condition', CURRENT_DATE, '2018-06-21', 'active', 'auto', 3, 'nh'),
(16500, 'Red Pilot', '2011, excellent condition, like new', CURRENT_DATE, '2018-06-22', 'active', 'auto', 4, 'nh'),
(25000, 'RAM truck', '2016 new', CURRENT_DATE, '2018-06-27', 'active', 'auto', 5, 'nh'),
(30, '2st Ed. The Cat in the Hat', 'Rare and 1 of 200', CURRENT_DATE, '2018-08-02', 'active', 'book', 6, 'dl'),
(35, '3st Ed. Green Eggs and Ham', 'Rare and 1 of 300', CURRENT_DATE, '2018-08-03', 'active', 'book', 7, 'dl'),
(45, '1st Ed. How the Grinch Stole Christmas', 'Rare and 1 of 100', CURRENT_DATE, '2018-08-05', 'active', 'book', 8, 'dl'),
(25, '1st Ed. Fox in Sock', 'Rare and 1 of 100', CURRENT_DATE, '2018-08-01', 'active', 'book', 9, 'dl'),
(40, '2st Ed. The Lorax', 'Rare and 1 of 200', CURRENT_DATE, '2018-08-04', 'active', 'book', 10, 'dl'),
(25, 'GTA V on VHS', 'RIP', CURRENT_DATE, '2018-10-01', 'active', 'video game', 11, 'js'),
(45, 'Legend of Zelda on VHS', 'RIP', CURRENT_DATE, '2018-10-02', 'active', 'video game', 12, 'js'),
(40, 'Super Mario on VHS', 'RIP', CURRENT_DATE, '2018-10-03', 'active', 'video game', 13, 'js'),
(2500, 'Minecraft on VHS', 'RIP', CURRENT_DATE, '2018-10-04', 'active', 'video game', 14, 'js'),
(15, 'Cuphead on VHS', 'RIP', CURRENT_DATE, '2018-10-05', 'active', 'video game', 15, 'js'),
(900, 'Jordan 1 Retro High Off-White', 'hypebeast filth', CURRENT_DATE, '2018-09-01', 'active', 'shoe', 16, 'pm'),
(400, 'Yeezy 500 Blush', 'Kanye 2020', CURRENT_DATE, '2018-09-02', 'active', 'shoe', 17, 'pm'),
(200, 'Thunder Spectra Black', 'New never worn', CURRENT_DATE, '2018-09-03', 'active', 'shoe', 18, 'pm'),
(1000, 'Titan II Extra Butter', 'Issa shoe', CURRENT_DATE, '2018-09-04', 'active', 'shoe', 19, 'pm'),
(60, 'Blakc Chuck Taylor', 'pleb shoes', CURRENT_DATE, '2018-09-05', 'active', 'shoe', 20, 'pm');
