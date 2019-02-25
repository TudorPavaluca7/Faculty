use Lab5
create table Students (
	Sid int Primary key ,
	age float unique,
	SName varchar(100) 
	)

create table Course(
	CId int Primary key,
	Duration int,
	CName varchar(100))

	

create table Enrollments(
	EId int primary key not null,
	CId int references Course(CId),
	Sid int references Students(Sid))
insert into Students values
     (1,16.7,'marius'),
	 (2,26.7,'darius'),
	 (3,16.9,'mihai'),
	 (4,18,'claudia'),
	 (5,20,'marcel'),
	 (6,19,'cristian'),
	 (7,30,'marin')

-- clustered index scan

select * from Students

--clustered index seek
select * from Students s where s.age>=20


--nonclustered index scan;
		drop index index1 on Students
		create nonclustered index [index1] on Students(age)
		select age from Students

--nonclustered index seek.
    select age from Students with (index=index1) where age >=20

--key look-up
	select * from Students  where age >=20;

	
--b
	
	drop index index2 on Course
	create nonclustered index index2 on Course(Duration)
	select Duration from Course
	where Duration=20

	select Duration from Course
	where Duration=20

--c. 
	insert into Enrollments values
	(1,1,2),
	(2,1,3),
	(3,4,2),
    (4,4,3),
    (5,5,4),
	(6,4,1),
    (7,1,1)
	go
	create view VIEWSt as
	select s.age as Students from ((
	 Students s
	INNER JOIN Enrollments E ON E.Sid=s.Sid)
	inner join Course C on C.CId=E.CId)
	where s.age >=20
	go

	
	
    --clustered
	select * from VIEWSt

	--nonclustered
	drop index index3 on Students
	create nonclustered index index3 on Students(age)
	select * from  VIEWSt with (index=index3)
	drop view VIEWSt