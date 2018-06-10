-- use to reset SERIAL column values to 1
ALTER SEQUENCE <table>_<column>_seq RESTART WITH 1;
ALTER SEQUENCE items_item_id_seq RESTART WITH 1;
ALTER SEQUENCE listings_listing_id_seq RESTART WITH 1;

INSERT INTO users (username, password, first_name, last_name, email, wallet, admin)
VALUES
('js', 'password', 'Japji', 'Singh', 'jsingh29@calpoly.edu', 10000, 'TRUE'),
('dl', 'password', 'Derek', 'Lung', 'nastyeggrolls@hotmail.com', 10000, 'FALSE'),
('pm', 'password', 'Patrick', 'Malapira', 'pmalpir@calpoly.edu', 10000, 'FALSE'),
('nh', 'password', 'Nathan', 'Hong', 'nahong@calpoly.edu', 10000, 'FALSE');

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
('https://m.media-amazon.com/images/I/81Q1cRhTHbL._SX480_.jpg'),
('http://www.allfordmustangs.com/forums/attachments/2005-talk/6535d1110256200-pics-of-spoiler-delete-ricer.jpg'),
('https://i.ytimg.com/vi/EhF5tPGvQ-A/maxresdefault.jpg'),
('https://farm6.staticflickr.com/5493/14113969650_b2c33ef870_o.jpg'),
('https://www.beamng.com/attachments/toyota-prius-camper-van-photo-gallery_4-jpg.69590/'),
('http://www.audizine.com/gallery/data/500/a6_ricer.jpg'),
('https://images.gr-assets.com/books/1276046901l/767680.jpg'),
('https://images.gr-assets.com/books/1276046901l/767680.jpg'),
('https://images.gr-assets.com/books/1276046901l/767680.jpg'),
('https://images.gr-assets.com/books/1276046901l/767680.jpg'),
('https://images.gr-assets.com/books/1276046901l/767680.jpg'),
('https://images-na.ssl-images-amazon.com/images/I/41D5ZGDD2GL.jpg'),
('https://steamcdn-a.akamaihd.net/steam/apps/702700/header.jpg?t=1528364944'),
('https://mytintinnabulary.files.wordpress.com/2009/08/mii_channel.jpg'),
('https://upload.wikimedia.org/wikipedia/en/thumb/d/dd/Fortnite_cover_art%28PC%29.jpg/220px-Fortnite_cover_art%28PC%29.jpg'),
('https://images-na.ssl-images-amazon.com/images/I/51vbRQnPLVL.jpg'),
('http://cdn.shopify.com/s/files/1/1374/2665/products/Screenshot_2_a07f74fa-a7ae-4218-a58d-8c70e2a19fab_grande.png?v=1516732988'),
('http://cdn.shopify.com/s/files/1/1374/2665/products/Screenshot_2_grande.png?v=1516732500'),
('https://www.shoecarnival.com/dw/image/v2/BBSZ_PRD/on/demandware.static/-/Sites-scvl-master-catalog/default/dwde9f44d5/91392_175409_1.jpg?sw=1694&sh=1999&sm=fit'),
('https://richmedia.channeladvisor.com/ImageDelivery/imageService?profileId=12013292&itemId=1076344&swatchId=1076344-2-AS&recipeName=500'),
('https://cdn.shopify.com/s/files/1/1374/2665/products/Screenshot_71_grande.png?v=1516732902');

INSERT INTO autos (item_id, make, model, year)
VALUES
(1, 'Toyota', '4runner', 2001),
(2, 'Datsun', '280z', 1976),
(3, 'Nissan', 'Altima', 2013),
(4, 'Honda', 'Pilot', 2011),
(5, 'Dodge', 'Ram 1500', 2016),
(21, 'Toyota', 'Camry', 2003),
(22, 'Honda', 'Civic', 2016),
(23, 'Ford', 'Fiesta', 2012),
(24, 'Toyota', 'Prius', 2015),
(25, 'Audi', 'A4', 2008);

