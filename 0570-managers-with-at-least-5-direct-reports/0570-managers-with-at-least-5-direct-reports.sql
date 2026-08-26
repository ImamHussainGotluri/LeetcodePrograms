# Write your MySQL query statement below
select e.name
from Employee e
join Employee m
on e.id=m.managerId
group by m.managerId
Having count(m.managerId)>=5;