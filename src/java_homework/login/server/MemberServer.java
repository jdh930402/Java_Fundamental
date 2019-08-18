package java_homework.login.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MemberServer {
	private ServerSocket serverSocket;
	private ArrayList<MemberServerThread> list = new ArrayList<MemberServerThread>();

	public MemberServer(int port) {
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {
		System.out.println("클라이언트를 대기중입니다.");
		while (true) {
			try {
				Socket socket = serverSocket.accept();
				String ip = socket.getInetAddress().getHostAddress();
				System.out.println("클라이언트가 접속하였습니다 ip : [ " + ip + " ]");
				MemberServerThread mst = new MemberServerThread(socket, list);
				list.add(mst);
				Thread thread = new Thread(mst);
				thread.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new MemberServer(3000).run();
	}

}
