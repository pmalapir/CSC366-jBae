/* should be run periodically */
-- close any expired listings
UPDATE listings
SET status = 'closed'
WHERE exp_date <= CURRENT_TIMESTAMP;

/* run all these after a purchase */
-- update listing status after being sold if buy has enough Japji coins
UPDATE listings
SET status = 'closed'
WHERE listing_id = INPUT_LISTING_ID
   AND price <= (
      SELECT wallet
      FROM users
      WHERE username = INPUT_BUY_USERNAME);

-- update user wallet after purchase
UPDATE users
SET wallet = wallet - (
   SELECT price
   FROM listings
   WHERE listing_id = INPUT_LISTING_ID)
WHERE username = INPUT_BUY_USERNAME
   AND wallet >= (
      SELECT price
      FROM listings
      WHERE listing_id = INPUT_LISTING_ID);

-- generate sale record
INSERT INTO sales (listing, buyer, sale_date)
VALUES
(INPUT_LISTING_ID, INPUT_BUY_USERNAME, CURRENT_TIMESTAMP);

-- generate a user purchase history
SELECT sale_date, listings.*
FROM sales
   INNER JOIN listings ON listings.listing_id = sales.listing
WHERE buyer = 'INPUT USER';