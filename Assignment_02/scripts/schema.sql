drop table if exists persons;

CREATE TABLE PERSONS(
	ID INT PRIMARY KEY AUTO_INCREMENT,
	FIRSTNAME VARCHAR(50) NOT NULL,
	LASTNAME VARCHAR(50),
	EMAIL VARCHAR(255),
	PHONE VARCHAR(255),
	CONSTRAINT EMAIL_UNIQUE UNIQUE(EMAIL),
	CONSTRAINT PHONE_UNIQUE UNIQUE(PHONE)
);


insert into persons values 
(null, 'Vinod', 'Kumar', 'vinod@vinod.co', '9731424784'),
(null, 'Shyam', 'Sundar', 'shymakc@example.com', '9731425566'),
(null, 'John', 'Doe', 'johndoe@example.com', '5551424784');
