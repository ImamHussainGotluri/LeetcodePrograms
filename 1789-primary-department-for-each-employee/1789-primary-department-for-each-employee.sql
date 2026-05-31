# Write your MySQL query statement below
-- with temp as (
--     select employee_id,count(department_id) as cnt
--     from Employee
--     group by employee_id
-- )

-- select e.employee_id,
--        e.department_id
-- from Employee e
-- join temp t
-- on t.employee_id = e.employee_id
-- where t.cnt=1 or t.cnt>1 and primary_flag='Y';

select employee_id,
       department_id
from Employee
where primary_flag = 'Y' or employee_id in(
    select employee_id from Employee
    group by employee_id
    Having count(*)=1
)      