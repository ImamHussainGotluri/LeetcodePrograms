# Write your MySQL query statement below
select project_id,
       round(avg(experience_years),2) as average_years
from Project as pr
left join Employee as em
on pr.employee_id = em.employee_id
group by pr.project_id;