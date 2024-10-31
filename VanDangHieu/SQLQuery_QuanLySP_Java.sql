create database QLSanpham;

go

use QLSanpham;

go

create table LoaiSP	 (
	Maloai char(2) primary key,
	TenLoai nvarchar(20),
);

go

create table Sanpham (
	MaSP char(4) primary key,
	TenSP nvarchar(20),
	Dongia bigint,
	Maloai char(2) foreign key references LoaiSP(Maloai),
);

INSERT INTO LoaiSP
VALUES
	('BK','Bánh kẹo'),
	('GK','Giải khát'),
	('MP','Mỹ phẩm')

go

insert into Sanpham
values
	('SP01', 'Bánh mì', 10000, 'BK'),
	('SP02', 'Bánh bao', 15000, 'BK'),
	('SP03', 'Coca Cola', 12000, 'GK'),
	('SP04', 'Pepsi', 11000, 'GK'),
	('SP05', 'Kem chộn', 85000, 'MP')


SELECT * FROM Sanpham