# Write your MySQL query statement below
select customer_id ,
       count(customer_id) as count_no_trans
from Visits as vs
left join Transactions as trans
on vs.visit_id = trans.visit_id
where trans.transaction_id is null
group by customer_id
order by count_no_trans DESC