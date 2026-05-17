# Write your MySQL query statement below
select * 
from Cinema as cn
where cn.id%2!=0 and cn.description != 'boring'
order by cn.rating DESC;