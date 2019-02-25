IF OBJECT_ID('StationsRoutes','U') is not null
	drop table StationsRoutes
IF OBJECT_ID('Stations','U') is not null
	drop table Stations
IF OBJECT_ID('Routes','U') is not null
	drop table [Routes]     --reserved word

IF OBJECT_ID('Trains','U') is not null
	drop table Trains

IF OBJECT_ID('TrainTypes','U') is not null
	drop table TrainTypes

go




CREATE TABLE TrainTypes(
	TTID tinyint Primary Key identity(1,1),
	Description varchar(max)
	)
create table Trains(
	TID smallint Primary Key identity(1,1),
	TName varchar(max),
	TTID tinyint references TrainTypes(TTID))

CREATE TABLE Stations(
	SID smallint Primary Key identity(1,1),
	SName varchar(max) 
	)
CREATE TABLE Routes(
	RID smallint Primary Key identity(1,1),
	RName varchar(max) ,
	TID smallint references Trains(TID)

	)

CREATE TABLE StationsRoutes(
	RID smallint references Routes(RID),
	SID smallint references Stations(SID),
	Arrival time,
	Departure time,
	Primary key(RID,SID)
	)

go

insert into TrainTypes values('regio'),('interregio')
insert into Trains values ('t1',1),('t2',1),('t3',2)
insert Routes values('r1',1),('r2',2),('r3',3)
insert into Stations values('s1'),('s2'),('s3')
insert into StationsRoutes values(1,1,'7:00','7:10'),(1,2,'8:00','8:10'),(1,3,'9:00','9:10'),
(3,1,'7:00','7:10'),(3,2,'8:00','8:10'),(3,3,'9:00','9:10'),
(2,1,'9:00','9:10')
go
create or alter procedure uspAddStationToRoute @RName varchar(100), @SName varchar(100), @arrival time, @Departure time
as

	declare @rid int = (
		select RID from Routes where RName=@Rname
	)

	declare @sid int = (
		select SID from Stations where SName=@Sname
	)

	--check id's

	if @Rid is null or @Sid is null raiserror('station/route do/does not exist',16,1)
	else
		if exists(select * from StationsRoutes where SID=@sid and RID=@rid)
			raiserror('Station already on route',16,1)
		else
			insert into StationsRoutes values (@RID,@SID,@arrival,@Departure)

go

select * from TrainTypes
select * from Trains
select * from Routes
select * from Stations

select * from StationsRoutes
order by RID

exec uspAddStationToRoute 'dfdg','dfdg','10:10','11:10'

exec uspAddStationToRoute 'r1','s1','10:10','11:10'

exec uspAddStationToRoute 'r2','s2','10:10','11:10'


select Sid from Stations 

select Sid from StationsRoutes
where rid=1

select sid from Stations
except
select sid from StationsRoutes where rid=1

go
create view vRoutesWithAllStations 
as
select R.RName  from Routes R
where not exists(
	
select sid from Stations
except
select sid from StationsRoutes where RID=R.RID)   -- RID e din StationsRoutes

go


select * from vRoutesWithAllStations






