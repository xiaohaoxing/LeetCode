select
    id,
    SUM(CASE WHEN month='Jan' then revenue else null end) as 'Jan_Revenue',
    SUM(CASE WHEN month='Feb' then revenue else null end) as 'Feb_Revenue',
    SUM(CASE WHEN month='Mar' then revenue else null end) as 'Mar_Revenue',
    SUM(CASE WHEN month='Apr' then revenue else null end) as 'Apr_Revenue',
    SUM(CASE WHEN month='May' then revenue else null end) as 'May_Revenue',
    SUM(CASE WHEN month='Jun' then revenue else null end) as 'Jun_Revenue',
    SUM(CASE WHEN month='Jul' then revenue else null end) as 'Jul_Revenue',
    SUM(CASE WHEN month='Aug' then revenue else null end) as 'Aug_Revenue',
    SUM(CASE WHEN month='Sep' then revenue else null end) as 'Sep_Revenue',
    SUM(CASE WHEN month='Oct' then revenue else null end) as 'Oct_Revenue',
    SUM(CASE WHEN month='Nov' then revenue else null end) as 'Nov_Revenue',
    SUM(CASE WHEN month='Dec' then revenue else null end) as 'Dec_Revenue'
from
    Department
group by id
order by id;