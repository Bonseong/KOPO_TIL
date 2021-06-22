package schoollife.calc;

import java.sql.*;
public class Calc_Bonus_by_Pstmt_2 {

	public static void main(String []args) {

		Connection 	conn      = null;
	    ResultSet 	rs        = null;
	    Statement 	stmt      = null;
	    PreparedStatement pstmt_ins = null; 
	    
	    String	Url    = "jdbc:oracle:thin:@192.168.119.119:1521/dink";
	    String	Id     = "SCOTT";
	    String	Pwd    = "TIGER";
	    String	yyyymm = "201807";	

	    int         ProcessedRows = 0;
	    int		Bonus = 0;
	    
	    try{
	    	
	    	long startTime = System.currentTimeMillis();	// 시작 시간 측정
	    	
	    	// [1단계] JDBC Driver 로딩 
	    	Class.forName("oracle.jdbc.driver.OracleDriver");
	    	
	    	// [2단계] DBMS 접속 
	    	conn = DriverManager.getConnection(Url, Id,Pwd);
	      	conn.setAutoCommit(false);			// 자동 commit을  off 한다.   
	      	
	    	// [3단계] SQL 생성 
	        //  String sqlstr ="SELECT EMPNO,JOB,DEPTNO,SAL FROM EMP_LARGE WHERE JOB <> 'PRESIDENT' AND ROWNUM < 100 ";
	        String sqlstr ="SELECT EMPNO,JOB,DEPTNO,SAL FROM EMP_LARGE " +
	        	  		      " WHERE JOB <> 'PRESIDENT' ";
	    	
	        stmt = conn.createStatement();
	    	
       	    String insstr= "INSERT INTO BONUS_LARGE(YYYYMM,EMPNO,JOB,DEPTNO,SAL,BONUS)"+ 
       	                   " VALUES(?,?,?,?,?,?)";
       	    pstmt_ins  = conn.prepareStatement(insstr);	// INSERT를 위한 PreparedStatement

       	    // [4단계] SQL 실행(전송)
	       	stmt.executeQuery(sqlstr);
	       
	       	// [5단계] 데이타    패치(Fetch)
	       	rs = stmt.getResultSet();
	       			       	
	       	while(rs.next()){						// 100 만번 WHILE LOOP 반복 
	       	 	// [6단계]  부서별 보너스 계산
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
	      			
	       	 	// [7단계]  보너스 INSERT 	      		
	      		pstmt_ins.setString(1,yyyymm);			// 보너스 지급월
	      		pstmt_ins.setInt(2,rs.getInt(1));		// empno
	      		pstmt_ins.setString(3,rs.getString(2));	        // job
	      		pstmt_ins.setInt(4,rs.getInt(3));		// deptno
	      		pstmt_ins.setInt(5,rs.getInt(4));		// sal
	      		pstmt_ins.setInt(6,Bonus);			// bonus
	      		
	      		pstmt_ins.addBatch();				// AddBatch
	       	           
	       	}
	       	pstmt_ins.executeBatch();		       		    // ExecuteBatch
	       	// ProcessedRows = pstmt_ins.executeBatch();	// ExecuteBatch
	       	
	        conn.commit( );		 // 100만건 데이타 입력후 1번 commit		
	       	
	       		       	
	       	long endTime = System.currentTimeMillis();	  // 종료 시간 측정
	        System.out.println("경과시간 : " + (endTime - startTime)/1000 +"초"); 
	       	
		 }catch(Exception e){
					System.out.println("Oracle JDBC  Exception");
					e.printStackTrace();
		 }finally{
			  // [8단계] Resource 반납
			   if(rs   != null)      try{ rs.close();        } catch(SQLException sqle){}	
			   if(stmt != null)      try{ stmt.close();      } catch(SQLException sqle){}
			   if(pstmt_ins != null) try{ pstmt_ins.close(); } catch(SQLException sqle){}
			   if(conn != null)      try{ conn.close();      } catch(SQLException sqle){}			        		
	     } // End try 
	   } //End Main
	
} // End Class
