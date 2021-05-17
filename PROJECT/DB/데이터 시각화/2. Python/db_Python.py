#!/usr/bin/env python
# coding: utf-8

# In[815]:


from matplotlib import pyplot as plt
import pyodbc
import pandas as pd
import numpy as np
import json
import folium

import warnings
warnings.filterwarnings(action='ignore')

from branca.element import Template, MacroElement


# ## 데이터 로드

# In[816]:


cnxn = pyodbc.connect("DSN=DSN; uid=scott; pwd=tiger")


# In[817]:


query = '''SELECT 
    ADDRESS, ROUND(AVG(CREDIT_LIMIT),2) AS AVG_CREDIT_LIMIT, ROUND(AVG(AGE),2) AS AVG_AGE,
    count(GENDER) AS COUNT_ALL,
    CONCAT(TO_CHAR(ROUND(count(case when GENDER = 'F' then 1 END)/count(GENDER),4)*100),'%') AS COUNT_FEMALE,
    CONCAT(TO_CHAR(ROUND(count(case when GENDER = 'M' then 1 END)/count(GENDER),4)*100),'%') AS COUNT_MALE,
    CASE
        WHEN COUNT(GENDER)<=20000 THEN '회원 수 적음'
        WHEN COUNT(GENDER)<=50000 THEN '회원 수 보통'
        WHEN COUNT(GENDER)>50000 THEN '회원 수 많음'
    END AS COUNT_STAT,
    CASE
        WHEN COUNT(GENDER)<=20000 THEN 'red'
        WHEN COUNT(GENDER)<=50000 THEN 'orange'
        WHEN COUNT(GENDER)>50000 THEN 'green'
    END AS COUNT_COLOR
FROM(
SELECT 
    REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(RTRIM(SUBSTR(ADDRESS1, 0, INSTR(ADDRESS1, ' ', 1, 2))),
    'uC778천 강화군', '인천 강화군'),
    '강원 홍천uAD70', '강원 홍천군'),
    '강원 삼uCC99시', '강원 삼척시'), 
    '충북 uCDA9주시','충북 충주시'),
    '경기 안uC591시','경기 안양시')
    AS ADDRESS,
    CREDIT_LIMIT,
    TRUNC((SYSDATE - BIRTH_DT) / 365) AS AGE,
    GENDER
    FROM CUSTOMER
)
GROUP BY ADDRESS
ORDER BY ADDRESS;'''


# In[818]:


df = pd.read_sql(query, cnxn)


# In[819]:


df.head()


# In[ ]:





# ## json load

# In[820]:


file_path = "./sigungu.json"


# In[821]:


with open('sigungu.json', encoding='UTF-8') as json_file:
    json_data = json.load(json_file)


# In[822]:


location=pd.DataFrame(json_data).transpose()


# In[823]:


location.reset_index(inplace=True)


# In[824]:


location['ADDRESS']=''
for i in range(len(location)):
    location['ADDRESS'][i] = location['index'][i].replace("서울특별시/", "서울 ").replace("부산광역시/", "부산 "). replace("대구광역시/", "대구 "). replace("인천광역시/", "인천 "). replace("광주광역시/", "광주 "). replace("대전광역시/", "대전 "). replace("울산광역시/", "울산 "). replace("경기도/", "경기 "). replace("강원도/", "강원 "). replace("충청북도/", "충북 "). replace("충청남도/", "충남 "). replace("전라북도/", "전북 "). replace("전라남도/", "전남 "). replace("경상북도/", "경북 "). replace("경상남도/", "경남 "). replace("울산광역시/", "울산 ").replace('제주특별자치도/',"제주 ")


# In[825]:


df_loc=pd.merge(df,location[['lat','long','ADDRESS']], how='right', on='ADDRESS')


# In[826]:


df_loc


# In[827]:


df_loc=df_loc.dropna(axis=0).reset_index()


# In[ ]:





# ## 버블 차트

# In[828]:


cust_map = folium.Map(
    location=[37.413294,127.0016985],
    zoom_start=10)
marker_cluster = MarkerCluster().add_to(cust_map)


# In[829]:


