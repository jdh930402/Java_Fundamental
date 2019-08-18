package java_20190802;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamReaderDemo {

	public static void main(String[] args) {
		FileOutputStream fos = null;
		InputStream in = null;
		byte[] b = new byte[1024];
		int readByteCount = 0;
		try {
			while (true) {
				System.out.println("입력하세요>");
				in = System.in; // System.in은 키보드 값을 입력 받을수 있는데 반환값을 InputStream 반환한다.
				readByteCount = in.read(b);

				String str = new String(b,0,readByteCount).trim();
				fos = new FileOutputStream("C:\\dev\\test\\123.txt", true);
				fos.write(b, 0, readByteCount);
				if(str.equals("exit")) {
					break;
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (in != null)
					in.close();
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
