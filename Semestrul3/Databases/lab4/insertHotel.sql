use [Travel Agency]
go
create procedure insert_table_Hotel
@norows int
as
begin
  declare @id int
  declare @name varchar(50)
  SELECT TOP 1 @id=IdHotel from Hotel order by IdHotel desc
	
	while @norows!=0
	begin
	   set @name = 'ramada' + CONVERT(varchar(5),@id)
	   set @id = @id +1
	   insert into Hotel
	   values(@id,@name,4,null,null,null)
	   set @norows=@norows-1

	 end



end
go

execute insert_table_Hotel 1
select * from Hotel
