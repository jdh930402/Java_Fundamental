package java_20190807;

import java.io.IOException;
import java.net.ServerSocket;

public class SocketServerScanDemo {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;

		for (int i = 0; i < 65356; i++) {
			try {
				// ServerSocket클래스는 해당 서버의 port번호를 사용할 수 있으면 객체를 생성하고
				// 그렇지 않으면 예외를 발생한다. 즉, 예외가 발생된다는 얘기는 해당 port를 사용중인 경우이다.
				serverSocket = new ServerSocket(i); // 해당 컴퓨터의 아이피가 서버가 됨.
				//System.out.println(i + "번호를 사용할 수 있습니다.");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(i + "번호를 사용할 수 없습니다.");
			}
		}
	}
}
