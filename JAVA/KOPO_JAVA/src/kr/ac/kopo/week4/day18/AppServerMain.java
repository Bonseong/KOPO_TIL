package kr.ac.kopo.week4.day18;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class AppServerMain {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(10000);
			System.out.println("어플리케이션 서버 실행...");

			Socket client = server.accept();
			System.out.println("연결된 클라이언트 정보 : " + client);

			String msg = "접속을 환영합니다";

			OutputStream os = client.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);

			dos.writeUTF(msg); // UTF-8 방식으로 데이터 전송
			dos.flush(); // 버퍼를 비움
			
			// OutputStreamWriter를 사용할면 Client 측에서도 InputStreamWrite가 필요함

			client.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
