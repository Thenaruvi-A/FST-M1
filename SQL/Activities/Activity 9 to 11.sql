SELECT* FROM salesman;
SELECT* FROM orders;
SELECT* FROM Customers;

--Activity 9
--Write an SQL statement to know which salesman are working for which customer.
select c.CUSTOMER_ID, c.CUSTOMER_NAME, s.SALESMAN_ID, s.SALESMAN_NAME from salesman s inner join customers c on s.SALESMAN_ID= c.SALESMAN_ID;

--Write an SQL statement to make a list of customers in ascending order with a salesman that have a grade less than 300.
select c.CUSTOMER_ID, c.CUSTOMER_NAME, c.CITY as Customer_City, s.SALESMAN_NAME, s.SALESMAN_CITY from customers c left join salesman s on c.SALESMAN_ID = s.SALESMAN_ID where s.grade < 300 order by c.customer_id, c.CUSTOMER_NAME ASC;
--Write an SQL statement to find the list of customers who appointed a salesman who gets a commission of more than 12%
select c.CUSTOMER_ID, c.CUSTOMER_NAME as"Customer",c.CITY, s.SALESMAN_NAME, s.COMMISSION as "Commission(in %)" from customers c right join salesman s  on c.SALESMAN_ID = s.SALESMAN_ID where s.COMMISSION >12
--Write an SQL statement to find the following details of an order - order number, order date, purchase amount of order, which customer gives the order and which salesman works for that customer and commission rate they get for the order.
select o.ORDER_NO, o.ORDER_DATE, o.purchase_amount, c.CUSTOMER_NAME, c.CUSTOMER_ID, s.SALESMAN_NAME,s.SALESMAN_ID, s.COMMISSION as "commission(%)" 
    from orders o join customers c on o.SALESMAN_ID=c.SALESMAN_ID join salesman s on o.SALESMAN_ID=s.SALESMAN_ID;



--Activity 10

--Write a query to find all the orders issued against the salesman who may works for customer whose id is 3007.
select * from orders where salesman_id=(SELECT DISTINCT salesman_id FROM orders WHERE customer_id=3007);
--Write a query to find all orders attributed to a salesman in New York.
SELECT * FROM orders WHERE salesman_id IN (SELECT salesman_id FROM salesman WHERE salesman_city='New York');
--Write a query to count the customers with grades above New York's average.
SELECT grade, COUNT(*) FROM customers GROUP BY grade HAVING grade>(SELECT AVG(grade) FROM customers WHERE city='New York');
--Write a query to extract the data from the orders table for those salesman who earned the maximum commission
SELECT order_no, purchase_amount, order_date, salesman_id FROM orders  WHERE salesman_id IN( SELECT salesman_id FROM salesman WHERE commission=( SELECT MAX(commission) FROM salesman));

--Activity 11

--Write a query that produces the name and number of each salesman and each customer with more than one current order. Put the results in alphabetical order.
SELECT customer_id as "ID(Sales/Customer)", customer_name as Name FROM customers a
WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.customer_id = b.customer_id)
UNION
SELECT salesman_id , salesman_name  FROM salesman a
WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.salesman_id = b.salesman_id)
ORDER BY Name;
--Write a query to make a report of which salesman produce the largest and smallest orders on each date. Also add a column that shows "highest on" and "lowest on" values.
SELECT a.salesman_id, a.salesman_name, o.order_no, 'highest on', o.order_date, o.purchase_amount FROM salesman a, orders o
WHERE a.salesman_id=o.salesman_id
AND o.purchase_amount=(SELECT MAX(purchase_amount) FROM orders c WHERE c.order_date = o.order_date)
UNION
SELECT a.salesman_id, a.salesman_name, o.order_no, 'lowest on', o.order_date, o.purchase_amount FROM salesman a, orders o
WHERE a.salesman_id=o.salesman_id
AND o.purchase_amount=(SELECT MIN(purchase_amount) FROM orders c WHERE c.order_date = o.order_date)
ORDER BY order_date;