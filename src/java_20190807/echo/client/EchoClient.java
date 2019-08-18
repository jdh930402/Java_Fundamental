package java_20190807.echo.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {
	private String ip;
	private int port;

	public EchoClient(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}

	public void run() {
		Socket socket = null;
		OutputStream out = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		InputStream in = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			// ip와 port로 서버와 접속을 시도한다.
			// 3. 소켓을 생성한다.
			// 4. TCP서버와 연결한다.
			socket = new Socket(ip, port);

			// 6. 소켓 출력스트림을 생성한다.
			out = socket.getOutputStream();
			osw = new OutputStreamWriter(out);
			bw = new BufferedWriter(osw);

			bw.write("안녕하세요. 저는 성영한입니다.");
			bw.newLine();
			bw.flush();

			// 9. 서버에서 보낸 메세지를 입력스트림으로 받는다.
			in = socket.getInputStream();
			isr = new InputStreamReader(in);
			br = new BufferedReader(isr);
			String readLine = br.readLine();
			System.out.println(readLine);

			if (out != null)
				out.close();
			if (osw != null)
				osw.close();
			if (bw != null)
				bw.close();
			if (in != null)
				in.close();
			if (isr != null)
				isr.close();
			if (br != null)
				br.close();
			if (socket != null)
				socket.close();
		} catch (UnknownHostException e) {
			System.out.println("서버 주소가 잘못되었습니다.");
		} catch (IOException e) {
			System.out.println("서버가 열려있지 않습니다.");
		}
	}

	public static void main(String[] args) {
			new EchoClient("192.168.0.52", 3000).run();
	}
}
