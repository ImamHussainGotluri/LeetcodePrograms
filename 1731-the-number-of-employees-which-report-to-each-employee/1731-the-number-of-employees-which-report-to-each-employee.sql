# Write your MySQL query statement below
select reports_to as employee_id,
       (select name from Employees where employee_id = e.reports_to) as name,
       Count(*) as reports_count,
       round(AVG(age)) as average_age 
from Employees e
where reports_to is not null
group by reports_to
order by employee_id ASC;