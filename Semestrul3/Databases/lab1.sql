use [Travel Agency]
create table Hotel(
 IdHotel int primary key not null,
 HotelName varchar(30) not null,
 NrStars int,
 Facilities varchar(100),
 Meals varchar(50),
 Rooms varchar(50)

)
create table TOI_Types
(
  toi_type varchar(10) primary key,
  

)
create table TrType
(
 trans_type varchar(10) primary key not null
)
 
create table TransportCompany
(
  CompanyId int primary key not null,
  CompanyName varchar(30) not null,
  ClassesAv varchar(30),
  trans_type varchar(10) not null
  foreign key(trans_type) references TrType(trans_type)
)
create table Transport(
 TransportId int primary key not null,
 ClassType varchar(20),
 Destination varchar(30) not null,
 DepartureTime time(7) not null,
 ArrivalTime time(7) not null,
 Origin varchar(30),
 CompanyId int references TransportCompany(CompanyId)

)
create table Location
(
  LocationId int primary key not null,
  Name varchar(30),
  Country varchar(30),
  ShortDescription varchar(300)
  
)
create table Things_Of_Interest
(
  TOI_ID int primary key not null,
  toi_type varchar(10) not null,
  toi_name varchar(30),
  toi_opening_hours varchar(30),
  toi_description varchar(100),
  LocationId int  not null,
  foreign key(toi_type) references TOI_Types(toi_type),
  foreign key(LocationId) references Location(LocationId)
)
create table Employee
(
  EmployeeId int primary key not null,
  Ename varchar(30) not null,
  Age int,
  Salary money,
  Adress varchar(30),
  Mobile varchar(30),
  email varchar(30)
 
)
create table EmployeesEnrolled
(
  EmployeeId int, 
  LocationId int,
  Primary Key (EmployeeId,LocationId),
  Foreign key (EmployeeId) references Employee(EmployeeId),
  Foreign key (LocationId) references Location(LocationId)
)
create table Customer
(
  cid int primary key not null,
  FirstName varchar(30) not null,
  LastName varchar(30) not null,
  Mobile varchar(20),
  email varchar(20)



)
create table BookingC
(
  BookingId int primary key not null,
  NumberOfAdults int,
  NumberOfChildren int,
  CheckOutDate date,
  CheckInDate date,
  CustomerId int not null,
  LocationId int not null,
  TransportId int not null,
  foreign key(CustomerId) references Customer(cid),
  foreign key(LocationId) references Location(LocationId),
  foreign key(TransportId) references Transport(TransportId)


)
create table HotelsEnrolled
(
  IdHotel int, 
  BookingId int,
  Primary Key (IdHotel,BookingId),
  Foreign key (BookingId) references BookingC(BookingId),
  Foreign key (IdHotel) references Hotel(IdHotel)
)