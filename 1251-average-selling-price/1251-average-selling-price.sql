# Write your MySQL query statement below
select pr.product_id ,
       round(ifnull(sum(pr.price*us.units)/sum(us.units),0),2) as average_price
from Prices as pr
left join UnitsSold as us
on pr.product_id = us.product_id
and us.purchase_date between pr.start_date and pr.end_date   
group by pr.product_id;