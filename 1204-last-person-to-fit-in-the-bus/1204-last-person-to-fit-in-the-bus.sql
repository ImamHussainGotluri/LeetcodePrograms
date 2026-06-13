# Write your MySQL query statement below 
with temp as(
    select  *,
        sum(weight) over(order by turn ASC) as Total_weight
    from Queue  
)
select person_name
from temp
where Total_weight<=1000
order by turn DESC limit 1;
