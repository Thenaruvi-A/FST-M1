--creating a table salesman ACtivity 1

CREATE TABLE salesman(salesman_id int PRIMARY KEY, salesman_name varchar(20),salesman_city varchar(20), commision int);
DESCRIBE salesman;

--DROP TABLE salesman



--Insert data into table salesman : Activity 2
INSERT ALL
	INTO salesman VALUES(5001, 'James Hooh' , 'New York', 15)
	INTO salesman VALUES(5002, 'Nail Knite' , 'Paris',13)
	INTO salesman VALUES(5005, 'Pit Alex' , 'London',11)
	INTO salesman VALUES(5006, 'McLyon' , 'Paris',14)
	INTO salesman VALUES(5007, 'Paul Adam' , 'Rome',13)
	INTO salesman VALUES(5003, 'Lauson Hen' , 'San Jose',12)
SELECT 1 FROM DUAL;
--To display the rows in data is inserted
SELECT * FROM salesman



-- Actvity 3 :Select data from table 


-- Show data from the salesman_id and salesman_city columns
SELECT salesman_id,salesman_city FROM salesman
-- Show data of salesman from Paris
SELECT * FROM salesman where salesman_city ='Paris'
-- Show salesman_id and commission of Paul Adam
SELECT  salesman_id, commision FROM salesman where salesman_name ='Paul Adam'

-- Activity 4 Inser a column in table sales man


ALTER TABLE salesman ADD(grade int);
DESCRIBE salesman;
UPDATE salesman SET grade=100;
SELECT* FROM salesman;

--ACTIVITY 5 : TO modify sales man table with a condition



-- Update the grade score of salesmen from Rome to 200.
UPDATE salesman SET grade=200 WHERE salesman_city='Rome';

-- Update the grade score of James Hoog to 300.
UPDATE salesman SET grade=300 WHERE salesman_name='James Hooh';

-- Update the name McLyon to Pierre.
UPDATE salesman SET salesman_name='Pierre' WHERE salesman_name='McLyon';

-- Display modified data
SELECT * FROM salesman;


