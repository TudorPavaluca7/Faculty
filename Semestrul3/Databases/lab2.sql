use [Travel Agency]
/*INSERT*/

/*insert into Location(LocationId,Name,Country,ShortDescription) Values(1,'Tenerife','Spain','Tenerife is the largest of Spain’s Canary Islands, off West Africa. Its dominated by Mt. Teide, a dormant volcano that is Spain"s tallest peak.'); 
insert into Location Values(2,'Nassau','Bahamas','Nassau, the capital city and the commercial center of the Bahamas, houses nearly 70% of the country"s total population.');
insert into Location Values(3,'Cluj-Napoca','Romania','Cluj-Napoca, a city in northwestern Romania, is the unofficial capital of the Transylvania region. It"s home to universities, vibrant nightlife and landmarks dating to Saxon and Hungarian rule.');
insert into Location values(4,'Bucharest','Romania','Bucharest, in southern Romania, is the country"s capital and commercial center. Its iconic landmark is the massive, communist-era Palatul Parlamentului government building, which has 1,100 rooms.');
insert into Location values(5,'Budapest','Hungary','Budapest, Hungary’s capital, is bisected by the River Danube. Its 19th-century Chain Bridge connects the hilly Buda district with flat Pest. ');
insert into Location values(6,'Vienna','Austria','Vienna, Austria’s capital, lies in the country’s east on the Danube River. Its artistic and intellectual legacy was shaped by residents including Mozart, Beethoven and Sigmund Freud.');
insert into Location values(7,'Oslo','Norway','Oslo, the capital of Norway, sits on the country’s southern coast at the head of the Oslofjord. It’s known for its green spaces and museums.');
insert into Location values(8,'Paris','France','France"s capital, is a major European city and a global center for art, fashion, gastronomy and culture. Its 19th-century cityscape is crisscrossed by wide boulevards and the River Seine.');
insert into Location values(9,'London','UK','London, the capital of England and the United Kingdom, is a 21st-century city with history stretching back to Roman times. At its centre stand the imposing Houses of Parliament, the iconic ‘Big Ben’ clock tower and Westminster Abbey, site of British monarch coronations.');
insert into Location values(10,'Madrid','Spain','Madrid, Spain"s central capital, is a city of elegant boulevards and expansive, manicured parks such as the Buen Retiro. It’s renowned for its rich repositories of European art, including the Prado Museum’s works by Goya, Velázquez and other Spanish masters.');

insert into Employee values(1,'Marius Pop',30,2500,'Pop street','0712312210',null);
insert into Employee values(3,'Darius Pop',29,2600,'Titulescu street','0711233130','dariuspop@gmail.com');
insert into Employee values(4,'Mihai Pop',29,2700,'Titulescu street','0729383213','mihaispop@gmail.com');
insert into Employee values(5,'Mihaela Pop',25,2300,'Kogalniceanu street','0711135532','mihaelapop@gmail.com');
insert into Employee values(6,'Roxana Popa',22,2300,'Titulescu street','0723133332','roxana_popa@yahoo.com');
insert into Employee values(7,'Narita George',39,2300,'Brancusi street','0723134432','narita@gmail.com');
insert into Employee values(8,'Marian Claudiu',49,2300,'Liviu Rebreanu street','0723101025','marianclaudiu@gmail.com');


insert into TOI_Types values('museum');
insert into TOI_Types values('park');
insert into TOI_Types values('castle');
insert into TOI_Types values('zoo');
insert into TOI_Types values('square');
insert into TOI_Types values('buildings');
insert into TOI_Types values('church');

insert into TransportCompany values(1,'Qatar Airways','business,economy','plane');
insert into TransportCompany values(2,'Turkish Airlines','business,economy','plane');
insert into TransportCompany values(3,'Tarom','economy','plane');
insert into TransportCompany values(4,'Fany',null,'coach');
insert into TransportCompany values(5,'EasyBus',null,'coach');
insert into TransportCompany values(6,'WizzAir','economy','plane');
insert into TransportCompany values(7,'Amtrak',null,'rail');
insert into TransportCompany values(8,'Lufthansa','business,economy','plane');

insert into TrType values('plane');
insert into TrType values('coach');
insert into TrType values('rail');


/*Update*/
update TransportCompany
set CompanyName='Emirates'
where CompanyId=2 and trans_type='plane';

update Employee
set		Salary=2750
where EmployeeId between 7 and 8;

