create database gofynd;
create table ItemMaster(itemId int primary key  auto_increment,itemName varchar(100) unique) engine=InnoDB;

create table ShadeMaster(shadeId int primary key auto_increment,shadeName varchar(50) unique) engine=InnoDB;

create table SizeMaster(sizeId int primary key auto_increment,	 varchar(25) unique) engine=InnoDB;

create table Stock(stockId int primary key,itemId int unique,shadeId int,mrp decimal(6,2),
foreign key(itemId) references ItemMaster(itemId)  ON DELETE SET NULL ON UPDATE CASCADE,
foreign key(shadeId) references ShadeMaster(shadeId) ON DELETE SET NULL ON UPDATE CASCADE
) engine=InnoDB;

create table ItemSizeWiseQuantity(id int primary key,stockId int,sizeId int,quantity int,
foreign key(stockId) references Stock(stockId) ON DELETE CASCADE 
) engine=InnoDB;

#File changed