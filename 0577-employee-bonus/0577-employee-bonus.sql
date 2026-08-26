# Write your MySQL query statement below
select name,bonus
from Employee emp
left join Bonus b
on emp.empId=b.empId
where bonus<1000 or bonus IS NULL;