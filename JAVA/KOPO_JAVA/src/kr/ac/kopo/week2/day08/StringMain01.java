package kr.ac.kopo.week2.day08;

public class StringMain01 {
	public static void main(String[] args) {
		String str = new String();
		char[] chars = {'A','B','C','D','E','F'};
		String str2 = new String(chars);
		String str3 = new String(chars,1,3);
		byte[] bytes = {97, 98, 99, 100, 101};
		String str4 = new String(bytes);
		String str5 = new String("Hello!");
		String str6 = "Hello";
		
		System.out.println("str : [" + str + "]");
		System.out.println("str : [" + str2 + "]");
		System.out.println("str : [" + str3 + "]");
		System.out.println("str : [" + str4 + "]");
		System.out.println("str : [" + str5 + "]");
		System.out.println("str : [" + str6 + "]");
	}
}
