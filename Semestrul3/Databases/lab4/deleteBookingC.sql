use [Travel Agency]
go
Create PROCEDURE delete_table_BookingC
@norows int
as
begin
	declare @n int
	
	while @norows!=0
	begin
		SELECT TOP 1 @n=bc.BookingId from BookingC bc order by bc.BookingId desc
		delete from BookingC
		where BookingId = @n
		set @n = @n-1
		set @norows=@norows-1
	end
end

go

execute delete_table_BookingC 1
