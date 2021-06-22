import java.sql.*;
public class Calc_Bonus_by_stmt_6 {
	  public static void main(String[] args) {
		    Connection 	conn      = null;
		    Statement 	stmt      = null;
		    Statement 	stmt_ins  = null;
		    ResultSet 	rs        = null;
		    		    
		    String 	sqlstr    = null;
	    	    String	Url       = "jdbc:oracle:thin:@192.168.119.119:1521/dink";
	            String	Id        = "scott";
	            String	Pwd       = "tiger";
	            String	yyyymm    = "201807";	
		    
		    int		Bonus = 0;
		    
		    try{
		    	
		    	long startTime = System.currentTimeMillis();	// 시작 시간 측정
		    	
		    	// [1단계] JDBC Driver 로딩 
		    	Class.forName("oracle.jdbc.driver.OracleDriver");
		    	
		    	// [2단계] DBMS 접속 
		    	conn = DriverManager.getConnection(Url, Id,Pwd);
		      	conn.setAutoCommit(false);						// 자동 commit을  off 한다.   
		      	
		    	// [3단계] SQL 생성, 부서별 보너스 계산을 집합적으로 DBMS에서 처리 
		      	 
		      	sqlstr = "	SELECT  EMPNO,JOB,DEPTNO,SAL, 			                        " +
		      			 "		             ROUND(DECODE(DEPTNO,10,0.3,	     	" +
		      			 "                                               20,0.1,	     	" +
		      			 "                                               30,0.05,	 	" +
		      			 "                                               40,0.2,	       	" +
		      			 "                                               0) * SAL ) AS BONUS	" + 
		      			 "	FROM   EMP_LARGE			                        " +
		      			 "	WHERE  JOB <> 'PRESIDENT'                                       " ;
		      	 

		       	stmt = conn.createStatement();
		        stmt_ins = conn.createStatement();			    // INSERT를 위한 Statement 객체 1번 생성
		       	// [4단계] SQL 실행(전송)
		       	stmt.executeQuery(sqlstr);
		       
		       	// [5단계] 데이타    패치(Fetch)
		       	rs = stmt.getResultSet();

		       	while(rs.next()){
		       	 	// [6단계]  
		       	    /*
		      		if (rs.getInt(3) == 10 )
		       			Bonus = (int)(rs.getInt(4) * 0.3);
		       		else if(rs.getInt(3) == 20)
		       			Bonus = (int)(rs.getInt(4) * 0.1);		       			
		       		else if(rs.getInt(3) == 30)
		       			Bonus = (int)(rs.getInt(4) * 0.05);		       			
		       		else if(rs.getInt(3) == 40)
		       			Bonus = (int)(rs.getInt(4) * 0.2);
		       		else
		       			Bonus = 0;
		      		*/	
		      	   // [7단계] 계산된 보너스 INSERT
		       	    sqlstr ="INSERT INTO BONUS_LARGE(YYYYMM,EMPNO,JOB,DEPTNO,SAL,BONUS) " +
		       	            "VALUES('" + yyyymm + "'," + rs.getInt(1) + ",'" + rs.getString(2) + "'," +  
		       	    		 			rs.getInt(3) + "," + rs.getInt(4) +"," + rs.getInt(5) + ")" ;  
		     		
		       	   // System.out.println(sqlstr); 
		       	    
		       	   
		       	    stmt_ins.executeUpdate(sqlstr);
		            //int count = stmt_ins.executeUpdate(sqlstr);
		       	    
		       	    //stmt_ins.close( );  		       	 
		       	   	       
		       	}
		        stmt_ins.close( );		  	      // 100만번  실행후 반납
		        conn.commit( );	
		        
		       	// [8단계] 경과 시간 측정
		       	long endTime = System.currentTimeMillis();    // 종료 시간 측정
		        System.out.println("경과시간 : " + (endTime - startTime)/1000 +"초"); 
		       	
			 }catch(Exception e){
						System.out.println("Oracle JDBC Connection Exception");
						e.printStackTrace();
			 }finally{
			        		try{
			        		 	// [9단계] 리소스 반납
				   					rs.close();
				   					stmt.close();
				   					conn.close();
			        		}catch(Exception fEx){
					            		fEx.printStackTrace();
			        		}
		      } // End try 
		   } //End Main
} // End Class

