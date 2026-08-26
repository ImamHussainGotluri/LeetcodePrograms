# Write your MySQL query statement below
select unique_id ,name
from EmployeeUNI as em
Right join Employees as emu
on em.id=emu.id;