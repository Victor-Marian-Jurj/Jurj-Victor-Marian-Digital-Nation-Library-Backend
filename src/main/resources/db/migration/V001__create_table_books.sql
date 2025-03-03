create table books (
	book_id serial primary key,
	isbn varchar(10) unique not null,
	authors varchar(100) not null,
	title varchar(100) unique not null,
	types varchar(20) not null,
	year int not null,
	description varchar(150) not null
);
