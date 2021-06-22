package schoollife.calc;

import java.sql.*;
public class Calc_Bonus_by_Callstmt_3 {
	  public static void main(String []args) {
		    Connection 	conn      = null;

		    CallableStatement  cstmt = null; 
		    
	
		    String		Url    = "jdbc:oracle:thin:@192.168.119.119:1521/dink";
		    String		Id     = "SCOTT";
		    String		Pwd    = "TIGER";
		    String		yyyymm = "201807";	
		    
	
		    try{
		    	
		    	long startTime = System.currentTimeMillis();	// 시작 시간 측정
		    	
		    	// [1단계] JDBC Driver 로딩 
		    	Class.forName("oracle.jdbc.driver.OracleDriver");
		    	
		    	// [2단계] DBMS 접속 
		    	conn = DriverManager.getConnection(Url, Id,Pwd);
		      	conn.setAutoCommit(false);					    // 자동 commit을  off 한다.   
		      	
		    	// [3단계] SQL 생성 
			    String  PLstr = ""+ 
			    		 "DECLARE " +
			    	 	    " CURSOR  BONUS_CUR IS " +
			    	 	    "        SELECT EMPNO,JOB,DEPTNO,SAL FROM EMP_LARGE " + 
			    	 	    "	     WHERE  JOB <> 'PRESIDENT'; " +
                                            "                                                                           "+
			    	 	    " TYPE T_EMPNO  IS TABLE OF EMP_LARGE.EMPNO%TYPE   INDEX BY BINARY_INTEGER; "+
			    	 	    " TYPE T_JOB    IS TABLE OF EMP_LARGE.JOB%TYPE     INDEX BY BINARY_INTEGER; "+
			    	 	    " TYPE T_DEPTNO IS TABLE OF EMP_LARGE.DEPTNO%TYPE  INDEX BY BINARY_INTEGER; "+
			    	 	    " TYPE T_SAL    IS TABLE OF EMP_LARGE.SAL%TYPE     INDEX BY BINARY_INTEGER; "+
			    	 	    " TYPE T_BONUS  IS TABLE OF BONUS_LARGE.BONUS%TYPE INDEX BY BINARY_INTEGER; "+
                                            "                                                                           "+
			    	   	    " V_ARRAYSIZE	NUMBER(10) :=  1000;	   " +     // ArraySize
			    	   	    " V_EMPNO		T_EMPNO;		   " +
			    	   	    " V_JOB		T_JOB;			   " +
			    	   	    " V_DEPTNO		T_DEPTNO;		   " +
			    	   	    " V_SAL		T_SAL;		            " +
			    	   	    " V_BONUS  		T_BONUS;		   " +
			    	 	    "BEGIN  					   " +
			    	 	    "       OPEN 	BONUS_CUR; 		   " +
			    	 	    "       LOOP   				   " +
			    	 	    "           FETCH BONUS_CUR BULK COLLECT "+
			    	 	    "	            INTO V_EMPNO,V_JOB,V_DEPTNO,V_SAL LIMIT V_ARRAYSIZE;"+
			    	 	    "		FOR I IN 1..V_DEPTNO.COUNT		     "+
			    	 	    "		LOOP					     "+
			    	           "		IF    V_DEPTNO(I)=10 THEN		     "+ 
			    	 	    "				V_BONUS(I) := V_SAL(I)*0.3;  "+
			    	 	    "		ELSIF V_DEPTNO(I)=20 THEN                    "+
			    	 	    "				V_BONUS(I) := V_SAL(I)*0.1;  "+
			    	 	    "		ELSIF V_DEPTNO(I)=30 THEN                    "+
			    	 	    "				V_BONUS(I) := V_SAL(I)*0.05; "+
			    	 	    "		ELSIF V_DEPTNO(I)=40 THEN                    "+
			    	 	    "				V_BONUS(I) := V_SAL(I)*0.2;  "+
			    	 	    "		ELSE                                         "+
			    	 	    "				V_BONUS(I) := V_SAL(I)*0;    "+
			    	 	    "		END IF;                                      "+
			    	 	    "		END LOOP;                                    "+
			    	 	    "                                                        "+
			    	 	    "		FORALL I IN 1..V_DEPTNO.COUNT                "+
			    	 	    "               INSERT INTO BONUS_LARGE(YYYYMM,EMPNO,JOB,DEPTNO,SAL,BONUS)            "+
			    	 	    "               VALUES(?,V_EMPNO(I),V_JOB(I),V_DEPTNO(I),V_SAL(I),ROUND(V_BONUS(I))); "+
                                            "                                                                        "+
			    	 	    "           EXIT  WHEN BONUS_CUR%NOTFOUND;                                  "+
			    	 	    "      END LOOP; 		                    "+
			    	 	    "      CLOSE  BONUS_CUR;                        "+
			    	 	    "      COMMIT;	       " +   // 100만건 INSERT후 COMMIT;
			    	 	    "END;    ";   

			    			    
		       	cstmt = conn.prepareCall(PLstr);
		    	cstmt.setString(1, yyyymm);
		       	
	       	    // [4단계] SQL 실행(PL/SQL 블럭 전송)
		       	cstmt.execute();
		       
		       	long endTime = System.currentTimeMillis();	  // 종료 시간 측정
		        System.out.println("경과시간 : " + (endTime - startTime)/1000 +"초"); 
		       	
			 }catch(Exception e){
						System.out.println("Oracle JDBC Connection Exception");
						e.printStackTrace();
			 }finally{
				  // [5단계] Resource 반납
				   if(cstmt != null)     try{ cstmt.close();     } catch(SQLException sqle){}
				   if(conn != null)      try{ conn.close();      } catch(SQLException sqle){}			        		
		     } // End try 
		   } //End Main
	
}// End Class
