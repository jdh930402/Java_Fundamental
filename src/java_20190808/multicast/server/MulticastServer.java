package java_20190808.multicast.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MulticastServer {
	private ServerSocket serverSocket = null;
	private ArrayList<MulticastServerThread> list;
	

	public MulticastServer(int port) {
		try {
			list = new ArrayList<MulticastServerThread>();
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {
		MulticastServerThread mst = null;
		System.out.println("접속대기중입니다.");
		while (true) {
			try {
				Socket socket = serverSocket.accept();
				String ip = socket.getInetAddress().getHostAddress();
				System.out.println("클라이언트 [ip : " + ip +"]");
				mst = new MulticastServerThread(socket, list);
				
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
		new MulticastServer(6000).run();
	}
}
