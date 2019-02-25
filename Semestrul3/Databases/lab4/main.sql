use [Travel Agency]
delete from TestRuns
delete from TestRunTables
delete from TestRunViews

go
DECLARE @ds  datetime
DECLARE @de  datetime
SET @ds = GETDATE()

INSERT INTO TestRuns(TestRunID, Description, StartAT, EndAt) VALUES (2, 'View', @ds, @ds)

execute RunViewTests

SET @de = GETDATE()
UPDATE TestRuns
SET EndAt = @de
WHERE Description = 'View'

SET @ds = GETDATE()
INSERT INTO TestRuns(TestRunID, Description, StartAT, EndAt) VALUES (1, 'Insert', @ds, @ds)
INSERT INTO TestRuns(TestRunID, Description, StartAT, EndAt) VALUES (3, 'Delete', @ds, @ds)
EXECUTE RunTableTests 

SET @de = GETDATE()
UPDATE TestRuns
SET EndAt = @de
WHERE Description = 'Insert' OR Description = 'Delete'
select * from TestRuns
select * from TestRunTables
select * from TestRunViews
select * from BookingC
select * from Hotel
select * from HotelsEnrolled
go

create procedure updateRows
@newnr int
as
begin
	update TestTables
	set NoOfRows=@newnr
end

go
execute updateRows 1
select * from TestTables