use [Travel Agency]
go
CREATE VIEW VIEW2
AS
SELECT  * from BookingC b,Hotel h
where b.BookingId >2 and h.HotelName like  '%a%'

select * from VIEW2