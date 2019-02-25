use [Travel Agency]
go
Create PROCEDURE delete_table_Hotel
@norows int
as
begin
	declare @n int
	
	while @norows!=0
	begin
		SELECT TOP 1 @n=IdHotel from Hotel order by IdHotel desc
		delete from Hotel
		where IdHotel = @n
		set @n = @n-1
		set @norows=@norows-1
	end
end

go
execute delete_table_Hotel 1
