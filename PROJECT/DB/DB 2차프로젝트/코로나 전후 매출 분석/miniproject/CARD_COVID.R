library(DBI)
library(RODBC)
library(tidyverse)
library(scales)
library(Hmisc)
library(corrplot)


db <- odbcConnect("DSN", uid="scott", pwd="tiger")


# 3-1 19년 2~3월 vs 20년 2~3월 (대구 대유행)
query<-"SELECT * FROM CARD_COVID
WHERE DATEREP BETWEEN TO_DATE('19/02/01') AND TO_DATE('19/03/31') OR
    DATEREP BETWEEN TO_DATE('20/02/01') AND TO_DATE('20/03/31')
ORDER BY DATEREP;"


card_covid1<-sqlQuery(db, query)


summary(card_covid1[1:59,6:18])
summary(card_covid1[60:length(card_covid1),6:18])

write.csv(card_covid1[1:59,6:18], 'before_covid.csv')
write.csv(card_covid1[60:length(card_covid1),6:18], 'after_covid.csv')


query1<-"SELECT 업종대분류, PERIOD, ROUND(AVG(카드결제건수),2) AS 평균카드결제건수 FROM(
SELECT 업종대분류, 카드결제건수, CASE
    WHEN DATEREP <TO_DATE('19/03/31') THEN '코로나 유행 이전' ELSE '코로나 유행 이후' END AS PERIOD  FROM CARD
WHERE DATEREP BETWEEN TO_DATE('19/02/01') AND TO_DATE('19/03/31') OR
    DATEREP BETWEEN TO_DATE('20/02/01') AND TO_DATE('20/03/31'))
GROUP BY PERIOD, 업종대분류
ORDER BY PERIOD, 업종대분류;"

df1<-sqlQuery(db,query1)
df1$PERIOD=factor(df1$PERIOD, levels = rev(c('코로나 유행 이전', '코로나 유행 이후')))


ggplot(df1, aes(x=factor(업종대분류), y=평균카드결제건수, fill=factor(PERIOD, levels = rev(c('코로나 유행 이전', '코로나 유행 이후'))))) + 
  geom_bar(stat="identity", position="dodge")+scale_x_discrete(limits=c('가전/가구', '가정생활/서비스', '교육/학원', '미용', '스포츠/문화/레저', '여행/교통', '음/식료품', '자동차', '주유', '패션/잡화'))+
  geom_text(aes(y=평균카드결제건수, label=평균카드결제건수),  position = position_dodge(width = 1), hjust=0)+
  xlab('업종대분류')+ylab('평균 카드 결제 건수 (단위 : 천)')+labs(fill = "범례")+coord_flip(ylim=c(0,2100))+ 
  guides(fill = guide_legend(reverse = TRUE))+ggtitle("코로나19 1차 대유행 전후 업종대분류별 평균 카드 결제 건수 변화")+theme(plot.title = element_text(family = "serif", face = "bold", hjust = 0.5, size = 20, color = "darkblue"))+
  theme(axis.text.x = element_text(color = "grey20", size = 10, angle = 45, hjust = .5, vjust = .5, face='bold'),
        axis.text.y = element_text(color = "grey20", size = 15, angle = 0, hjust = 1, vjust = 0, face='bold'),  
        axis.title.x = element_text(color = "grey20", size = 12, angle = 0, hjust = .5, vjust = 0, face='bold'),
        axis.title.y = element_text(color = "grey20", size = 12, angle = 90, hjust = .5, vjust = .5, face='bold'))
  



ggplot(df1, aes(x=factor(업종대분류), y=평균카드결제건수, fill=factor(PERIOD, levels = (c('코로나 유행 이전', '코로나 유행 이후'))))) + 
  geom_bar(stat="identity", position="dodge")+scale_x_discrete(limits=c('요식/유흥', '유통'))+
  geom_text(aes(y=평균카드결제건수, label=평균카드결제건수),  position = position_dodge(width = 1), vjust=-0.5)+coord_cartesian(ylim=c(8000,13000))+
  xlab('업종대분류')+ylab('평균 카드 결제 건수 (단위 : 천)')+labs(fill = "범례")+ 
  guides(fill = guide_legend(reverse = TRUE))+ggtitle("코로나19 1차 대유행 전후 업종대분류별 평균 카드 결제 건수 변화")+theme(plot.title = element_text(family = "serif", face = "bold", hjust = 0.5, size = 20, color = "darkblue"))+
  theme(axis.text.x = element_text(color = "grey20", size = 10, angle = 0, hjust = .5, vjust = .5, face='bold'),
        axis.text.y = element_text(color = "grey20", size = 10, angle = 0, hjust = 1, vjust = 0, face='bold'),  
        axis.title.x = element_text(color = "grey20", size = 12, angle = 0, hjust = .5, vjust = 0, face='bold'),
        axis.title.y = element_text(color = "grey20", size = 12, angle = 90, hjust = .5, vjust = .5, face='bold'))


ggplot(df1, aes(x=factor(업종대분류), y=평균카드결제건수, fill=factor(PERIOD, levels = (c('코로나 유행 이전', '코로나 유행 이후'))))) + 
  geom_bar(stat="identity", position="dodge")+scale_x_discrete(limits=c('의료'))+
  geom_text(aes(y=평균카드결제건수, label=평균카드결제건수),  position = position_dodge(width = 1), vjust=-0.5)+coord_cartesian(ylim=c(2300,2400))+
  xlab('업종대분류')+ylab('평균 카드 결제 건수 (단위 : 천)')+labs(fill = "범례")+ 
  guides(fill = guide_legend(reverse = TRUE))+ggtitle("코로나19 1차 대유행 전후 업종대분류별 평균 카드 결제 건수 변화")+theme(plot.title = element_text(family = "serif", face = "bold", hjust = 0.5, size = 15, color = "darkblue"))+
  theme(axis.text.x = element_text(color = "grey20", size = 10, angle = 0, hjust = .5, vjust = .5, face='bold'),
        axis.text.y = element_text(color = "grey20", size = 10, angle = 0, hjust = 1, vjust = 0, face='bold'),  
        axis.title.x = element_text(color = "grey20", size = 12, angle = 0, hjust = .5, vjust = 0, face='bold'),
        axis.title.y = element_text(color = "grey20", size = 12, angle = 90, hjust = .5, vjust = .5, face='bold'))





query2<- "SELECT * FROM CARD_COVID WHERE CASES > 5 ORDER BY DATEREP;"
df2<-sqlQuery(db, query2)
df2


corrplot(cor(df2[-c(1,2,3,4)]), method="number", order='hclust', sig.level = 0.1)

df2[-c(1,2,3,4)]


corr_output<-rcorr(as.matrix(df2[-c(1,2,3,4)]))
vector(round(corr_output$P, digits=4)[,1])

round(corr_output$P, digits=4)[,1]

as.vector
pairs(df2[-c(1,2,3,4)][6:13], cex.labels=1.7)

pairs(df2[-c(1,2,3,4)], cex.labels = 3)
pairs(df2[-c(1,2,3,4)][c(1,7:13)], cex.labels = 1.7)
