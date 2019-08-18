package java_20190808.file.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {
	private ServerSocket serverSocket = null;
	
	public FileServer(int port) {
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run() {
		FileServerThread fst = null;
		while(true) {
			System.out.println("클라이언트 접속을 대기하고 있습니다.");
			try {
				Socket socket = serverSocket.accept();
			    String ip = socket.getInetAddress().getHostAddress();
			    System.out.println("클라이언트 접속 [ip : " + ip + "]");
			    
			    fst = new FileServerThread(socket);
			    Thread thread = new Thread(fst); // thread를 생성할때는 반드시 runnable객체가 매개변수 값으로 와야한다.
			    thread.start();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new FileServer(3000).run();
	}

}
