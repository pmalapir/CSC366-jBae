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
   AND LOWER(title) LIKE '%search_input%';

-- all listing
SELECT *
FROM listings
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

-- best match
SELECT *
FORM listings
WHERE status = 'active'
   AND title LIKE '%search_input%';

/* run an iteration for each token in search input, store all results with ANY hits */

-- newest -> oldest
SELECT *
FROM listings
WHERE status = 'active'
   AND title LIKE '%search_input%'
ORDER BY post_date DESC;

-- oldest -> newest
SELECT *
FROM listings
WHERE status = 'active'
   AND title LIKE '%search_input%'
ORDER BY post_date ASC;

-- ending soonest
SELECT *
FROM listings
WHERE status = 'active'
   AND title LIKE '%search_input%'
ORDER BY exp_date ASC;

-- lowest -> highest price
SELECT *
FROM listings
WHERE status = 'active'
   AND title LIKE '%search_input%'
ORDER BY price ASC;

-- highest -> lowest price
SELECT *
FROM listings
WHERE status = 'active'
   AND title LIKE '%search_input%'
ORDER BY price DESC;

/* search by filters */

-- price less than or equal (both do the same thing)
SELECT *
FROM listings
   INNER JOIN items ON listings.item = items.item_id
WHERE status = 'active'
   AND item_id IN (SELECT filter_category.item_id FROM filter_category)
   AND price <= filter_price
   AND seller = filter_seller;

SELECT *
FROM listings
   INNER JOIN items ON listings.item = items.item_id
WHERE status = 'active'
   AND price <= filter_price
   AND seller = filter_seller
   AND item_type = filter_item_type;

-- price greater than or equal (both do the same thing)
SELECT *
FROM listings
   INNER JOIN items ON listings.item = items.item_id
WHERE status = 'active'
   AND item_id IN (SELECT filter_category.item_id FROM filter_category)
   AND price >= filter_price
   AND seller = filter_seller;

SELECT *
FROM listings
   INNER JOIN items ON listings.item = items.item_id
WHERE status = 'active'
   AND price >= filter_price
   AND seller = filter_seller
   AND item_type = filter_item_type;


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
