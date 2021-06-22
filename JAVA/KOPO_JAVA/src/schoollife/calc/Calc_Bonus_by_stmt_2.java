package schoollife.calc;

import java.sql.*;
public class Calc_Bonus_by_stmt_2 {
	  public static void main(String[] args) {
		    Connection 	conn      = null;
		    Statement 	stmt      = null;
		    Statement 	stmt_ins  = null;
		    ResultSet 	rs        = null;
		    		    
	    	    String	Url    = "jdbc:oracle:thin:@192.168.119.119:1521/dink";
	            String	Id     = "SCOTT";
	            String	Pwd    = "TIGER";
	            String	yyyymm = "201807";	


		    String 	sqlstr    = null;
		    
		    int		Bonus = 0;
		    
		    try{
		    	
		    	long startTime = System.currentTimeMillis();				// 시작 시간 측정
		    	
		    	// [1단계] JDBC Driver 로딩 
		    	Class.forName("oracle.jdbc.driver.OracleDriver");
		    	
		    	// [2단계] DBMS 접속 
		    	conn = DriverManager.getConnection(Url, Id,Pwd);
		      	conn.setAutoCommit(false);						// 자동 commit을  off 한다.   
		      	
		    	// [3단계] SQL 생성 
		      	sqlstr ="SELECT EMPNO,JOB,DEPTNO,SAL FROM EMP_LARGE " ;

		       	stmt = conn.createStatement();

		       	// [4단계] SQL 실행(전송)
		       	stmt.executeQuery(sqlstr);
		       
		       	// [5단계] 데이타    패치(Fetch)
		       	rs = stmt.getResultSet();

		       	while(rs.next()){
		       	 	// [6단계]  부서별 보너스 계산
		       	        if(rs.getString(2).equals("PRESIDENT"))			// 경영자(PRESIDENT)에게는 보너스를 지급하지 않는다.
		       			continue;
		       		
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
		      			
		      	   // [7단계] 계산된 보너스 INSERT
		       	    sqlstr ="INSERT INTO BONUS_LARGE(YYYYMM,EMPNO,JOB,DEPTNO,SAL,BONUS) " +
		       	    		 "VALUES('" + yyyymm + "'," + rs.getInt(1) + ",'" + rs.getString(2) + "'," +  
		       	    		 			rs.getInt(3) + "," + rs.getInt(4) +"," + Bonus + ")" ;  
		     		
		       	   // System.out.println(sqlstr); 
		       	    
		       	    stmt_ins = conn.createStatement();
		       	    stmt_ins.executeUpdate(sqlstr);
		       	    stmt_ins.close( );		       	 // 리소스 반납
		       	    //int count = stmt_ins.executeUpdate(sqlstr);
		       	    //stmt_ins.close( );  		       	 
		       	    conn.commit( );		       
		       	}
		      
		       	// [8단계] 경과 시간 측정
		       	long endTime = System.currentTimeMillis();	  // 종료 시간 측정
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

