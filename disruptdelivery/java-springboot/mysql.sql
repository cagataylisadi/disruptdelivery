CREATE DATABASE disrupt_delivery;

USE disrupt_delivery;

CREATE TABLE products(
	productid int NOT NULL AUTO_INCREMENT,
	model_name varchar(30) NOT NULL,
	model_no varchar(20) NOT NULL,
	x_in_mm int NOT NULL,
	y_in_mm int NOT NULL,
	z_in_mm int NOT NULL,
	is_breakable int NOT NULL,
	is_perishable int NOT NULL,
	PRIMARY KEY (productid),
	UNIQUE(productid)
);

CREATE TABLE addressbook(
	name varchar(50) NOT NULL,
	street_and_number varchar(30) NOT NULL,
	zipcode varchar(10) NOT NULL,
	city varchar(30) NOT NULL,
	country varchar(20) NOT NULL,
	addressid int NOT NULL AUTO_INCREMENT,
	PRIMARY KEY(addressid),
	UNIQUE(addressid)
);

CREATE TABLE orders(
	send_date datetime NOT NULL,
	sender_address_id int NOT NULL,
	receiver_address_id int NOT NULL,
	productid int NOT NULL,
	orderid int NOT NULL AUTO_INCREMENT,
	label varchar(50) NULL,
	PRIMARY KEY(orderid),
	CONSTRAINT senderIdCons 	FOREIGN KEY (sender_address_id) REFERENCES addressbook(addressid),
	CONSTRAINT receiverIdCons 	FOREIGN KEY (receiver_address_id) REFERENCES addressbook(addressid),
	CONSTRAINT productCons	 	FOREIGN KEY (productid) REFERENCES products(productid),
	UNIQUE(orderid) 
);

CREATE TABLE deliveries(
	expected_delivery_time datetime NOT NULL,
	actual_delivery_time datetime,
	orderid int NOT NULL,
	cost_in_cents int NOT NULL,
	status varchar(45) NOT NULL,
	deliveryid int AUTO_INCREMENT NOT NULL,
	PRIMARY KEY(deliveryid),
	CONSTRAINT orderIdCons FOREIGN KEY (orderid) REFERENCES orders(orderid),
	UNIQUE(deliveryid)
);

CREATE TABLE accounts(
	accountid int AUTO_INCREMENT NOT NULL,
	username varchar(45) NOT NULL,
	password varchar(45) NOT NULL,
	role int NOT NULL,
	PRIMARY KEY(accountid),
	UNIQUE(accountid)
);

INSERT INTO products(model_name,model_no,x_in_mm,y_in_mm,z_in_mm,is_breakable,is_perishable) VALUES ('Granny Smith Apples(5 pc)','GS345',20,25,20,1,1);
INSERT INTO products(model_name,model_no,x_in_mm,y_in_mm,z_in_mm,is_breakable,is_perishable) VALUES ('Bananas(6pc)','BA657',30,35,30,1,1);
INSERT INTO products(model_name,model_no,x_in_mm,y_in_mm,z_in_mm,is_breakable,is_perishable) VALUES ('Red Grapes','RG877',30,35,30,1,1);
INSERT INTO products(model_name,model_no,x_in_mm,y_in_mm,z_in_mm,is_breakable,is_perishable) VALUES ('Grana Padano 171g','GP907',10,10,10,1,1);
INSERT INTO products(model_name,model_no,x_in_mm,y_in_mm,z_in_mm,is_breakable,is_perishable) VALUES ('Halloumi 201g','HA146',10,10,10,1,1);
INSERT INTO products(model_name,model_no,x_in_mm,y_in_mm,z_in_mm,is_breakable,is_perishable) VALUES ('Chupa Chups Lollys(17 pc)','CH947',40,45,40,1,1);
INSERT INTO products(model_name,model_no,x_in_mm,y_in_mm,z_in_mm,is_breakable,is_perishable) VALUES ('Ferrero Rocher(17 pc)','FR154',40,45,40,1,1);
INSERT INTO products(model_name,model_no,x_in_mm,y_in_mm,z_in_mm,is_breakable,is_perishable) VALUES ('Pringles Originals 166g','PO768',50,55,50,1,1);
INSERT INTO products(model_name,model_no,x_in_mm,y_in_mm,z_in_mm,is_breakable,is_perishable) VALUES ('Guacamole mild 151g','GM397',15,20,15,0,1);
INSERT INTO products(model_name,model_no,x_in_mm,y_in_mm,z_in_mm,is_breakable,is_perishable) VALUES ('Coca-Cola Zero 26cl 8-pack','CZ478',70,75,70,0,1);
INSERT INTO products(model_name,model_no,x_in_mm,y_in_mm,z_in_mm,is_breakable,is_perishable) VALUES ('Green Grapes','GG938',30,35,30,1,1);
INSERT INTO products(model_name,model_no,x_in_mm,y_in_mm,z_in_mm,is_breakable,is_perishable) VALUES ('Douwe Egberts Caramel Latte','DE468',10,15,10,0,1);
INSERT INTO products(model_name,model_no,x_in_mm,y_in_mm,z_in_mm,is_breakable,is_perishable) VALUES ('Nurofen Ibuprofen 201mg','NI545',15,20,15,0,1);
INSERT INTO products(model_name,model_no,x_in_mm,y_in_mm,z_in_mm,is_breakable,is_perishable) VALUES ('Tempo Tissues Box Original','TT879',15,20,15,0,0);
INSERT INTO products(model_name,model_no,x_in_mm,y_in_mm,z_in_mm,is_breakable,is_perishable) VALUES ('Glorix Original 751ml','GO567',75,80,75,0,1);
INSERT INTO products(model_name,model_no,x_in_mm,y_in_mm,z_in_mm,is_breakable,is_perishable) VALUES ('Tefal Grill Raclette ','TG924',100,120,100,1,0);
INSERT INTO products(model_name,model_no,x_in_mm,y_in_mm,z_in_mm,is_breakable,is_perishable) VALUES ('Eggs(11 pcs)','EG153',60,65,60,1,1);
INSERT INTO products(model_name,model_no,x_in_mm,y_in_mm,z_in_mm,is_breakable,is_perishable) VALUES ('Chocomel 26cl','CH683',5,10,5,0,1);
INSERT INTO products(model_name,model_no,x_in_mm,y_in_mm,z_in_mm,is_breakable,is_perishable) VALUES ('Oatly Calcium Oatmilk 2L','OO807',85,90,85,0,1);
INSERT INTO products(model_name,model_no,x_in_mm,y_in_mm,z_in_mm,is_breakable,is_perishable) VALUES ('Tiramisu','TI365',10,15,10,0,1);

