CREATE DATABASE db;
use db;
CREATE TABLE BookType(
TypeId int primary key auto_increment,
TypeName varchar(50) not null unique,
Description Text,
IsDeleted Bit default 0 
);
CREATE TABLE Book(
BookId int primary key auto_increment,
BookName varchar(100) not null unique,
Title varchar(200) not null,
Author varchar(200) not null,
TotalPages int not null,
check (TotalPages>0),
Content Text not null,
Publisher varchar(100) not null,
Price Decimal(10.2) not null,
check (Price>0),
TypeId int not null,
foreign key(TypeId) references BookType(TypeId),
IsDeleted Bit default 0
);