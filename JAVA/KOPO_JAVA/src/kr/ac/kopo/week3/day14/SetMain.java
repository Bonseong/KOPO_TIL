package kr.ac.kopo.week3.day14;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/* 
 * Set : 순서(X), 중복(X)
 * 검색속도 빠름
 * 구현클래스 : HashSet, TreeSet
 */

public class SetMain {
	public static void main(String[] args) {
		Set<String> set = new TreeSet<>(); 
		
		
		boolean bool = set.add("one");
		System.out.println("\"One\" + 데이터 삽입여부 : " + (bool ? "성공":"실패"));
		set.add("two");
		set.add("three");
		set.add("four");
		set.add("five");
		
		bool = set.add("one"); // 중복을 확인하기 위해
		System.out.println("\"One\" + 데이터 삽입여부 : " + (bool ? "성공":"실패"));
		
		/*
		 * set의 전체테이버 출력방식
		 * 1. 1.5버전의 for문
		 * 2. iterator() 메소드 이용
		 * 3. toArray()
		 */
		System.out.println("----------------------");

		System.out.println("<1.5 버전의 for문 이용 출력>");
		for (String str : set) {
			System.out.println(str); // 나름의 검색을 효과적으로 하기위한 정렬
		}
		System.out.println("----------------------");
		System.out.println("<iterator() 이용 출력>");
		Iterator<String> ite = set.iterator();
		while(ite.hasNext()) {
			System.out.println(ite.next());
		}
		
		System.out.println("<toArray() 이용 출력>");
		Object[] arr = set.toArray();
		System.out.println(Arrays.toString(arr));
		
		/*
		 * TreeSet : 문자열은 사전순
		 */
	}
}
