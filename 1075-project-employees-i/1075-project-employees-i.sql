# Write your MySQL query statement below
select project_id,
       Round(AVG(emp.experience_years),2) as average_years
from Project pr
left join Employee emp
on  pr.employee_id=emp.employee_id
group by pr.project_id;