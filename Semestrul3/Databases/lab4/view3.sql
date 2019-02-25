use [Travel Agency]
go
CREATE VIEW VIEW3
as
select b.BookingId,h.IdHotel from BookingC b,Hotel h
group by b.BookingId,h.IdHotel
select * from VIEW3