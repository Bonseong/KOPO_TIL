package kr.ac.kopo.week4.day18;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class AppClientMain {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 10000);

			InputStream is = socket.getInputStream();
			DataInputStream dis = new DataInputStream(is);

			String msg = dis.readUTF();
			System.out.println("서버에서 받은 메시지 : " + msg);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
