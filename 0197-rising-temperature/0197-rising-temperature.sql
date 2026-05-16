# Write your MySQL query statement below
select w1.id
from Weather w1 , Weather w2
where DateDiff(w1.recordDate,w2.recordDate) = 1 AND w1.temperature > w2.temperature;







-- select id from
-- (
--     select id , temperature ,
--     LAG(temperature) Over(order by recordDate) as prev_temp
--     from Weather
-- ) as temp_Comparision
-- where temperature > prev_temp;

