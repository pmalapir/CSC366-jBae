-- use to reset SERIAL column values to 1
ALTER SEQUENCE <table>_<column>_seq RESTART WITH 1;
ALTER SEQUENCE items_item_id_seq RESTART WITH 1;

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