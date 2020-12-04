DROP TABLE IF EXISTS STARS;
CREATE TABLE STARS(ID INT,
	CONSTELLATION VARCHAR(255),
	STAR_NAME VARCHAR(255),
	HOUR VARCHAR(2),
	MINUTES VARCHAR(2),
	SECONDS VARCHAR(30),
	DEGREES VARCHAR(5),
	ARC_MINUTES VARCHAR(2),
	ARC_SECONDS VARCHAR(30),
	MAGNITUDE VARCHAR(6),
	SPECTRUM VARCHAR(2),
	MULTI VARCHAR(1)
);


INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(0,'Test','Test Star','20','14','32.27','-8','12','5.9','0.18','3','d');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(1,'Orion','Rigel','5','14','32.27','-8','12','5.9','0.18','3','d');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(2,'Orion','Betelgeuse','5','55','10.29','7','24','25.3','0.42','4','d');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(3,'Orion','Bellatrix','5','25','7.87','6','20','59.0','1.64','3','s');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(4,'Orion','Alnilam','5','36','12.81','-1','12','6.9','1.69','3','s');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(5,'Orion','Alnitak A','5','40','45.52','-1','56','33.3','1.88','5','d');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(6,'Orion','Saip','5','47','45.39','-9','40','10.6','2.07','3','s');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(7,'Orion','Mintaka AB','5','32','0.40','-0','17','56.7','2.20','5','d');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(8,'Orion','Meissa A','5','35','8.28','9','56','3','3.47','3','d');


INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(9,'Ursa Minor','Polaris','2','31','47.08','89','15','50.9','1.97','3','d');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(10,'Ursa Minor','Kochab','14','50','42.40','74','9','19.7','2.07','6','s');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(11,'Ursa Minor','Pherkad','15','20','43.75','71','50','2.3','3.04','0','s');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(12,'Ursa Minor','Yildun','17','32','12.90','86','35','10.8','4.35','0','s');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(13,'Ursa Minor','RS CVn','16','45','58.16','82','2','14.1','4.21','0','d');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(14,'Ursa Minor','Ahfa','15','44','3.46','77','47','40.2','4.29','0','s');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(15,'Ursa Minor','11 UMi','15','17','5.88','71','49','26.0','5.02','6','s');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(16,'Ursa Minor','5 UMi','14','27','31.52','75','41','45.4','4.25','6','d');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(17,'Ursa Minor','RR UMi','14','57','35.12','65','55','56.6','4.63','3','d');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(18,'Ursa Minor','Anwar','16','17','30.50','75','45','16.9','4.95','3','s');



INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(19,'Test','d0','10','30','0','0','0','0','5','0','s');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(20,'Test','dm10','10','30','0','-10','0','0','5','0','s');


INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(21,'Test','o10','5','30','0','100','0','0','5','0','s');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(22,'Test','. 90','5','30','0','90','0','0','5','0','s');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(23,'Test','. 80','5','30','0','80','0','0','5','0','s');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(24,'Test','. 70','5','30','0','70','0','0','5','0','s');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(25,'Test','. 60','5','30','0','60','0','0','5','0','s');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(26,'Test','. 50','5','30','0','50','0','0','5','0','s');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(27,'Test','. 40','5','30','0','40','0','0','5','0','s');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(28,'Test','. 30','5','30','0','30','0','0','5','0','s');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(29,'Test','. 20','5','30','0','20','0','0','5','0','s');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(30,'Test','. 10','5','30','0','10','0','0','5','0','s');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(31,'Test','. 0','5','30','0','0','0','0','5','0','s');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(32,'Test','. -10','5','30','0','-10','0','0','5','0','s');

INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(33,'Test','t0','10','30','0','70','0','0','1.81','0','s');

INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(34,'Test','t0','10','30','0','70','0','0','1.81','0','s');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(35,'Test','t1','11','0','0','70','0','0','1.81','0','s');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(36,'Test','t2','11','30','0','70','0','0','1.81','0','s');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(37,'Test','t3','12','0','0','70','0','0','1.81','0','s');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(38,'Test','t4','12','30','0','70','0','0','1.81','0','s');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(39,'Test','t5','13','0','0','70','0','0','1.81','0','s');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(40,'Test','t6','13','30','0','70','0','0','1.81','0','s');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(41,'Test','t7','14','0','0','70','0','0','1.81','0','s');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(42,'Test','t8','14','30','0','70','0','0','1.81','0','s');

INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(43,'Ursa Major','Dubhe','11','3','43.84','61','45','4.0','1.81','6','d');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(44,'Ursa Major','Merak','11','1','50.39','56','22','56.4','2.34','0','s');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(45,'Ursa Major','Phecda','11','53','49.74','53','41','41.0','2.41','0','s');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(46,'Ursa Major','Megrez','12','15','25.45','57','1','57.4','3.32','0','s');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(47,'Ursa Major','Alioth','12','54','1.63','55','57','35.4','1.76','0','s');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(48,'Ursa Major','Mizar','13','23','55.54','54','55','31.3','2.23','0','d');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(49,'Ursa Major','Alcor','13','25','13.54','54','59','16.7','3.99','0','s');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(50,'Ursa Major','Alkaid','13','47','32.55','49','18','47.9','1.85','3','s');



INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(51,'Cassiopeia','Schedar','0','40','30.39','56','32','14.7','2.24','6','d');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(52,'Cassiopeia','Caph','0','9','10.09','59','9','0.8','2.28','1','d');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(53,'Cassiopeia','Tsih','0','56','42.50','60','43','0.3','2.15','3','d');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(54,'Cassiopeia','Ruchbah','1','25','48.60','60','14','7.5','2.68','0','s');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(55,'Cassiopeia','Segin','1','54','23.68','63','40','12.5','3.35','3','s');

INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(56,'Pleiades','Celæno','3','44','48.2151419452','24','17','22.093878203','5.46','3','s');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(57,'Pleiades','Electra','3','44','52.5368818','24','6','48.011217','3.70','3','s');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(58,'Pleiades','Taygeta','3','45','12.4957802','24','28','2.209730','4.30','3','s');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(59,'Pleiades','Maia','3','45','49.6065620','24','22','3.886360','3.87','3','s');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(60,'Pleiades','Asterope 1','3','45','54.4767610858','24','33','16.241816694','5.80','3','s');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(61,'Pleiades','Asterope 2','3','46','2.9003043108','24','31','40.431321794','6.43','3','s');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(62,'Pleiades','Merope','3','46','19.5738428','23','56','54.081244','4.18','3','s');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(63,'Pleiades','Alcyone','3','47','29.0765529','24','6','18.488347','2.90','3','s');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(64,'Pleiades','Atlas','3','49','9.7425852','24','3','12.300277','3.62','3','s');
INSERT INTO STARS (ID, CONSTELLATION, STAR_NAME, HOUR, MINUTES, SECONDS, DEGREES, ARC_MINUTES, ARC_SECONDS, MAGNITUDE, SPECTRUM, MULTI) VALUES(65,'Pleiades','Pleione','3','49','11.2175463444','24','8','12.172181348','5.09','3','s');