for i in range(len(df_loc)):
    folium.Circle([df_loc['lat'][i],df_loc['long'][i]],
                  radius=df_loc['COUNT_ALL'][i]/10,
                  color='crimson',
                  fill=True,
                  fill_color='crimson',
                  popup=folium.Popup('<strong>' + df_loc['ADDRESS'][i]+'</strong><br>'+
                                       '<strong>''회원수 : ''</strong>'+ str(df_loc['COUNT_ALL'][i])+'<br>'+
                                       '<strong>''범위 : ''</strong>' + df_loc['COUNT_STAT'][i]+'<br>'+
                                       '<strong>''평균나이 : ''</strong>' + str(df_loc['AVG_AGE'][i])+'<br>'+
                                       '<strong>''평균신용한도 : ''</strong>'+ str(round(df_loc['AVG_CREDIT_LIMIT'][i],2)) +'<br>'+
                                       '<strong>''남성회원비율 : ''</strong>' + df_loc['COUNT_MALE'][i]+'<br>'+
                                       '<strong>''여성회원비율 : ''</strong>' + df_loc['COUNT_FEMALE'][i]+'<br>'
                                       , max_width=500)).add_to(cust_map)


# In[830]:


cust_map


# In[840]:


cust_map.save('py_map1.html')


# ## 마커 지도

# In[846]:


cust_map2 = folium.Map(
    location=[37.413294,127.0016985],
    zoom_start=10)
marker_cluster = MarkerCluster().add_to(cust_map2)


# In[847]:


for i in range(len(df_loc)):
    folium.Marker([df_loc['lat'][i],df_loc['long'][i]],
                    icon=folium.Icon(color=df_loc['COUNT_COLOR'][i]),
                    popup=folium.Popup('<strong>' + df_loc['ADDRESS'][i]+'</strong><br>'+
                                       '<strong>''회원수 : ''</strong>'+ str(df_loc['COUNT_ALL'][i])+'<br>'+
                                       '<strong>''범위 : ''</strong>' + df_loc['COUNT_STAT'][i]+'<br>'+
                                       '<strong>''평균나이 : ''</strong>' + str(df_loc['AVG_AGE'][i])+'<br>'+
                                       '<strong>''평균신용한도 : ''</strong>'+ str(round(df_loc['AVG_CREDIT_LIMIT'][i],2)) +'<br>'+
                                       '<strong>''남성회원비율 : ''</strong>' + df_loc['COUNT_MALE'][i]+'<br>'+
                                       '<strong>''여성회원비율 : ''</strong>' + df_loc['COUNT_FEMALE'][i]+'<br>'
                                       , max_width=500)).add_to(cust_map2)


# In[848]:


template = """
{% macro html(this, kwargs) %}

<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>각 지역별 회원 정보</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  
  <script>
  $( function() {
    $( "#maplegend" ).draggable({
                    start: function (event, ui) {
                        $(this).css({
                            right: "auto",
                            top: "auto",
                            bottom: "auto"
                        });
                    }
                });
});

  </script>
</head>
<body>

 
<div id='maplegend' class='maplegend' 
    style='position: absolute; z-index:9999; border:2px solid grey; background-color:rgba(255, 255, 255, 0.8);
     border-radius:6px; padding: 10px; font-size:14px; right: 20px; bottom: 20px;'>
     
<div class='legend-title'>회원 수 범위</div>
<div class='legend-scale'>
  <ul class='legend-labels'>
    <li><span style='background:green;opacity:0.7;'></span>5만명 이상</li>
    <li><span style='background:orange;opacity:0.7;'></span>2만명 이상 5만명 미만</li>
    <li><span style='background:red;opacity:0.7;'></span>2만명 이하</li>
    

  </ul>
</div>
</div>
 
</body>
</html>

<style type='text/css'>
  .maplegend .legend-title {
    text-align: left;
    margin-bottom: 5px;
    font-weight: bold;
    font-size: 90%;
    }
  .maplegend .legend-scale ul {
    margin: 0;
    margin-bottom: 5px;
    padding: 0;
    float: left;
    list-style: none;
    }
  .maplegend .legend-scale ul li {
    font-size: 80%;
    list-style: none;
    margin-left: 0;
    line-height: 18px;
    margin-bottom: 2px;
    }
  .maplegend ul.legend-labels li span {
    display: block;
    float: left;
    height: 16px;
    width: 30px;
    margin-right: 5px;
    margin-left: 0;
    border: 1px solid #999;
    }
  .maplegend .legend-source {
    font-size: 80%;
    color: #777;
    clear: both;
    }
  .maplegend a {
    color: #777;
    }
</style>
{% endmacro %}"""

macro = MacroElement()
macro._template = Template(template)

cust_map2.get_root().add_child(macro)


# In[842]:


cust_map2


# In[849]:


cust_map2.save('py_map2.html')

