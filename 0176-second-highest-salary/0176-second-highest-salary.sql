# Write your MySQL query statement below
select ifnull(
    (
        select distinct salary from Employee
order by salary DESC limit 1 OFFSET 1),NULL
)AS SecondHighestSalary;