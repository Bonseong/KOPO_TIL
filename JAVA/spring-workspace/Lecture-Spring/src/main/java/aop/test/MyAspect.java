package aop.test;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class MyAspect {
	
	//@After("execution(* aop.test.*.setAge(..))")
	public void checkAdult(JoinPoint joinPoint) {
		System.out.println(Arrays.toString(joinPoint.getArgs()));
		
		Object[] args = joinPoint.getArgs();
		if((int)args[0] < 20 ) {
			System.out.println("미성년자입니다");
		}else {
			System.out.println("성년입니다.");
		}
	}
	
	// joinpoint : 적용 가능한 모든 지점
	@Around("execution(* aop.test.*.setAge(..))") // 호출을 가로채감 -> setAge호출을 막고 아래 메소드를 실행함
	public void checkAdult2(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("1번");
		System.out.println("joinPoint : " + joinPoint);
		
		joinPoint.proceed(); // 그다음 setAge 메소드 실행 (after와 같음), proceed : 원래 하려고 했던 메소드를 실행해라 -> 시점을 내가 설정하는 개념..?
		System.out.println("2번");
		Object[] args = joinPoint.getArgs();
		if((int)args[0] < 20 ) {
			System.out.println("미성년자입니다");
		}else {
			System.out.println("3번");
			System.out.println("성년입니다.");
		}
		
	}
	
	
	@AfterThrowing(pointcut="execution(* aop.test.*.setAge(..))", throwing="ex")
	public void error(JoinPoint joinPoint, Throwable ex) {
		System.out.println("예외처리 : " + ex.toString());
	}
}
