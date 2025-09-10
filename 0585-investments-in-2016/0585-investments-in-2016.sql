# Write your MySQL query statement below
select round(sum(tiv_2016),2) tiv_2016
from (
    select *,
        count(*)over(partition by lat,lon) as cnt1,
        count(*)over(partition by tiv_2015) as cnt2
    from Insurance
)as subquery
where cnt1=1 and cnt2>=2