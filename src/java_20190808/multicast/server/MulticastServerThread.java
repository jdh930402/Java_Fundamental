package java_20190808.multicast.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;

public class MulticastServerThread implements Runnable {
	private Socket socket;
	private ArrayList<MulticastServerThread> list;
	private BufferedReader br;
	private BufferedWriter bw;

	public MulticastServerThread(Socket socket, ArrayList<MulticastServerThread> list) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
		this.list = list;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			boolean isStop = false;
			while (!isStop) {
				String readLine = br.readLine();
				System.out.println(readLine);
				if (readLine.equals("shutdown")) {
					bw.write("shutdown\n");
					bw.flush();
					isStop = true;
				} else {
					broadCast(readLine + "\n");
				}
			}
			list.remove(this); 
		} catch (IOException e) {
			System.out.println("비정상적으로 종료되었습니다.");
			list.remove(this);
		}finally {
			try {
				if (br != null)
					br.close();
				if (bw != null)
					bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void broadCast(String msg) throws IOException {
		for (MulticastServerThread mst : list) {
			mst.sendMessage(msg);
		}
	}

	private void sendMessage(String msg) throws IOException {
		bw.write(msg);
		bw.flush();

	}
}
