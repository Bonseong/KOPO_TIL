package kr.ac.kopo.week4.day18;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;



public class URLMain {
	public static void main(String[] args) {
		try {
			URL urlObj = new URL("https://www.naver.com");
			System.out.println("프로토콜 : " + urlObj.getProtocol());
			System.out.println("호스트명 : " + urlObj.getHost());
			System.out.println("포트 : " + urlObj.getPort()); // 명시하지 않으면 -1
			System.out.println("경로 : " + urlObj.getPath());
			System.out.println("쿼리 : " + urlObj.getQuery());
			
			System.out.println("=============================================================================");

			URLConnection uc = urlObj.openConnection();
			InputStream is = uc.getInputStream();
			
//			InputStream is = urlObj.openStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			
			while(true) {
				int c = isr.read();
				if(c == -1) break;
				System.out.print((char)c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
