package java_20190801;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import util.Utility;

public class FileInputOutStreamDemo {
	// read(), write() 한바이트씩 읽는 방식은 매우 느리다
	public static void main(String[] args) {
		// 입출력을 생성하면 종료시에 반드시 close();해주어야한다.
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			// son.jpg를 eclipse로 읽어오는 메소드
			fis = new FileInputStream("C:\\dev\\test\\jdk.exe"); // 파일이 없는 경우 err, FileNotFoundException발생

			Utility.mkdirs("C:\\dev\\test\\2019\\08\\01");
			fos = new FileOutputStream("C:\\dev\\test\\2019\\08\\01\\jdk.exe"); // 파일이 없는 경우 err가 나지 않고 파일을 생성하는데 해당 //
																					// 경로가 없을 경우 FileNotFoundException발생
			int readByte = 0;
			// fis.read() 메서드는 한 바이트를 읽어 반환한다.
			// 더 이상 읽을 값이 없을 경우 -1을 반환한다.
			while ((readByte = fis.read()) != -1) {
				fos.write(readByte);
			}
			System.out.println("성공");
		} catch (FileNotFoundException e) {
			// catch에서 상위클래스가 위에 올수 없고 아래에 와야한다.
			// 만약 상위 클래스인 IOException이 위로 오면 에러가 뜬다.
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (fis != null)
					fis.close();
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
