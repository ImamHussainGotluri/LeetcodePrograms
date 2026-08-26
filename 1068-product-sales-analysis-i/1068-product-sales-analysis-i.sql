# Write your MySQL query statement below
select product_name,year,price
From Product as prd
Inner join Sales as sal
on prd.product_id=sal.product_id;