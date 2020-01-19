#mysql练习
##排序相关
rank()  相同名次的会并列 会占用下一名次的位置
dense_rank()  相同名次的会并列，不会占下一位名次
row_number()  不会并列 按顺序  
##查找所有至少连续出现三次的数字  
select 
distinct l1.Num as ConsecutiveNums 
from Logs l1 ,
     Logs l2 , 
     Logs l3 
where l1.Id = l2.Id - 1 
        and l1.Id = l3.Id + 1
        and l1.Num  = l2.Num  
        and l1.Num  = l3.Num 
##查询可以获取收入超过他们经理的员工的姓名
select e1.Name as Employee 
from Employee e1, Employee e2 
where e1.ManagerId = e2.Id and e1.Salary > e2.Salary;  
##查找Person表中所有重复的电子邮箱 
SELECT Email
from 
	(SELECT p.Email,count(Email) as size 
	from Person p
	GROUP BY p.Email
	HAVING size >1 ) as result  
	更为简便的方法：  
	select Email
    from Person
    group by Email
    having count(Email) > 1;
###注意
1、where的执行顺序要大于聚合函数  
2、having是跟在group by 后面，筛选满足条件的组，但是having要比where的性能低许多  
## not in用法
select  t.Name as Customers 
from Customers t
where t.Id not in(
    select o.CustomerId from Orders o
)