SELECT *
from departments;

select *
from employees;

select *
from regions;

select employee_id,first_name,department
from employees;

select * from employees
where department = 'Sports';

select * from employees
where department like '%nit%';

select *
from employees
where salary>100000;

select * from employees
where department='Clothing'
and salary>90000;

select * from employees
where department='Clothing'
  and salary>90000
and region_id=2;

select * from employees
where department='Clothing'
or salary>90000;

select * from employees
where salary<40000
and (department='Clothing'
or department='Pharmacy');

select * from employees
where department!='Sports';

select * from employees
where department<>'Sports';

select * from employees
where not department!='Sports';

select * from employees
where email is null;

select * from employees
where email is not null;

select * from employees
where department='Sports'
or department='First Aid'
or department='Toys'
or department='Garden';

select * from employees
where department in ('Sports','First Aid','Toys');

select * from employees
where salary between 80000 and 100000;

--write a query that retuns the first name aemail of females that work in the tools department
--having a salary greate than 110,000

select first_name,email from employees
where gender='F'
and department='Tools'
and salary>110000;

--write a query that returns first name fire date who make more 165,000
--as well as those work in sports department and also man

select first_name,hire_date from employees
where salary>165000
or (department='Sports' and gender='M');

select * from employees
order by employee_id desc;

select distinct department
from employees;

select distinct department
from employees
fetch first 3 rows only ;

select salary as yearly_salary
from employees;

--write a query displays name and ages fo the top 4 oldest students
select *
from students
order by age desc
fetch first 4 rows only;

select * from students
where age<=20
and (student_no between 3 and 5 or student_no=7)
or (age>20 and student_no>=4);

select upper(first_name) first_name,lower(department) department
from employees;

select length(first_name)
from employees;

select trim( '   Hello There   ');

select length( '   Hello There   ');

select length(trim( '   Hello There   '));

select first_name || ' ' || last_name as full_name
from employees;

select (salary>140000)
from employees;

select (salary>140000) as highly_paid
from employees
order by salary desc;

select department,(department like '%oth%')
from employees;

select 'This is test data' test_data;

select substring('this is test data' from 1 for 4) as test_data;

select substring('this is test data' from 9) as test_data;

select department,replace(department,'Clothing','Clothes')
from departments;

select max(salary) from employees;

select min(salary) from employees;

select avg(salary) from employees;

select round(avg(salary)) from employees;

select count(email) from employees;

select sum(salary) from employees;

select sum(salary) from employees
where department='Clothing';

--shorten department to 3 chars and upper case
select last_name,upper(substring(department,1,3)) as department,salary,hire_date
from professors;

--highest and lowest salary excluding professor 'Wilson'
select max(salary) max_salary,min(salary) min_salary
from professors
where last_name!='Wilson';

select count(*) from employees;

select count(*),department
from employees
group by department;

select sum(salary) as total_salary,department
from employees
group by department;

select max(salary),min(salary),avg(salary),count(*) number_of_employees,department
from employees
group by department;

select sum(salary) as total_salary,department
from employees
where region_id in(4,5,6,7)
group by department;

select department,count(*)
from employees
group by department
order by department;

--having works for group by
select department,count(*)
from employees
group by department
having count(*)<36
order by department;

--show all unique domain and number of employees
select count(*),substring(email,position('@' in email)+1) email_domain
from employees
where email is not null
group by email_domain;

select d.department
from employees e,departments d;

select * from employees
where department not in (select department from departments);

select *
from (select * from employees where salary>150000) a;

select first_name,last_name,(select first_name from employees)
from employees;

--return all employees that work in electronic division
select *
from employees
where department in (select department from departments where division='Electronics');

--return all employees work in Asia or Canada that make more that 130000
select * from employees
where region_id in (select region_id from regions where country='Asia' or country='Canada');

--first name where work is in Asia and Canada and how much making from the highest employee in the company

select first_name,(select max(salary) from employees)-salary from employees
where region_id in (select region_id from regions where country='Asia' or country='Canada');

--select a query returns all employees work in kids division and
--the dates at which those employees were hired is greater than all of the hire_dates of employees
--who work in the maintenance department

select * from employees
where department=any(select department from departments where division='Kids')
and hire_date > all(select hire_date from employees where department='Maintenance');

--query that returns names of students taking Physics and US History
select student_name from students
where student_no in (select student_no from student_enrollment
where course_no in(select course_no from courses
where course_title in('Physics','US History')));

select first_name,salary,
case
    when salary<100000 then 'under paid'
    when salary>100000 then 'paid well'
    else 'unpaid'
end as category
from employees;

select category,count(*)
from (select first_name,
    case
    when salary<100000 then 'under padi'
    when salary>100000 and salary<160000 then 'well paid'
    else 'executive'
    end as category
    from employees) a
group by category;

select first_name,country from employees e,regions r
where r.region_id=e.region_id;

select first_name,email,division
from employees e, departments d, regions r
where e.department=d.department
and e.region_id=r.region_id;

select first_name,country
from employees inner join regions
on employees.region_id=regions.region_id;

select first_name,email,division
from employees e inner join departments d
on e.department=d.department
where email is not null;

select first_name,email,division,country
from employees e inner join departments d
on e.department = d.department inner join regions r
on e.region_id=r.region_id
where email is not null;

select distinct department from employees; --27
select distinct department from departments; --24

select distinct e.department,d.department
from employees e inner join departments d
on e.department=d.department;

select distinct e.department,d.department
from employees e left join departments d
on e.department=d.department;

select distinct e.department,d.department
from employees e right join departments d
on e.department=d.department;

select distinct e.department,d.department
from employees e full join departments d
on e.department=d.department;

select department
from employees
union
select department
from departments;

select department
from employees
except
select department
from departments;