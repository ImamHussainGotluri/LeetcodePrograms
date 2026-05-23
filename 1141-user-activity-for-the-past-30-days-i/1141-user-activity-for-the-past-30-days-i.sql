# Write your MySQL query statement below
select activity_date as day,
       count(distinct user_id) as active_users 
from Activity
where activity_date between '2019-6-28' and '2019-7-27'
group by activity_date;
