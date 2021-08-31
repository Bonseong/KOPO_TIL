package kr.ac.kopo;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ac.kopo.member.dao.MemberDAO;
import kr.ac.kopo.member.service.MemberService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/spring/spring-mvc.xml" })

public class MemberTest {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Autowired
	private MemberService memberService;	
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Ignore
	@Test
	public void 중복확인Test() throws Exception{
		Boolean result = memberService.checkId("test31");
		
		System.out.println("test result : "+ result);
			
		


	}
	

	
	
}