update Employee
set Mobile='0745099194'
where Ename like 'Ma%';

update Location
set Name='Medias',ShortDescription='nice'
where Name='Cluj-Napoca';


/*Delete*/
delete from TransportCompany
where CompanyId>7;

delete from TOI_Types
where toi_type like 'zo%';

*/

/* Select */

/*A. 2 queries with the union operation; use UNION [ALL] and OR;*/

/*Uneste numele angajatilorr cu numele de familie al clientilor*/
Select Ename from Employee
union
Select LastName from Customer
/*
/*Uneste numele angajatilorr care au salariu mai mare de 2500 sau varsta peste 30 de ani cu numele de familie al clientilor*/
Select Ename from Employee where Age>30 OR Salary>2600
union
Select LastName from Customer

/*B. 2 queries with the intersection operation; use INTERSECT and IN;*/
/*Intersecteza toti angajatii care sunt inrolati in locatia cu id-ul 2 in ordine descrecatoare id-ului*/

Select EmployeeId from Employee
intersect
Select EmployeeId from EmployeesEnrolled where LocationId=2
Order by EmployeeId desc


/*Afiseaza numele companiilor care sunt inrolate ordonate alfabetic*/
Select CompanyName from TransportCompany
where CompanyId in (select CompanyId from Transport)
Order by CompanyName


/*C. 2 queries with the difference operation; use EXCEPT and NOT IN*/
/*Afiseaza numele hotelurilor care nu sunt inrolate*/
Select top 1 HotelName  from Hotel
where IdHotel not in (select IdHotel from HotelsEnrolled)

/*Afiseaza locatia plecarii si destinatia transporturilor exceptand alea care sunt cu avionul*/
Select Origin,Destination from Transport
except
Select Origin,Destination from Transport
where ClassType!='economy' or ClassType!='bussines'


/*D. 4 queries with INNER JOIN, LEFT JOIN, RIGHT JOIN, and FULL JOIN; 
---one query will join at least 3 tables, 
---while another one will join at least two many-to-many relationships;*/

/* INNER JOIN -- hoteluri care sunt inrolate*/

select Hotel.HotelName from Hotel
inner join HotelsEnrolled as H on Hotel.IdHotel=H.IdHotel

/*Full join--join table Customer with table Booking*/

select FirstName,LastName,CheckInDate,CheckOutDate from Customer
full join BookingC
on Customer.cid=BookingC.BookingId


--RIGHT JOIN
/*selectez locatiile cu angajatii care se ocupa de ele*/
select E.Ename,L.Name
from EmployeesEnrolled ee
right join Employee E on E.EmployeeId=ee.EmployeeId
right join Location L on L.LocationId=ee.LocationId


--LEFT JOIN

/*afiseaza toate bookingurile care au ca si locatie,o locatia inrolata in tabelul employeeEnrolled si tara de provenienta incepe cu litera S*/
select b.BookingId,he.IdHotel,b.LocationId
from BookingC b
left join HotelsEnrolled he on b.BookingId=he.BookingId
where b.LocationId in (select l.LocationId from Location l where l.Country like 'S%' and l.LocationId in (select ee.LocationId from EmployeesEnrolled ee))

/* 2 queries using the IN operator to introduce a subquery in the WHERE clause; in at least one query, the subquery should include a subquery in its own WHERE clause;*/
/*selectez toate locatiile care au ca obiective turistice biserici*/
select top 2 Name 
from Location
where Location.LocationId IN (select LocationId from Things_Of_Interest where toi_type='church')


/*selecteaza toti clientii cazati la hotelul safir*/
select FirstName,LastName 
from Customer
where Customer.cid IN (select CustomerId from BookingC where BookingId in (select BookingId from HotelsEnrolled where IdHotel=3))


/*selecteaza toti angajatii care nu au legatura cu bahamas */
select Ename
from Employee
where exists (select * from EmployeesEnrolled EE  where EE .EmployeeId=Employee.EmployeeId and EE.LocationId!=2)


/*selecteaza toate transporturile in care sunt angajati clienti a caror nume incep cu litera M*/
select Origin,Destination
from Transport
where exists (select * from BookingC C where C.TransportId=Transport.TransportId and C.CustomerId in (select Customer.cid from Customer where Customer.FirstName like 'M%'))


/*2 queries with a subquery in the FROM clause;*/

