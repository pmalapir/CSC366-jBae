/* Search quesries referenced off Ebay.
It seems the result sorting complexity is as such...
[search input], [all/buy now/auction], [best match/ending soonest/newly listed]
*/

/* single complexity search queries */

-- best match
-- returns any entries with 'search_input' in any position
-- run an iteration for each token in search input
-- best match will be kept track in java layer by keeping count of hits
SELECT *
FROM listings
WHERE status = 'active'
   AND title LIKE '%search_input%';

-- buy now
SELECT listings.*
FROM buy_now_listings 
   INNER JOIN listings ON buy_now_listings.listing_id = listings.listing_id
WHERE status = 'active';

-- auction
SELECT listings.*
FROM auction_listings 
   INNER JOIN listings ON auction_listings.listing_id = listings.listing_id
WHERE status = 'active';

-- newest -> oldest
SELECT *
FROM listings
WHERE status = 'active'
ORDER BY post_date DESC;

-- oldest -> newest
SELECT *
FROM listings
WHERE status = 'active'
ORDER BY post_date ASC;

-- ending soonest
SELECT *
FROM listings
WHERE status = 'active'
ORDER BY exp_date ASC;

-- lowest -> highest price
SELECT *
FROM listings
WHERE status = 'active'
ORDER BY price ASC;

-- highest -> lowest price
SELECT *
FROM listings
WHERE status = 'active'
ORDER BY price DESC;

/* compound search queries */

/* run an iteration for each token in search input, keep hit count in java */

-- all listings + best match
SELECT *
FROM listings
WHERE status = 'active'
   AND title LIKE '%search_input%';

-- buy now + best match
SELECT listings.*
FROM buy_now_listings
   INNER JOIN listings ON buy_now_listings.listing_id = listings.listing_id
WHERE status = 'active'
   AND title LIKE '%search_input%';

-- auction + best match
SELECT listings.*
FROM auction_listings
   INNER JOIN listings ON auction_listings.listing_id = listings.listing_id
WHERE status = 'active'
   AND title LIKE '%search_input%';

/* run an iteration for each token in search input, store all results with ANY hits */

-- all listings + newest -> oldest
SELECT *
FROM listings
WHERE status = 'active'
   AND title LIKE '%search_input%'
ORDER BY post_date DESC;

-- buy now + newest -> oldest
SELECT listings.*
FROM buy_now_listings
   INNER JOIN listings ON buy_now_listings.listing_id = listings.listing_id
WHERE status = 'active'
   AND title LIKE '%search_input%'
ORDER BY post_date DESC;

-- auction + newest -> oldest
SELECT listings.*
FROM auction_listings
   INNER JOIN listings ON auction_listings.listing_id = listings.listing_id
WHERE status = 'active'
   AND title LIKE '%search_input%'
ORDER BY post_date DESC;

-- all listings + oldest -> newest
SELECT *
FROM listings
WHERE status = 'active'
   AND title LIKE '%search_input%'
ORDER BY post_date ASC;

-- buy now + oldest -> newest
SELECT listings.*
FROM buy_now_listings
   INNER JOIN listings ON buy_now_listings.listing_id = listings.listing_id
WHERE status = 'active'
   AND title LIKE '%search_input%'
ORDER BY post_date ASC;

-- auction + oldest -> newest
SELECT listings.*
FROM auction_listings
   INNER JOIN listings ON auction_listings.listing_id = listings.listing_id
WHERE status = 'active'
   AND title LIKE '%search_input%'
ORDER BY post_date ASC;

-- all listings + ending soonest
SELECT *
FROM listings
WHERE status = 'active'
   AND title LIKE '%search_input%'
ORDER BY exp_date ASC;

-- buy now + ending soonest
SELECT listings.*
FROM buy_now_listings
   INNER JOIN listings ON buy_now_listings.listing_id = listings.listing_id
WHERE status = 'active'
   AND title LIKE '%search_input%'
ORDER BY exp_date ASC;

-- auction + ending soonest
SELECT listings.*
FROM auction_listings
   INNER JOIN listings ON auction_listings.listing_id = listings.listing_id
WHERE status = 'active'
   AND title LIKE '%search_input%'
ORDER BY exp_date ASC;

-- all listings + lowest -> highest price
SELECT *
FROM listings
WHERE status = 'active'
   AND title LIKE '%search_input%'
ORDER BY price ASC;

-- buy now + lowest -> highest price
SELECT listings.*
FROM buy_now_listings
   INNER JOIN listings ON buy_now_listings.listing_id = listings.listing_id
WHERE status = 'active'
   AND title LIKE '%search_input%'
ORDER BY price ASC;

-- auction + lowest -> highest price
SELECT listings.*
FROM auction_listings
   INNER JOIN listings ON auction_listings.listing_id = listings.listing_id
WHERE status = 'active'
   AND title LIKE '%search_input%'
ORDER BY price ASC;

-- all listings + highest -> lowest price
SELECT *
FROM listings
WHERE status = 'active'
   AND title LIKE '%search_input%'
ORDER BY price DESC;

-- buy now + highest -> lowest price
SELECT listings.*
FROM buy_now_listings
   INNER JOIN listings ON buy_now_listings.listing_id = listings.listing_id
WHERE status = 'active'
   AND title LIKE '%search_input%'
ORDER BY price DESC;

-- auction + highest -> lowest price
SELECT listings.*
FROM auction_listings
   INNER JOIN listings ON auction_listings.listing_id = listings.listing_id
WHERE status = 'active'
   AND title LIKE '%search_input%'
ORDER BY price DESC;

/* java query creation, just scribbles */
String build_search_query(Search search) {
   String s;

   if (search.buy_now == true) {
      s = s.concat("SELECT listings.*
                  FROM buy_now_listings
                  INNER JOIN listings ON buy_now_listings.listing_id = listings.listing_id
                  ");
   }
   else if (search.auction == true) {
      s = s.concat("SELECT listings.*
                  FROM auction_listings
                  INNER JOIN listings ON auction_listings.listing_id = listings.listing_id
                  ");
   }
   else {
      s = s.concat("SELECT *
                  FROM listings
                  ");
   }

   s = s.concat("WHERE status = 'active'
               AND title LIKE '%search_input%'
               ");

   if (search.best_match == true) {
   }
   else if (search.newest_to_oldest == true) {
      s = s.concat("ORDER BY post_date DESC");
   }
   else if (search.oldest_to_newest == true) {
      s = s.concat("ORDER BY post_date ASC");
   }
   else if (search.ending_soonest == true) {
      s = s.concat("ORDER BY exp_date ASC");
   }
   else if (search.lowest_to_highest == true) {
      s = s.concat("ORDER BY price ASC");
   }
   else if (search.highest_to_lowest == true) {
      s = s.concat("ORDER BY price DESC");
   }

   s = s.concat(";");

   return s;
}