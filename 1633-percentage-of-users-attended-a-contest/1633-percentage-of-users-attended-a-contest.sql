# Write your MySQL query statement below
select rg.contest_id,
       round(count(user_id)/(select count(*) from Users)*100,2) as percentage
from Register as rg
group by rg.contest_id
order by percentage DESC , rg.contest_id ASC;
