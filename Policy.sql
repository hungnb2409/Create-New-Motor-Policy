CREATE DATABASE Test
GO
USE Test
GO
CREATE TABLE client(
	id int IDENTITY(1,1) NOT NULL,
	clientnumber  AS ('CN'+right('000000'+CONVERT([varchar](6),[ID]),(6))) PERSISTED NOT NULL PRIMARY KEY,
	firstname nvarchar(60) NOT NULL,
	lastname nvarchar(60) NOT NULL,
	gender varchar(30) NOT NULL,
	dateofbirth date NOT NULL,
	indentitynumber varchar(30) NOT NULL,
	maritalstatus varchar(30) NOT NULL,
	address nvarchar(120) NOT NULL,
	country varchar(30) NOT NULL,
)

CREATE TABLE motor(
	id [INT] IDENTITY(1,1) NOT NULL,
	policyno AS ('MT'+right('000000'+CONVERT([varchar](6),[ID]),(6))) PERSISTED NOT NULL PRIMARY KEY,
	inceptiondate DATE NOT NULL,
	expirydate DATE NOT NULL,
	policyowner VARCHAR(8) NOT NULL,
	engineno VARCHAR(30) NOT NULL,
	chassisno VARCHAR(30) NOT NULL,
	vehicleregistrationno VARCHAR(30) NOT NULL,
	billingcurrency VARCHAR(30) NOT NULL,
	suminsured NUMERIC(17,2) NOT NULL,
	rate NUMERIC(7,5) NOT NULL,
	annualpremium NUMERIC(17,2) NULL,
	postedpremium NUMERIC(17,2) NULL,

)
ALTER TABLE motor ADD CONSTRAINT fk_motor_client FOREIGN KEY (policyowner) REFERENCES client(clientnumber);

ALTER TABLE motor ADD status VARCHAR(15);

DROP TABLE motor 
DROP TABLE client

SET IDENTITY_INSERT client ON
INSERT INTO client (id, firstname, lastname, gender, dateofbirth, indentitynumber, maritalstatus, address, country) VALUES (1, N'Luan', N'Nguyen Thanh', 'Male', CAST(N'1999-12-01' AS Date), N'175409876', 'Single', N'15 Dinh Tien Hoang', 'Viet Nam');
INSERT INTO client (id, firstname, lastname, gender, dateofbirth, indentitynumber, maritalstatus, address, country) VALUES (2, N'Mai', N'Bui Thi Ngoc', 'Female', CAST(N'1999-12-12' AS Date), N'165809345', 'Single', N'136 Dong Da', 'United Staties')
INSERT INTO client (id, firstname, lastname, gender, dateofbirth, indentitynumber, maritalstatus, address, country) VALUES (3, N'An', N'Nguyen Thi Thinh', 'Female', CAST(N'1999-12-21' AS Date), N'200377765', 'Divorced', N'32 Wall Street', 'Singapore')
INSERT INTO client (id, firstname, lastname, gender, dateofbirth, indentitynumber, maritalstatus, address, country) VALUES (4, N'Nguyen', N'Vu', 'Male', CAST(N'2000-04-30' AS Date), N'340989875', 'Married', N'03 Washington', 'Viet Nam')
