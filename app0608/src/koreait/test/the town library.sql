
/* ÀÛ¼ºÀÚ : È«½ÂÈñ */

/* Drop Tables */

DROP TABLE rental CASCADE CONSTRAINTS;
DROP TABLE review CASCADE CONSTRAINTS;
DROP TABLE books CASCADE CONSTRAINTS;
DROP TABLE Customer CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE books
(
	books_No number(5,0) NOT NULL UNIQUE,
	books_Name varchar2(30) NOT NULL,
	books_Juja varchar2(30) NOT NULL,
	books_cps varchar2(30) NOT NULL,
	books_YYYY date NOT NULL,
	books_sangtea char(1) NOT NULL,
	PRIMARY KEY (books_No)
);


CREATE TABLE Customer
(
	Customer_ID varchar2(30) NOT NULL UNIQUE,
	Customer_Name varchar2(30) NOT NULL,
	Customer_Day date NOT NULL,
	Customer_phoneNumber varchar2(30) NOT NULL,
	Customer_loginDay date NOT NULL,
	PRIMARY KEY (Customer_ID)
);


CREATE TABLE rental
(
	rental_No number NOT NULL UNIQUE,
	booksNo_rental number(5,0) NOT NULL UNIQUE,
	CustomerID_rental varchar2(30) NOT NULL UNIQUE,
	rental_startDay date NOT NULL,
	rental_ScheduledDate date NOT NULL,
	rental_finalDay date NOT NULL,
	rental_DaysOverdue date NOT NULL,
	PRIMARY KEY (rental_No)
);


CREATE TABLE review
(
	review_No number NOT NULL UNIQUE,
	booksNo_review number(5,0) NOT NULL UNIQUE,
	CustomerID_review varchar2(30) NOT NULL UNIQUE,
	review_title varchar2(30) NOT NULL,
	review_Details varchar2(5000) NOT NULL,
	review_DateOfCreation date NOT NULL,
	PRIMARY KEY (review_No)
);



/* Create Foreign Keys */

ALTER TABLE rental
	ADD CONSTRAINT booksNo_rental FOREIGN KEY (booksNo_rental)
	REFERENCES books (books_No)
;


ALTER TABLE review
	ADD CONSTRAINT booksNo_review FOREIGN KEY (booksNo_review)
	REFERENCES books (books_No)
;


ALTER TABLE rental
	ADD CONSTRAINT CustomerID_rental FOREIGN KEY (CustomerID_rental)
	REFERENCES Customer (Customer_ID)
;


ALTER TABLE review
	ADD CONSTRAINT CustomerID_review FOREIGN KEY (CustomerID_review)
	REFERENCES Customer (Customer_ID)
;



