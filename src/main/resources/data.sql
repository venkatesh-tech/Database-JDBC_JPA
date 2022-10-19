create table person
(
	id integer not null,
	name varchar(255) not null,
	location varchar(255),
	birth_date timestamp,
	primary key(id)
);

INSERT INTO person VALUES(10001,'Venkatesh','Nidadavole',sysdate());
INSERT INTO PERSON VALUES(10002,'James','New York',sysdate());
INSERT INTO PERSON VALUES(10003,'Peter','Amsterdam',sysdate());
INSERT INTO PERSON VALUES(10004,'Frank','New Jersy',sysdate());