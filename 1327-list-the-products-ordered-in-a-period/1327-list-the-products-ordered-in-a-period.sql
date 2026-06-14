# Write your MySQL query statement below
select p.product_name,
       sum(unit) as unit
from Products p
join Orders o
where p.product_id=o.product_id and MONTH(order_date) = 02 AND YEAR(order_date) = 2020
group by o.product_id
having unit>=100;    
       