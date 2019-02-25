use [Travel Agency]
go
Create Procedure delete_table_HotelsEnrolled
@nrofrows int

as
begin
	declare @n int
	declare @k int
	while @nrofrows!=0
	  begin
	  select top 1 @n=he.IdHotel  from HotelsEnrolled he order by he.IdHotel desc
	  select top 1 @k=he.BookingId  from HotelsEnrolled he where he.IdHotel=@n order by he.BookingId desc
	  delete from HotelsEnrolled
	  where BookingId=@k and IdHotel=@n
	  set @nrofrows=@nrofrows-1
	  end  
end

go
execute delete_table_HotelsEnrolled 1
