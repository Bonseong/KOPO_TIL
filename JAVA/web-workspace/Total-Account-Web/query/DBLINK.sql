DROP DATABASE LINK MG;
CREATE DATABASE LINK MG CONNECT TO DA2114 IDENTIFIED BY "da14" USING -- �α�
'(DESCRIPTION=
 (ADDRESS_LIST=
  (ADDRESS=(PROTOCOL=TCP)(HOST=192.168.217.202)(PORT=1521))
 )
 (CONNECT_DATA=
 (SERVICE_NAME=KOPODA)
 )
)'; 

DROP DATABASE LINK WC;
CREATE DATABASE LINK WC CONNECT TO DA2117 IDENTIFIED BY "da17" USING -- �ظ�
'(DESCRIPTION=
 (ADDRESS_LIST=
  (ADDRESS=(PROTOCOL=TCP)(HOST=192.168.217.202)(PORT=1521))
 )
 (CONNECT_DATA=
 (SERVICE_NAME=KOPODA)
 )
)'; 

SELECT * FROM EMP@HAEMYEONG;

DROP DATABASE LINK TVA;
CREATE DATABASE LINK TVA CONNECT TO DA2107 IDENTIFIED BY "da07" USING -- �ο�
'(DESCRIPTION=
 (ADDRESS_LIST=
  (ADDRESS=(PROTOCOL=TCP)(HOST=192.168.217.202)(PORT=1521))
 )
 (CONNECT_DATA=
 (SERVICE_NAME=KOPODA)
)
)';