INSERT INTO books (item_id, title, author, genre)
VALUES
(6, 'The Cat in the Hat', 'Dr. Seuss', 'childrens'),
(7, 'Green Eggs and Ham', 'Dr. Seuss', 'anime'),
(8, 'How the Grinch Stole Christmas', 'Dr. Seuss', 'christmas'),
(9, 'Fox in Socks', 'Dr. Seuss', 'drama'),
(10, 'The Lorax', 'Dr. Seuss', 'action'),
(26, 'If You Give a Mouse a Cookie', 'Laura Joffe Numeroff', 'anime'),
(27, 'If You Give a Mouse a Car', 'Laura Joffe Numeroff', 'anime'),
(28, 'If You Give a Mouse a Taco', 'Laura Joffe Numeroff', 'anime'),
(29, 'If You Give a Mouse a Hunny', 'Laura Joffe Numeroff', 'anime'),
(30, 'If You Give a Mouse a Plane', 'Laura Joffe Numeroff', 'anime');

INSERT INTO video_games (item_id, title, rating, genre)
VALUES
(11, 'Grand Theft Auto V', 7, 'action'),
(12, 'The Legend of Zelda', 9, 'adventure'),
(13, 'Super Mario Odyssey', 8, 'platform'),
(14, 'Minecraft', 10, 'sandbox'),
(15, 'Cuphead', 8, 'Shoot em up'),
(31, 'Kia', 9, 'adventure'),
(32, 'Bomberman', 8, 'arcade'),
(33, 'Mii Channel', 10, 'sandbox'),
(34, 'Fortnite', 0, 'battle royale'),
(35, 'Megaman', 7, 'classic');