/*toate locatiile care au obiective turistice*/
select L.Name 
from (Select TOI.LocationId from Things_Of_Interest TOI
      group by TOI.LocationId) rez
inner join Location L ON l.LocationId=rez.LocationId


/*toate tipurile de obiective care sunt folosite*/
select  distinct *
from (select TT.toi_type from TOI_Types TT
      inner join Things_Of_Interest TOI on TT.toi_type=TOI.toi_type)rez


/*H. 4 queries with the GROUP BY clause, 3 of which also contain the HAVING clause; 
2 of the latter will also have a subquery in the HAVING clause;
 use the aggregation operators: COUNT, SUM, AVG, MIN, MAX;*/

 /*companiile care au mai mult de un transport*/
select TC.CompanyId,TC.CompanyName
from TransportCompany TC inner join Transport T on T.CompanyId=TC.CompanyId
group by TC.CompanyId,TC.CompanyName
having count(*)>1


/*numele clientilor care au cele mai multe bookinguri*/
select C.FirstName,C.LastName
from Customer C
Inner join BookingC b on C.cid=b.CustomerId
group by C.FirstName,C.LastName
having COUNT(b.CustomerId)=(select MAX(nr)
					 from ( select count(*) as nr
							from BookingC b1
							group by b1.CustomerId)rez
					)

/*tipurile de transport cele mai putin folosite*/
select tr.trans_type
from TrType tr
inner join TransportCompany tc on tr.trans_type=tc.trans_type
group by tr.trans_type
having COUNT (tc.trans_type)=(select MIN(nr)
					 from ( select count(*) as nr
							from TransportCompany tc1
							group by tc1.trans_type)rez
					)

/*locatiile care sunt vizitate peste medie*/
select c.FirstName,c.LastName,SUM(b.NumberOfAdults) as 'suma',avg(b.NumberOfAdults) as 'avg'
from Customer c
inner join BookingC b on c.cid=b.CustomerId
group by c.FirstName,c.LastName

having  SUM(b.NumberOfAdults) >avg(b.NumberOfAdults)


/*i. 4 queries using ANY and ALL to introduce a subquery in the WHERE clause; 
--2 of them should be rewritten with aggregation operators, 
--while the other 2 should also be expressed with [NOT] IN*/

/*angajatii care sunt m-ai batrani decat angajatul cu numele Marius Pop*/
select Employee.Ename,Employee.Age
from Employee
where Employee.Age>any(select Employee.Age from Employee where Employee.Ename='Marius Pop')

/*rescriere*/

select Employee.Ename,Employee.Age
from Employee
where Employee.Age > (select MIN(Employee.Age) from Employee where Employee.Ename='Marius Pop')


/*selecteaza toti clientii care insotesc copii*/
select c.FirstName,c.LastName
from Customer c,BookingC bc
where c.cid=bc.CustomerId and bc.NumberOfChildren=any(select bc1.NumberOfChildren from BookingC bc1 where bc1.NumberOfChildren is not null)

/*rescriere*/
select c.FirstName,c.LastName
from Customer c,BookingC bc
where c.cid=bc.CustomerId and bc.NumberOfChildren in (select bc1.NumberOfChildren from BookingC bc1 where bc1.NumberOfChildren is not null)


/*selecteaza numarul clientilor care au data de plecare mai tarzie decat orice client care are id-ul 3 sau 4*/
select distinct c.FirstName,c.LastName,c.mobile
from Customer c,BookingC bc
where c.cid=bc.CustomerId and bc.CheckInDate>all(select bc1.CheckInDate from BookingC bc1 where bc1.CustomerId=3 or bc1.CustomerId=4)

select distinct c.FirstName,c.LastName,c.mobile
from Customer c,BookingC bc
where c.cid=bc.CustomerId and bc.CheckInDate>(select max(bc1.CheckINDate) from BookingC bc1 where bc1.CustomerId=3 or bc1.CustomerId=4)


/*toate obiectivele care nu se afla in Londra*/
select toi.toi_name,l.Name
from Things_Of_Interest toi,Location l
where toi.LocationId=l.LocationId and l.name<>all(select l1.name from Location l1 where l1.Name='London')
order by l.Name


/*rescriere*/
select toi.toi_name,l.Name
from Things_Of_Interest toi,Location l
where toi.LocationId=l.LocationId and l.name not in (select l1.name from Location l1 where l1.Name='London')
*/
