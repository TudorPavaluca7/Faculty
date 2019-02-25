use [Travel Agency]
go
create Procedure RunViewTests
as
begin
DECLARE @viewName1 VARCHAR(50)
	SELECT @viewName1 = Name
	FROM Views
	WHERE ViewID = 1

	DECLARE @s VARCHAR(50)
	SET @s = 'Select * from ' + @viewName1

	DECLARE @ds1 DATE
	DECLARE @de1 DATE
	SET @ds1 = GETDATE()
	EXEC (@s)
	SET @de1 = GETDATE()
	INSERT INTO TestRunViews(TestRunID, ViewID, StartAT, EndAt) VALUES (2, 1, @ds1, @de1)
	




	DECLARE @viewName2 VARCHAR(50)
	SELECT @viewName2 = Name
	FROM Views
	WHERE ViewID = 2

	DECLARE @s2 VARCHAR(50)
	SET @s2 = 'Select * from ' + @viewName2

	DECLARE @ds2 DATE
	DECLARE @de2 DATE
	SET @ds2 = GETDATE()
	EXEC (@s2)
	SET @de2 = GETDATE()
	INSERT INTO TestRunViews(TestRunID, ViewID, StartAT, EndAt) VALUES (2, 2, @ds2, @de2)
	




	DECLARE @viewName3 VARCHAR(50)
	SELECT @viewName3 = Name
	FROM Views
	WHERE ViewID = 3

	DECLARE @s3 VARCHAR(50)
	SET @s3 = 'Select * from ' + @viewName3

	DECLARE @ds3 DATE
	DECLARE @de3 DATE
	SET @ds3 = GETDATE()
	EXEC (@s3)
	SET @de3 = GETDATE()
	INSERT INTO TestRunViews(TestRunID, ViewID, StartAT, EndAt) VALUES (2, 3, @ds3, @de3)






end
go