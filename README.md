# Java Database Connectivity with Oracle

To connect java application with the oracle database, we need to follow 5 following steps. In this example, we are using Oracle 11g as the database. So we need to know following information for the oracle database:

**Driver class**: The driver class for the oracle database is oracle.jdbc.driver.OracleDriver.

**Connection URL**: The connection URL for the oracle11G database is jdbc:oracle:thin:@localhost:1521:xe where jdbc is the API, oracle is the database, thin is the driver, localhost is the server name on which oracle is running, we may also use IP address, 1521 is the port number and XE is the Oracle service name. You may get all these information from the tnsnames.ora file.

**Username**: The default username for the oracle database is system.
**Password**: It is the password given by the user at the time of installing the oracle database.

```sql

-- Drop Tables
 drop table libros;
 drop table editoriales;

-- Create Tables
 create table libros(
  codigo number(5),
  titulo varchar2(40),
  autor varchar2(30),
  codigoeditorial number(3)
 );
 create table editoriales(
  codigo number(3),
  nombre varchar2(20),
  primary key (codigo)
);

-- Initial Load
insert into editoriales values(1,'Planeta');
insert into editoriales values(2,'Emece');
insert into editoriales values(3,'Siglo XXI');

insert into libros values(100,'El aleph','Borges',1);
insert into libros values(200,'Martin Fierro','Jose Hernandez',2);
insert into libros values(300,'Aprenda PHP','Mario Molina',3);
insert into libros values(400,'Java en 10 minutos',null,5);
insert into libros values(500,'Matematica estas ahi','Paenza',null);

```
