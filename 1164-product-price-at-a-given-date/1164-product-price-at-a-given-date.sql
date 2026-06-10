WITH temp1 AS (
   SELECT p.product_id,
          p.new_price as price
   FROM Products p
   join (
            SELECT product_id,
                MAX(change_date) AS change_date 
        FROM Products
        WHERE change_date <= '2019-08-16'
        GROUP BY product_id
   ) t
   where p.product_id = t.product_id
   and p.change_date = t.change_date 
),
temp2 AS (
   SELECT product_id,
          10 AS price
   FROM Products p
   GROUP BY product_id
   Having min(change_date)>'2019-08-16'
)

SELECT product_id, price FROM temp1
UNION
SELECT product_id, price FROM temp2;
