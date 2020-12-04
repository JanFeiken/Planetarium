DROP TABLE IF EXISTS TEST;
CREATE TABLE TEST(ID INT PRIMARY KEY,
   NAME VARCHAR(255));
INSERT INTO TEST VALUES(1, 'Hello');
INSERT INTO TEST VALUES(2, 'World');
SELECT * FROM TEST ORDER BY ID;
UPDATE TEST SET NAME='Hi' WHERE ID=1;
DELETE FROM TEST WHERE ID=2;

DROP TABLE IF EXISTS CALC_TIME;
CREATE TABLE CALC_TIME(TIME NUMERIC(20,10));
INSERT INTO CALC_TIME(TIME) VALUES(-0.0772210814510609);
SELECT TIME FROM CALC_TIME;

DROP TABLE IF EXISTS TIME_TAB;
CREATE TABLE TIME_TAB(TIME NUMERIC(20,10),
       TIME2 NUMERIC(20,10),
       TIME3 NUMERIC(20,10),
       TIME4 NUMERIC(20,10)
);

INSERT INTO TIME_TAB (TIME,TIME2,TIME3,TIME4)
SELECT TIME
, POWER(TIME,2)
, POWER(TIME,3)
, POWER(TIME,4)
FROM CALC_TIME;

SELECT *
FROM TIME_TAB
;


DROP TABLE IF EXISTS TERMS;
CREATE TABLE TERMS(SERIE INT,
	NBR INT,
	TERM1 NUMERIC(20,10),
        TERM2 NUMERIC(20,10)
);
INSERT INTO TERMS (SERIE,NBR,TERM1,TERM2) VALUES(1,1,20.1234567890,123.4567890);
INSERT INTO TERMS (SERIE,NBR,TERM1,TERM2) VALUES(1,2,30.0987654321,67432.7865432);
INSERT INTO TERMS (SERIE,NBR,TERM1,TERM2) VALUES(1,3,88.0987654321,67432.7865432);
SELECT * FROM TERMS ORDER BY SERIE ASC, NBR ASC;
SELECT SERIE, NBR, TERM1, TERM2, TERM1 + TERM2 AS "TOTAL", SIN((TERM1/180)*3.141592) AS "CALC" FROM TERMS ;

