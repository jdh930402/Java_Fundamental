package java_20190808.file.server;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class FileServerThread implements Runnable {
	private Socket socket = null;

	public FileServerThread(Socket socket) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
	}

	@Override
	public void run() {
		BufferedReader br = null;
		FileInputStream fis = null;
		OutputStream out = null;
		try {
			br = new BufferedReader(new InputStreamReader((socket.getInputStream())));
			String fileName = br.readLine();
			System.out.println("클라이언트가 요청한 파일 이름 : " + fileName);

			fis = new FileInputStream("C:\\dev\\test\\" + fileName);
			out = socket.getOutputStream();
			byte[] readBytes = new byte[1024 * 8];
			int readByteCount = 0;
			while ((readByteCount = fis.read(readBytes)) != -1) {
				out.write(readBytes, 0, readByteCount);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (fis != null)
					fis.close();
				if (out != null)
					out.close();
				if (socket != null)
					socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
