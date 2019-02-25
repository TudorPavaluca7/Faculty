use [Travel Agency]
go
create procedure RunTableTests 
AS
BEGIN
	DECLARE @ds DATE
	DECLARE @de DATE
	declare @tableId int
	declare @position int
	declare @tableName varchar(50)
	declare @datestart datetime
	declare @dateend datetime
	declare @testId int
	declare @noofrows int
	set @testId = 1
	set @position = 1 
	while @position < 4
	begin
		
		select @tableId=tt.TableID, @noofrows=tt.NoOfRows  from TestTables tt where tt.Position = @position and tt.TestID = @testId
		select @tableName=t.Name  from Tables t where @tableId = t.TableID
		
		
		
		
		set @datestart = GETDATE()
		
		declare @command varchar(100)
		
		set @command = 'insert_table_'+ @tableName + ' ' + convert(varchar(4),@noofrows)
		exec (@command)
		
		set @dateend=GETDATE()
        insert into TestRunTables
		values(1,@tableId,@datestart,@dateend)


		
		set @position = @position +1
	end
	select * from BookingC
    select * from Hotel
    select * from HotelsEnrolled
	set @testId =3
	set @position=3
	while @position!=0
	begin
		
		select @tableId=tt.TableID, @noofrows = tt.NoOfRows  from TestTables tt where @testId = tt.TestID and tt.Position = @position
		select @tableName = t.Name from Tables t where t.TableID = @tableId

		set @datestart = GETDATE()
		declare @commanddel varchar(100)
		set @commanddel = 'delete_table_'+@tableName +' '+ convert(varchar(5),@noofrows)
		exec (@commanddel)
		set @dateend = GETDATE()
        insert into TestRunTables
		values(3,@tableId,@datestart,@dateend)
		
		set @position = @position -1


	end



end 
go