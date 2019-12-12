DROP TABLE IF EXISTS TEACHERS;
 
CREATE TABLE TEACHERS (
  ID            INT(3)     		NOT NULL AUTO_INCREMENT,
  NAME   		VARCHAR(250)  	NOT NULL,
  PRIMARY KEY (ID),
  UNIQUE KEY (NAME)
);

DROP TABLE IF EXISTS COURSES;
 
CREATE TABLE COURSES (
  ID             INT(3)	        NOT NULL AUTO_INCREMENT,
  TITLE   		VARCHAR(250)  	NOT NULL,
  LEVEL			VARCHAR(80)  	NOT NULL,
  HOURS		   	INT(3)  		NULL,
  TEACHERID		INT(3) 		 	NOT NULL,
  STATE		 	INT(1)  		NULL,
  PRIMARY KEY (ID),
  UNIQUE KEY (TITLE),
  FOREIGN KEY (TEACHERID) REFERENCES TEACHERS(ID) 
);



INSERT INTO TEACHERS (NAME) VALUES('Roberto Canales');
INSERT INTO TEACHERS (NAME) VALUES('David Gómez');
INSERT INTO TEACHERS (NAME) VALUES('Alberto Moratilla');
INSERT INTO TEACHERS (NAME) VALUES('Rubén Aguilera');


 
INSERT INTO COURSES (TITLE, LEVEL, HOURS, TEACHERID, STATE) VALUES('Introducción a JSF 2', 'Intermedio', 25, 1, 1);
INSERT INTO COURSES (TITLE, LEVEL, HOURS, TEACHERID, STATE) VALUES('Novedades en Java 8', 'Básico', 10, 2, 1);
INSERT INTO COURSES (TITLE, LEVEL, HOURS, TEACHERID, STATE) VALUES('Java para sistemas', 'Básico', 20, 3, 1);
INSERT INTO COURSES (TITLE, LEVEL, HOURS, TEACHERID, STATE) VALUES('Angular 2', 'Intermedio', 15, 2, 0);
INSERT INTO COURSES (TITLE, LEVEL, HOURS, TEACHERID, STATE) VALUES('Spring Boot', 'Intermedio', 25, 1, 1);
INSERT INTO COURSES (TITLE, LEVEL, HOURS, TEACHERID, STATE) VALUES('OpenShift', 'Básico', 10, 2, 1);
INSERT INTO COURSES (TITLE, LEVEL, HOURS, TEACHERID, STATE) VALUES('SQL', 'Básico', 20, 3, 1);
INSERT INTO COURSES (TITLE, LEVEL, HOURS, TEACHERID, STATE) VALUES('Microservicios', 'Intermedio', 15, 2, 0);
