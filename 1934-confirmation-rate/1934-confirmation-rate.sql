# Write your MySQL query statement below
select sg.user_id,
       round(ifnull(ifnull(sum(cn.action='confirmed'),0)/ifnull(count(cn.user_id),0),0),2) as confirmation_rate
from Signups sg
left join Confirmations as cn
on sg.user_id = cn.user_id
group by user_id;