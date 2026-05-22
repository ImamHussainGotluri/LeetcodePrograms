# Write your MySQL query statement below
select (
    select num 
    from MyNumbers
    group by num
    Having count(num)=1
    order by num DESC
    limit 1
) as num;    