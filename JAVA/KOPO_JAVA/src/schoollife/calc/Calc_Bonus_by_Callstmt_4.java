package schoollife.calc;

import java.sql.*;
public class Calc_Bonus_by_Callstmt_4 {
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
			    		 "BEGIN  " +
			    	 	 "	INSERT INTO BONUS_LARGE(YYYYMM,EMPNO,JOB,DEPTNO,SAL,BONUS)" +
			    	 	 "	SELECT  ?, EMPNO,JOB,DEPTNO,SAL, 			  " +
			    	 	 "		ROUND(DECODE(DEPTNO,10,0.3,	     " +
			    	 	 "                                  20,0.1,	     " +
			    	 	 "                                  30,0.05,	     " +
			    	 	 "                                  40,0.2,	     " +
			    	 	 "                                       0) * SAL )  " + 
			    	 	 "	FROM   EMP_LARGE			     " +
			    	 	 "	WHERE  JOB <> 'PRESIDENT';                   " +
                                         "                                                   " +
			    	         "      COMMIT;	  	                             " +	// 100만건 INSERT후 COMMIT;
			    	 	 "END;                                               ";                     

			    			    
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
