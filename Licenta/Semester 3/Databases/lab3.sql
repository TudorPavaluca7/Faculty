use [Travel Agency]

go 
create procedure b1 
as
alter table review
alter column description nvarchar(150)
go

go
create procedure b1_r
as
alter table review
alter column description varchar(150)
go

go 
create procedure b2
as
alter table review
add hour varchar(20)
go

go 
create procedure b2_r
as
alter table review
drop column hour
go

go
create procedure b3
as
alter table review
add constraint constr
default '-' for description
go

go
create procedure b3_r
as
alter table review
drop constraint constr
go

go
create procedure b4
as
alter table review
add constraint pk_id primary key clustered(id)
go

go
create procedure b4_r
as
alter table review
drop constraint pk_id
go

go
create procedure b5
as
create table Person(
p_id int not null,
Pname varchar(35) not null)
alter table Person
add constraint pk_pi primary key clustered(p_id)
alter table Person
drop constraint pk_pi
alter table Person
drop column p_id
alter table Person
add constraint pk_name primary key clustered(Pname)

go

go
create procedure b5_r
as
alter table Person
drop constraint pk_name
drop table Person
go

go
create procedure b6
as
create table Person1(
id_p1 int not null
constraint pk_id1 primary key clustered (id_p1)
)
alter table review
add constraint fk_id foreign key(person) references Person1(id_p1)
go

go
create procedure b6_r
as
alter table review
drop constraint fk_id
drop table Person1
go 

go
create procedure b7
as
create table typeR(
Rtype varchar(30) not null,
constraint pk_r primary key clustered (Rtype)
)
go

go 
create procedure b7_r
as
drop table typeR
go

go
create PROCEDURE DatabaseToVersion1
	@versionTo int
AS
BEGIN
	DECLARE @Currentversion int

	SET @Currentversion = (select V.current_version 
							from Database_Version V)

	DECLARE @query varchar(2000)

	IF @versionTo <= 7 AND @versionTo >=0
		IF @versionTo > @Currentversion
		BEGIN
			 WHILE @versionTo>@Currentversion
				BEGIN
					set @Currentversion = @Currentversion + 1
					set @query = 'b' + CAST(@Currentversion AS VARCHAR(5))
					exec @query
				END
		END
		ELSE  
		BEGIN 
			WHILE @versionTo<@Currentversion
				BEGIN
					IF @Currentversion!=0
					BEGIN
						set @query = 'b' + CAST(@Currentversion AS VARCHAR(5)) + '_r'
						exec @query
					END
					set @Currentversion = @Currentversion - 1
				END
		END
		update Database_Version
		set current_version = @versionTo
END
go
exec DatabaseToVersion1 4