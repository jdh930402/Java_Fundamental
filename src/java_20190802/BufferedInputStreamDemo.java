package java_20190802;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedInputStreamDemo {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;

		try {
			// 1. FileInputStream과 FileOutputStream을 이용하여 1바이트 읽어서 1바이트 출력한 예제
			// 경과시간은 15초
			
			/*
			fis = new FileInputStream("C:\\dev\\test\\java_pdf.zip");
			fos = new FileOutputStream("C:\\dev\\test\\java-pdf-copy.zip");

			int readByte = 0;
			long start = System.currentTimeMillis();

			while ((readByte = fis.read()) != -1) {
				fos.write(readByte);
			}

			long end = System.currentTimeMillis();
			System.out.printf("경과시간 : %d\n", end - start);	
			*/
	
			//------------------------------------------------------------------------------------------------
			
			// 2. BufferedInputStream과 BufferedOutputStream을 이용하여
			// 1바이트 읽어서 1바이트 출력한 예제이고 경과시간은 0.018초
			// BufferedInputStream의 read() 메서드는 1바이트 읽어서 BufferedInputStream의 버퍼(byte[])에
			// 저장한다.
			// BufferedInputStream의 write()메서드는 1바이트 출력하는 것이 아니라 버퍼(byte[]) 공간의 크기만큼 가득 채우고
			// 출력한다.
			// 만약 버퍼 공간의 크기가 다 채워지지 않으면 출력하지 않고 flush() 메서드를 통하여 출력해야함.
			/*
			fis = new FileInputStream("C:\\dev\\test\\java_pdf.zip");
			fos = new FileOutputStream("C:\\dev\\test\\java-pdf-copy.zip");

			bis = new BufferedInputStream(fis); // stream chaining
			bos = new BufferedOutputStream(fos); // stream chaining
			int readByte = 0;
			long start = System.currentTimeMillis();

			while ((readByte = bis.read()) != -1) {
				bos.write(readByte);
			}
			// BufferedOutputStream의 버퍼 (byte[])는 다 채워지면 자동으로 전송하지만
			// 다 채워지지 않으면 전송하지 않는다.따라서 다 채워지지 않더라도 비우기 위해서 flush() 메서드를 이용한다.
			bos.flush();
			// 반드시 해야한다.
			long end = System.currentTimeMillis();
			System.out.printf("경과시간 : %d\n", end - start);
			*/

			// ------------------------------------------------------------------------------------------------
			
			// 3.FileInputStream과 FileOutputStream을 이용하여 8192바이트 읽어서 8192바이트 출력한 예제
			// 경과시간은 0.002초 => 가장 성능이 우수하다.
			fis = new FileInputStream("C:\\dev\\test\\java_pdf.zip");
			fos = new FileOutputStream("C:\\dev\\test\\java-pdf-copy.zip");
			int readByteCount = 0;
			byte[] readByte = new byte[1024 * 8];
			long start = System.currentTimeMillis();
			while ((readByteCount = fis.read(readByte)) != -1) {
				fos.write(readByte, 0, readByteCount);
			}
			long end = System.currentTimeMillis();
			System.out.printf("경과시간 : %d\n", end - start);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			try {
				if (fis != null)
					fis.close();
				if (fos != null)
					fos.close();
				if (bis != null)
					bis.close();
				if (bos != null)
					bos.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}