package kr.ac.kopo.board.framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.METHOD) // 어디에 붙일 것인지 (METHOD : 메소드에 붙임 / FIELD : 멤버변수에 붙임 / TYPE : 클래스위)
@Retention(RetentionPolicy.RUNTIME) // 아래 정보를 언제까지 유지되는 것인지? -> 동적인 사용을 위해 (RUNTIME : 런타임 시점까지)
public @interface RequestMapping {
	String value();
}
