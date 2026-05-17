# Write your MySQL query statement below
select sg.user_id,
       round(IFNULL(avg(cn.action='confirmed'),0),2) as confirmation_rate
from Signups sg
left join Confirmations as cn
on sg.user_id = cn.user_id
group by user_id;