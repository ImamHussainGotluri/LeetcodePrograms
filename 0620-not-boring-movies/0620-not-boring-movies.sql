# Write your MySQL query statement below
select *
from Cinema cin
where cin.id%2!=0 AND cin.description!='boring'
order by rating DESC;