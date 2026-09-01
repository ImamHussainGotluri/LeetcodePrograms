# Write your MySQL query statement below
select IFNULL(
    (select num
from MyNumbers
group by num
Having count(*)=1
order by num DESC
limit 1),NULL) as num;