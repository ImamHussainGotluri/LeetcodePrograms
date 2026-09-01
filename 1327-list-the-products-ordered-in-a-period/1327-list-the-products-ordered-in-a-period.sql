# Write your MySQL query statement below
-- select product_name,
--        sum(o.unit) as unit
-- from Products pr
-- join Orders o
-- on pr.product_id=o.product_id
-- where MONTH(order_date)=2 AND YEAR(order_date)=2020 
-- group by o.product_id
-- Having sum(o.unit)>=100;


select p.product_name,
       sum(o.unit) as unit
from Products p
join Orders o on p.product_id=o.product_id
where MONTH(o.order_date)=2 AND YEAR(o.order_date)=2020
group by p.product_id
Having sum(o.unit)>=100;