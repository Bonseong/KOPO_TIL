#라이브러리 로드
library(DBI)
library(RODBC)
library(tidyverse)
library(scales)

db <- odbcConnect("DSN", uid="scott", pwd="tiger")


#지역별 신용한도 평균

address_data<-sqlQuery(db, "SELECT REGION, CREDIT_LIMIT FROM (SELECT REPLACE(SUBSTR(ADDRESS1,1,2),'uC', '인천') AS REGION, CREDIT_LIMIT  FROM CUSTOMER);")

head(address_data)


data<-address_data %>%
  group_by(REGION) %>%
  summarise(count=n(), mean = mean(CREDIT_LIMIT)) %>%
  arrange(mean)

head(data)


ggplot(data,aes(x=reorder(REGION,mean), y=mean))+
  geom_bar(stat='identity')+
  geom_text(aes(y=mean, label=round(mean)), vjust=-1)+
  coord_cartesian(ylim=c(2480,2520))+
  xlab('지역')+ylab('평균 신용한도')+
  ggtitle('지역 평균 신용한도')+
  theme(plot.title = element_text(family = "serif", face = "bold", hjust = 0.5, size = 15, color = "darkblue"))


#지역별 성비
gender_data<-sqlQuery(db, "SELECT REGION, GENDER FROM (SELECT REPLACE(SUBSTR(ADDRESS1,1,2),'uC', '인천') AS REGION, GENDER  FROM CUSTOMER);")
head(gender_data)

data2<-gender_data%>%
  group_by(REGION, GENDER)%>%
  summarise(n=n())%>%
  mutate(freq=n/sum(n))

head(data2)

ggplot(data2,aes(factor(1),freq,fill=GENDER))+
  geom_bar(stat='identity')+
  facet_wrap(~REGION, ncol=5)+
  coord_polar(theta='y')+
  geom_text(aes(label=paste(n,"\n","(",percent(freq,1),")")), position=position_fill(vjust=0.5))+
  xlab('')+ylab('')+ggtitle('지역별 가입 성비')+
  theme(plot.title = element_text(family = "serif", face = "bold", hjust = 0.5, size = 30, color = "darkblue"))
