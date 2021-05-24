package kr.ac.kopo.week3.day14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
 	List : 순서 (O), 중복 (O)
 	구현클래스 : ArrayList, LinkedList
 	
 	주요메소드
 	- add() : 데이터 입력
 	- get() : 해당 인덱스의 데이터 추출
 	- remove() : 해당 인덱스 위치의 데이터 제거
 	- size() : 리스트의 전체 데이터 갯수
 	- clear() : 리스트의 모든 요소 제거
 	- isEmpty : 리스트가 비어있는지 체크 (true/false)
 	- contains() : 특정데이터의 존재여부 판단 (true/false)
 	- iterator() : Iterator 객체를 반환
 		
 */

public class ListMain {
	public static void main(String[] args) {
		// List list = new ArrayList(); // 1.5미만의 방식

		// List<String> list = new ArrayList<String>(); // 1.5버전의 Generic을 사용
		List<String> list = new ArrayList<>(); // 1.7버전 이후의 Generic 방식

		System.out.println("원소의 총갯수 : " + list.size());
		list.add("one");
		// list.add(10); -> 에러
		list.add("two");
		list.add("three");
		list.add("four");
		list.add("five");

		System.out.println("원소의 총갯수 : " + list.size());

		list.add("one");
		System.out.println("원소의 총갯수 : " + list.size());

		/*
		 * list의 전체 데이터 출력 1. index를 이용한 get() 메소드 이용 2. 1.5버전의 for문 3. toArray() 메소드 이용
		 * 4. Iterator 이용
		 */
		System.out.println("get() 메소드를 이용한 출력");

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		System.out.println("1.5버전의 for문 이용한 출력");
		for (String str : list) {
			System.out.println(str);
		}

		System.out.println("toArray() 메소드 이용");
		Object[] arr = list.toArray(); // 리스트를 배열 형태로 리턴, 단 Object형임
		System.out.println(Arrays.toString(arr));

		/*
		 * Iterator (순환자) 주요 메소드 - hasNext() : 추출할 다음 데이터가 존재하는지 - next() : 데이터 추출
		 */

		System.out.println("iterator() 메소드 이용 출력");

		Iterator<String> ite = list.iterator();
		while (ite.hasNext()) {
			System.out.println(ite.next());
		}

		String searchStr = "two";
		if (list.contains(searchStr)) {
			System.out.println(searchStr + "은 존재합니다.");
		} else {
			System.out.println(searchStr + "은 존재하지 않습니다.");
		}

		boolean bool = list.remove("two");
		System.out.println("remove : " + bool); // bool값을 리턴하면서 값을 삭제해줌

		for (String str : list) {
			System.out.println(str);
		}

		if (list.contains(searchStr)) {
			System.out.println(searchStr + "은 존재합니다.");
		} else {
			System.out.println(searchStr + "은 존재하지 않습니다.");
		}

		System.out.println("원소 총 갯수 : " + list.size());
		//list.clear();
		
		List<String> sub = new LinkedList<>();
		sub.add("봄");
		sub.add("여름");
		
		list.addAll(sub);
		
		System.out.println(list.size()); // LinkedList와 ArrayList는 서로 호환이 됨 (다형성)
		
		

	}
}
