# Write your MySQL query statement below
select product_name ,year,price
from Product as pd
right join Sales as sal
on pd.product_id=sal.product_id;