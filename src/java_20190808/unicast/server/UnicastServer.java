package java_20190808.unicast.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class UnicastServer {
	private ServerSocket serverSocket = null;

	public UnicastServer(int port) {
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {
		UnicastServerThread ust = null;
		System.out.println("접속대기중입니다.");
		while (true) {
			try {
				Socket socket = serverSocket.accept();
				String ip = socket.getInetAddress().getHostAddress();
				System.out.println("클라이언트 [ip : " + ip +"]");
				ust = new UnicastServerThread(socket);
				Thread thread = new Thread(ust);
				thread.start();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		new UnicastServer(5000).run();
	}
}
