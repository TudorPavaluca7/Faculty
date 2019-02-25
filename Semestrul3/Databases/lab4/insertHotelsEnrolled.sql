use [Travel Agency]
go

create procedure insert_table_HotelsEnrolled
@nrofrows int
as
begin
	declare @n int
	declare @k int
	select top 1 @k=h.IdHotel  from Hotel h where h.HotelName like 'ramada%' order by h.IdHotel desc
	set @n=1
	while @n<=@nrofrows
	begin
		insert into HotelsEnrolled
		values(@k,@n)
		set @n = @n+1
	end

end

go
execute insert_table_HotelsEnrolled 1
select * from HotelsEnrolled