use [Travel Agency]
go
create procedure insert_table_BookingC
@norows int
as
begin
	declare @id int
	declare @cid int
	declare @lid int
	declare @tid int
	
	SELECT TOP 1 @id=BookingId from BookingC order by BookingId desc
	
	while @norows!=0
	begin
		set @id = @id +1
		insert into BookingC
		values(@id,1,1,'2018-04-19','2018-04-26',1,1,1)
		set @norows=@norows-1
		
	end
end

go
execute insert_table_BookingC 1
select * from BookingC