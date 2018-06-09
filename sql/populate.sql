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
('https://dxsdcl7y7vn9x.cloudfront.net/3/513916/8418413/848560934.jpg'),
('http://www.ewallpapers.eu/sites/default/files/datsun-280z-61538-6793536.jpg'),
('https://images.autotrader.com/scaler/620/420/cms/images/cars/nissan/altima/2013/2013-nissan-altima-drive/180924.jpg'),
('https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSyqVk3ecv0CPO-KrNss2fGP3zydjNI4VxhFyJdwesRClt-TXL1-A'),
('http://autoreviewhub.com/wp-content/uploads/2017/09/2018dodgeramsinglecab.jpg'),
('https://peopledotcom.files.wordpress.com/2018/02/dr-seuss-books-4.jpg'),
('https://images-na.ssl-images-amazon.com/images/I/81XWA5qMhHL.jpg'),
('https://images-na.ssl-images-amazon.com/images/I/512PxXsTebL._SX347_BO1,204,203,200_.jpg'),
('https://g.christianbook.com/dg/product/cbd/f400/931803.jpg'),
('https://cdn.deseretnews.com/images/top/main/4534/4534.jpg?width=853&height=450'),
('https://www.rockstargames.com/V/img/global/order/GTAV-PC.jpg'),
('https://multimedia.bbycastatic.ca/multimedia/products/500x500/104/10440/10440780.jpg'),
('https://media.nintendo.com/nintendo/bin/SmENxSXqVepjMBF5NxYddvUr6gSfLeDn/qSG2l7_qvitLVncMwzncZbBoqANeYYL6.png'),
('https://static-cdn.jtvnw.net/ttv-boxart/Minecraft.jpg'),
('https://i.ytimg.com/vi/KAriv93tzI0/maxresdefault.jpg'),
('http://www.2013lebronxi.com/images/2018new/Nike-Air-Jordan-1-Retro-High-OG-Part-2-To-Buy.jpg'),
('http://justfreshkicks.com/wp-content/uploads/2018/02/IMG_0022.jpg'),
('https://cdn.kixify.com/sites/default/files/imagecache/product_full/product/2018/03/25/p_22264631_112139166_10548426.jpg'),
('https://i.ebayimg.com/thumbs/images/g/g0YAAOSwuhFaJKM4/s-l225.jpg'),
('https://m.media-amazon.com/images/I/81Q1cRhTHbL._SX480_.jpg');

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
(6000, '2001 4runner', 'ODO 240,000, excellent condition', CURRENT_TIMESTAMP, '2018-07-01 00:00:00', 'active', 'Auto', 1, 'nh'),
(9000, '1976 280z', 'ODO ~160,000 runs and drives, good condition', CURRENT_TIMESTAMP, '2018-07-10 00:00:00', 'active', 'Auto', 2, 'nh'),
(13500, 'Altima', '2013, excellent condition', CURRENT_TIMESTAMP, '2018-06-21 00:00:00', 'active', 'Auto', 3, 'nh'),
(16500, 'Red Pilot', '2011, excellent condition, like new', CURRENT_TIMESTAMP, '2018-06-22 00:00:00', 'active', 'Auto', 4, 'nh'),
(25000, 'RAM truck', '2016 new', CURRENT_TIMESTAMP, '2018-06-27 00:00:00', 'active', 'Auto', 5, 'nh'),
(30, '2st Ed. The Cat in the Hat', 'Rare and 1 of 200', CURRENT_TIMESTAMP, '2018-08-02 00:00:00', 'active', 'Book', 6, 'dl'),
(35, '3st Ed. Green Eggs and Ham', 'Rare and 1 of 300', CURRENT_TIMESTAMP, '2018-08-03 00:00:00', 'active', 'Book', 7, 'dl'),
(45, '1st Ed. How the Grinch Stole Christmas', 'Rare and 1 of 100', CURRENT_TIMESTAMP, '2018-08-05 00:00:00', 'active', 'Book', 8, 'dl'),
(25, '1st Ed. Fox in Sock', 'Rare and 1 of 100', CURRENT_TIMESTAMP, '2018-08-01 00:00:00', 'active', 'Book', 9, 'dl'),
(40, '2st Ed. The Lorax', 'Rare and 1 of 200', CURRENT_TIMESTAMP, '2018-08-04 00:00:00', 'active', 'Book', 10, 'dl'),
(25, 'GTA V on VHS', 'RIP', CURRENT_TIMESTAMP, '2018-10-01 00:00:00', 'active', 'Video Game', 11, 'js'),
(45, 'Legend of Zelda on VHS', 'RIP', CURRENT_TIMESTAMP, '2018-10-02 00:00:00', 'active', 'Video Game', 12, 'js'),
(40, 'Super Mario on VHS', 'RIP', CURRENT_TIMESTAMP, '2018-10-03 00:00:00', 'active', 'Video Game', 13, 'js'),
(2500, 'Minecraft on VHS', 'RIP', CURRENT_TIMESTAMP, '2018-10-04 00:00:00', 'active', 'Video Game', 14, 'js'),
(15, 'Cuphead on VHS', 'RIP', CURRENT_TIMESTAMP, '2018-10-05 00:00:00', 'active', 'Video Game', 15, 'js'),
(900, 'Jordan 1 Retro High Off-White', 'hypebeast filth', CURRENT_TIMESTAMP, '2018-09-01 00:00:00', 'active', 'Shoe', 16, 'pm'),
(400, 'Yeezy 500 Blush', 'Kanye 2020', CURRENT_TIMESTAMP, '2018-09-02 00:00:00', 'active', 'Shoe', 17, 'pm'),
(200, 'Thunder Spectra Black', 'New never worn', CURRENT_TIMESTAMP, '2018-09-03 00:00:00', 'active', 'Shoe', 18, 'pm'),
(300, 'Titan II Extra Butter', 'Issa shoe', CURRENT_TIMESTAMP, '2018-09-04 00:00:00', 'active', 'Shoe', 19, 'pm'),
(60, 'Black Chuck Taylor', 'pleb shoes', CURRENT_TIMESTAMP, '2018-09-05 00:00:00', 'active', 'Shoe', 20, 'pm');
