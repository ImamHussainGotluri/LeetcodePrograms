# Write your MySQL query statement below
with low as(
    select 'Low Salary' as category,
    count(*) as accounts_count
    from Accounts
    where income<20000
),
avgs as(
    select 'Average Salary' as category,
     count(*) as accounts_count
    from Accounts
    where income>=20000 and income<=50000
),
high as(
    select 'High Salary' as category,
    count(*) as accounts_count
    from Accounts
    where income>50000
)

select category,accounts_count from low
union
select category,accounts_count from avgs
union
select category,accounts_count from high;