INSERT INTO shoes (item_id, brand, model, size)
VALUES
(16, 'Nike', 'Jordan 1 Retro High Off-White', 9),
(17, 'Adidas', 'Yeezy 500 Blush', 8),
(18, 'Puma', 'Thunder Spectra Black', 10),
(19, 'Diadora', 'Titan II Extra Butter', 11),
(20, 'Converse', 'Chuck Taylor', 9),
(36, 'Skechers', '1 X Supreme', 44),
(37, 'Skechers', '2 X Off-White', 44),
(38, 'Skechers', '3 X Gucci', 44),
(39, 'Skechers', '4 X Prada', 44),
(40, 'Skechers', '5 X Ralph Lauren', 44);

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
(60, 'Black Chuck Taylor', 'pleb shoes', CURRENT_TIMESTAMP, '2018-09-05 00:00:00', 'active', 'Shoe', 20, 'pm'),
(2500, '2003 Toyota Camry Sedan LE Sedan 4D', 'Not a stolen car, come buy pls', CURRENT_TIMESTAMP, '2018-10-01 00:00:00', 'active', 'Auto', 21, 'pm'),
(16650, '2016 Honda Civic LX low miles, clean title', 'Almost new, still under warrenty, come take a look', CURRENT_TIMESTAMP, '2018-10-01 00:00:00', 'active', 'Auto', 22, 'pm'),
(5500, '2012 Ford Fiesta SE Hatchback', '2012 Ford Fiesta very good condition, reliable & well maintained.', CURRENT_TIMESTAMP, '2018-10-01 00:00:00', 'active', 'Auto', 23, 'pm'),
(12900, '2015 Toyota Prius', 'TOYOTA PRIUS 2015 CLEAN TITLE 54 thousand miles', CURRENT_TIMESTAMP, '2018-10-01 00:00:00', 'active', 'Auto', 24, 'pm'),
(5400, '2008 Audi A4 2.0 Turbo', 'Smog done a couple days ago. Transmission smooth. Suspension nice and firm', CURRENT_TIMESTAMP, '2018-10-01 00:00:00', 'active', 'Auto', 25, 'pm'),
(44, '1st Ed. If You Give a Mouse a Cookie', 'Sweet Jesus...Rare and 1 of 100', CURRENT_TIMESTAMP, '2018-10-01 00:00:00', 'active', 'Book', 26, 'js'),
(55, '2st Ed. If You Give a Mouse a Car', 'Sweet Jesus...Rare and 1 of 200', CURRENT_TIMESTAMP, '2018-10-01 00:00:00', 'active', 'Book', 27, 'js'),
(66, '3st Ed. If You Give a Mouse a Taco', 'Sweet Jesus...Rare and 1 of 300', CURRENT_TIMESTAMP, '2018-10-01 00:00:00', 'active', 'Book', 28, 'js'),
(77, '4st Ed. If You Give a Mouse a Hunny', 'Sweet Jesus...Rare and 1 of 400', CURRENT_TIMESTAMP, '2018-10-01 00:00:00', 'active', 'Book', 29, 'js'),
(88, '5st Ed. If You Give a Mouse a Plane', 'Sweet Jesus...Rare and 1 of 500', CURRENT_TIMESTAMP, '2018-10-01 00:00:00', 'active', 'Book', 30, 'js'),
(22, 'KIA on CASSETTE', 'RIP', CURRENT_TIMESTAMP, '2018-10-01 00:00:00', 'active', 'Video Game', 31, 'dl'),
(33, 'Bomberman on CASSETTE', 'RIP', CURRENT_TIMESTAMP, '2018-10-01 00:00:00', 'active', 'Video Game', 32, 'dl'),
(44, 'Mii Channel on CASSETTE', 'RIP', CURRENT_TIMESTAMP, '2018-10-01 00:00:00', 'active', 'Video Game', 33, 'dl'),
(55, 'Fortnite on CASSETTE', 'RIP', CURRENT_TIMESTAMP, '2018-10-01 00:00:00', 'active', 'Video Game', 34, 'dl'),
(66, 'Megaman on CASSETTE', 'RIP', CURRENT_TIMESTAMP, '2018-10-01 00:00:00', 'active', 'Video Game', 35, 'dl'),
(6969, 'Skechers 1 X Supreme', 'hypebeast filth god tier stuff right here', CURRENT_TIMESTAMP, '2018-10-01 00:00:00', 'active', 'Shoe', 36, 'nh'),
(6969, 'Skechers 2 X Off-White', 'hypebeast filth god tier stuff right here', CURRENT_TIMESTAMP, '2018-10-01 00:00:00', 'active', 'Shoe', 37, 'nh'),
(6969, 'Skechers 3 X Gucci', 'hypebeast filth god tier stuff right here', CURRENT_TIMESTAMP, '2018-10-01 00:00:00', 'active', 'Shoe', 38, 'nh'),
(6969, 'Skechers 4 X Prada', 'hypebeast filth god tier stuff right here', CURRENT_TIMESTAMP, '2018-10-01 00:00:00', 'active', 'Shoe', 39, 'nh'),
(6969, 'Skechers 5 X Ralph Lauren', 'hypebeast filth god tier stuff right here', CURRENT_TIMESTAMP, '2018-10-01 00:00:00', 'active', 'Shoe', 40, 'nh'),
-- sold / expired listings
(2500, '2003 Toyota Camry Sedan LE Sedan 4D', 'Not a stolen car, come buy pls', '2018-06-01 00:00:00', CURRENT_TIMESTAMP, 'active', 'Auto', 21, 'pm'),
(16650, '2016 Honda Civic LX low miles, clean title', 'Almost new, still under warrenty, come take a look', '2018-06-01 00:00:00', CURRENT_TIMESTAMP, 'active', 'Auto', 22, 'pm'),
(5500, '2012 Ford Fiesta SE Hatchback', '2012 Ford Fiesta very good condition, reliable & well maintained.', '2018-06-01 00:00:00', CURRENT_TIMESTAMP, 'active', 'Auto', 23, 'pm'),
(12900, '2015 Toyota Prius', 'TOYOTA PRIUS 2015 CLEAN TITLE 54 thousand miles', '2018-06-01 00:00:00', CURRENT_TIMESTAMP, 'active', 'Auto', 24, 'pm'),
(5400, '2008 Audi A4 2.0 Turbo', 'Smog done a couple days ago. Transmission smooth. Suspension nice and firm', '2018-06-01 00:00:00', CURRENT_TIMESTAMP, 'active', 'Auto', 25, 'pm'),
(44, '1st Ed. If You Give a Mouse a Cookie', 'Sweet Jesus...Rare and 1 of 100', '2018-06-01 00:00:00', CURRENT_TIMESTAMP, 'active', 'Book', 26, 'js'),
(55, '2st Ed. If You Give a Mouse a Car', 'Sweet Jesus...Rare and 1 of 200', '2018-06-01 00:00:00', CURRENT_TIMESTAMP, 'active', 'Book', 27, 'js'),
(66, '3st Ed. If You Give a Mouse a Taco', 'Sweet Jesus...Rare and 1 of 300', '2018-06-01 00:00:00', CURRENT_TIMESTAMP, 'active', 'Book', 28, 'js'),
(77, '4st Ed. If You Give a Mouse a Hunny', 'Sweet Jesus...Rare and 1 of 400', '2018-06-01 00:00:00', CURRENT_TIMESTAMP, 'active', 'Book', 29, 'js'),
(88, '5st Ed. If You Give a Mouse a Plane', 'Sweet Jesus...Rare and 1 of 500', '2018-06-01 00:00:00', CURRENT_TIMESTAMP, 'active', 'Book', 30, 'js'),
(22, 'KIA on CASSETTE', 'RIP', '2018-05-02 00:00:00', CURRENT_TIMESTAMP, 'active', 'Video Game', 31, 'dl'),
(33, 'Bomberman on CASSETTE', 'RIP', '2018-05-02 00:00:00', CURRENT_TIMESTAMP, 'active', 'Video Game', 32, 'dl'),
(44, 'Mii Channel on CASSETTE', 'RIP', '2018-05-02 00:00:00', CURRENT_TIMESTAMP, 'active', 'Video Game', 33, 'dl'),
(55, 'Fortnite on CASSETTE', 'RIP', '2018-05-02 00:00:00', CURRENT_TIMESTAMP, 'active', 'Video Game', 34, 'dl'),
(66, 'Megaman on CASSETTE', 'RIP', '2018-05-02 00:00:00', CURRENT_TIMESTAMP, 'active', 'Video Game', 35, 'dl'),
(6969, 'Skechers 1 X Supreme', 'hypebeast filth god tier stuff right here', '2018-05-21 00:00:00', CURRENT_TIMESTAMP, 'active', 'Shoe', 36, 'nh'),
(6969, 'Skechers 1 X Off-White', 'hypebeast filth god tier stuff right here', '2018-05-21 00:00:00', CURRENT_TIMESTAMP, 'active', 'Shoe', 37, 'nh'),
(6969, 'Skechers 1 X Gucci', 'hypebeast filth god tier stuff right here', '2018-05-21 00:00:00', CURRENT_TIMESTAMP, 'active', 'Shoe', 38, 'nh'),
(6969, 'Skechers 1 X Prada', 'hypebeast filth god tier stuff right here', '2018-05-21 00:00:00', CURRENT_TIMESTAMP, 'active', 'Shoe', 39, 'nh'),
(6969, 'Skechers 1 X Ralph Lauren', 'hypebeast filth god tier stuff right here', '2018-05-21 00:00:00', CURRENT_TIMESTAMP, 'active', 'Shoe', 40, 'nh');

INSERT INTO sales (listing, buyer, sale_date)
VALUES
(41, 'js', CURRENT_TIMESTAMP),
(42, 'nh', CURRENT_TIMESTAMP),
(43, 'dl', CURRENT_TIMESTAMP),
(44, 'pm', CURRENT_TIMESTAMP),
(45, 'js', CURRENT_TIMESTAMP),
(46, 'nh', CURRENT_TIMESTAMP),
(47, 'dl', CURRENT_TIMESTAMP),
(48, 'pm', CURRENT_TIMESTAMP),
(49, 'js', CURRENT_TIMESTAMP),
(50, 'nh', CURRENT_TIMESTAMP),
(51, 'dl', CURRENT_TIMESTAMP),
(52, 'pm', CURRENT_TIMESTAMP),
(53, 'js', CURRENT_TIMESTAMP),
(54, 'nh', CURRENT_TIMESTAMP),
(55, 'dl', CURRENT_TIMESTAMP),
(56, 'pm', CURRENT_TIMESTAMP),
(57, 'js', CURRENT_TIMESTAMP),
(58, 'nh', CURRENT_TIMESTAMP),
(59, 'dl', CURRENT_TIMESTAMP),
(60, 'pm', CURRENT_TIMESTAMP);