package kr.ac.kopo.week4.day18;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClientMain {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 10001);

			// 키보드로 입력받을 객체
			BufferedReader Keyboard = new BufferedReader(new InputStreamReader(System.in));

			// 클라이언트가 키보드로 입력받은 데이터를 서버로 전달
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			PrintWriter pw = new PrintWriter(osw);

			// 서버에서 재전송한 데이터 수신
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			while (true) {
				System.out.print("메시지 입력 (quit입력 시 종료) : ");
				String msg = Keyboard.readLine();

				if(msg.equalsIgnoreCase("quit")) {
					System.out.println("서버연결을 종료합니다.");
					socket.close();
				}
				pw.write(msg); // pw를 통해 메시지 전달
				pw.flush();

				String echoMsg = br.readLine();
				System.out.println("서버에서 전송한 메시지 : " + echoMsg);
			}

		} catch (Exception e) {

		}
	}
}
