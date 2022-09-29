use simplilearn;

CREATE TABLE CLASSES (
  ID int NOT NULL,
  CNAME int NOT NULL,
  TEACHER int NOT NULL,
  SUBJECT int NOT NULL
  );
 
insert into  CLASSES values(1,1,1,1);
insert into  CLASSES values(3,2,2,2);
insert into  CLASSES values(2,3,3,3);

UPDATE CLASSES
SET CNAME = 2
WHERE ID = 2;


UPDATE CLASSES
SET CNAME = 3
WHERE ID = 3;


CREATE TABLE STUDENTS (
  ID int(11) NOT NULL,
  FNAME varchar(55) NOT NULL,
  LNAME varchar(55) NOT NULL ,
  AGE int(11) NOT NULL ,
  CLASS int(11) NOT NULL
) ;

insert into STUDENTS values(1,'Rashmi','Rathi',8,1);
insert into STUDENTS values(2,'John','Ryonm',10,2);
insert into STUDENTS values(3,'Tony','rRum',20,3);
insert into STUDENTS values(4,'Herry','Poter',15,4);
insert into STUDENTS values(5,'Shilpa','Rathi',9,1);
insert into STUDENTS values(6,'Abhishek','Kumar',12,3);
insert into STUDENTS values(7,'Priya','Yadav',9,2);
insert into STUDENTS values(8,'Aniket','Kumar',7,1);

Select * from STUDENTS;



CREATE TABLE SUBJECTS (
  ID int NOT NULL,
  SNAME varchar (255) NOT NULL
 );

INSERT INTO SUBJECTS  VALUES(1, 'English');
INSERT INTO SUBJECTS  VALUES(2, 'Mathematics');
INSERT INTO SUBJECTS  VALUES(3, 'Science');

CREATE TABLE TEACHERS (
ID int NOT NULL,
FNAME varchar(255) NOT NULL ,
LNAME varchar(255) NOT NULL,
QUALIFICATION varchar(255) NOT NULL
) ;

insert into TEACHERS values(1,'Seema','Arya','B.Sc');
insert into TEACHERS values(2,'Rahul','Sharma','M.Sc');
insert into TEACHERS values(3,'Vinay','Verma','B.Tech');


ALTER TABLE CLASSES
  ADD PRIMARY KEY (ID),
  ADD KEY subject_id (SUBJECT),
  ADD KEY teacher_id (TEACHER);
  
  ALTER TABLE STUDENTS
  ADD PRIMARY KEY (	ID),
 ADD KEY class_id (CLASSES);


ALTER TABLE SUBJECTS
  ADD PRIMARY KEY (ID);
  
  
  
  ALTER TABLE TEACHERS
  ADD PRIMARY KEY (ID);
  
  
  ALTER TABLE  CLASSES
  MODIFY ID int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
  
  
  ALTER TABLE STUDENTS
  MODIFY ID int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
  
  
  
  ALTER TABLE SUBJECTS
  MODIFY  ID int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
  
  
  
  
  ALTER TABLE CLASSES
  ADD CONSTRAINT subject_id FOREIGN KEY (subject) REFERENCES subjects (id),
  ADD CONSTRAINT teacher_id FOREIGN KEY (teacher) REFERENCES teachers (id);


ALTER TABLE STUDENTS
 ADD CONSTRAINT class_id FOREIGN KEY (class) REFERENCES classes (id);
COMMIT;