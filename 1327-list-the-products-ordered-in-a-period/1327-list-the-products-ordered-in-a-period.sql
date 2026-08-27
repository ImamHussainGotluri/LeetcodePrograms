# Write your MySQL query statement below
select product_name,
       sum(o.unit) as unit
from Products pr
left join Orders o
on pr.product_id=o.product_id
where order_date LIKE '2020-02-%'
group by o.product_id
Having sum(o.unit)>=100;