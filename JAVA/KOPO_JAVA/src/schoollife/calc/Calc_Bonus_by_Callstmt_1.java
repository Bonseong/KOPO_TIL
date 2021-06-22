package schoollife.calc;

import java.sql.*;

public class Calc_Bonus_by_Callstmt_1 {
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
			    	"		 WHERE JOB <> 'PRESIDENT' ; 			    " +
			    	"  V_EMPNO		EMP_LARGE.EMPNO%TYPE;  	" +
			    	"  V_JOB 		EMP_LARGE.JOB%TYPE;    	" +
			    	"  V_DEPTNO		EMP_LARGE.DEPTNO%TYPE; 	" +
			    	"  V_SAL		EMP_LARGE.SAL%TYPE;    	" +
			    	"  V_BONUS		BONUS_LARGE.BONUS%TYPE;	" +
			    	"BEGIN  								" +
			    	"   OPEN 	BONUS_CUR; 				" +
			    	"   LOOP   " +
			    	"        FETCH BONUS_CUR  INTO  V_EMPNO,V_JOB,V_DEPTNO,V_SAL; "+ // 1건씩 FETCH 
			    	"	 EXIT  WHEN BONUS_CUR%NOTFOUND; "+
				"					"+
			    	"	 IF     V_DEPTNO=10   THEN      "+					     // PL/SQL 로직으로 보너스 계산 
				"			V_BONUS := V_SAL*0.3;   "+
				"	 ELSIF V_DEPTNO=20  THEN      	"+
				"			V_BONUS := V_SAL*0.1; 	"+
				"	 ELSIF V_DEPTNO=30  THEN      	"+
				"			V_BONUS := V_SAL*0.05; 	"+
				"	 ELSIF V_DEPTNO=40  THEN 		"+
				"			V_BONUS := V_SAL*0.2;  	"+
				"	 ELSE							"+
				"				V_BONUS := 0; 			"+
				"	 END IF; 						" +
				"								"+
				"        INSERT INTO BONUS_LARGE(YYYYMM,EMPNO,JOB,DEPTNO,SAL,BONUS) "+ // 1건씩 INSERT 
				"	 VALUES(?,V_EMPNO,V_JOB,V_DEPTNO,V_SAL,ROUND(V_BONUS)); 	"+
				"	 END LOOP; 		" +
				"				"+
				"	 CLOSE  BONUS_CUR; " +
				"	 COMMIT;			" +		// 100만건 INSERT후 COMMIT;
				"END; ";

			    			    
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
