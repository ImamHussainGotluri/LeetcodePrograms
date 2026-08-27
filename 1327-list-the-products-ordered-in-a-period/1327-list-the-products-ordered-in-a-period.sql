# Write your MySQL query statement below
select product_name,
       sum(o.unit) as unit
from Products pr
left join Orders o
on pr.product_id=o.product_id
AND MONTH(order_date)=2 AND YEAR(order_date)=2020
group by o.product_id
Having sum(o.unit)>=100;