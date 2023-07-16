Create database WS_GameStore

use WS_GameStore
Create table Accounts(username varchar(20) primary key, password varchar(20), lastname varchar(20), 
						isAdmin int check(isAdmin=1 or isAdmin=0))
create table Game(gameId int primary key, gameName nvarchar(max), price int, description nvarchar(max))

insert into Accounts(username, password, lastname, isAdmin)
values	('Amayado', '12345', 'Le', 0),
		('Minh', '12345', 'Chau', 1),
		('Hieu', '23456', 'Pham', 0),
		('Han', '12345', 'Chau', 1),
		('Mai', '23456', 'Nguyen', 0);

select * from Accounts
Select * From Accounts Where lastname Like '%Cha%'

Drop table Accounts
drop database WS_GameStore