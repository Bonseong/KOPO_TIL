library(DBI)
library(RODBC)
library(tidyverse)
db <- odbcConnect("DSN", uid="scott", pwd="tiger")
query<-"CREATE TABLE SEOUL_RANK AS
(SELECT 지역구, COUNT(지역구) AS 갯수, RANK() OVER (ORDER BY COUNT(지역구) DESC) AS 순위
FROM (
SELECT NVL(TRIM(SUBSTR(소재지전체주소, INSTR(소재지전체주소, ' ', 1, 1), INSTR(소재지전체주소, ' ', 1, 2)-INSTR(소재지전체주소, ' ', 1, 1))),
TRIM(SUBSTR(도로명전체주소, INSTR(도로명전체주소, ' ', 1, 1), INSTR(도로명전체주소, ' ', 1, 2)-INSTR(도로명전체주소, ' ', 1, 1)))) AS 지역구
FROM SEOUL
WHERE TRIM(SUBSTR(소재지전체주소, 0, INSTR(소재지전체주소, ' ', 1, 1))) = '서울특별시' OR
    TRIM(SUBSTR(도로명전체주소, 0, INSTR(도로명전체주소, ' ', 1, 1))) = '서울특별시') 
    GROUP BY 지역구);"
sqlQuery(db,query)


query2<-"CREATE TABLE CUSTOMER_SEOUL AS
    (SELECT NAME, MOBILE_NO, TRIM(SUBSTR(ADDRESS1, INSTR(ADDRESS1, ' ', 1, 1), INSTR(ADDRESS1, ' ', 1, 2)-INSTR(ADDRESS1, ' ', 1, 1))) AS 지역구
    FROM CUSTOMER
    WHERE SUBSTR(ADDRESS1, 0, 2) = '서울');"
sqlQuery(db,query2)

query3<-"SELECT C.NAME, C.MOBILE_NO, R.순위, R.지역구 FROM SEOUL_RANK R, CUSTOMER_SEOUL C
WHERE (R.지역구 = C.지역구) AND 순위<4;"

output<-sqlQuery(db,query3)



query4<-"SELECT * FROM SEOUL_RANK;"
seoul_rank<-sqlQuery(db, query4)
seoul_rank
seoul_rank<-seoul_rank[1:25,]

ggplot(seoul_rank, aes(x=reorder(지역구,-갯수), y=갯수))+geom_bar(stat='identity', fill='skyblue')+geom_text(aes(y=갯수, label=갯수), vjust=-0.5)+
  xlab('지역구')+ylab('대기오염물질배출사업장 갯수')+ggtitle('지역별 대기오염물질배출사업장 현황')+
  theme(axis.text.x=element_text(angle=30))+theme(plot.title = element_text(family = "serif", face = "bold", hjust = 0.5, size = 15, color = "darkblue"))
  
