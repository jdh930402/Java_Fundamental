package java_20190802;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class PrintWriterDemo {
	public static void main(String[] args) {
		// readLine() 메서드 : 한줄을 읽는 메서드 =>매우 유용하다.
		System.out.print("입력하세요>");
		InputStream in = System.in;

		InputStreamReader isr = null;
		BufferedReader br = null;

		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;

		try {
			isr = new InputStreamReader(in);
			br = new BufferedReader(isr);
			fw = new FileWriter("C:\\dev\\test\\keyboard.txt", true); // true = 이어쓰기
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw, true); // true = autoFlush

			String readLine = null;
			while ((readLine = br.readLine()) != null) {
				pw.println(readLine);
				if(readLine.equals("exit")) {
					break;
				}
				System.out.print("입력하세요>");
			}

			/*
			 * br = new BufferedReader(new FileReader("C:\\dev\\test\\KIC.txt")); bw = new
			 * BufferedWriter(new FileWriter("C:\\dev\\test\\KIC_copy.txt")); pw = new
			 * PrintWriter(bw, true);
			 * 
			 * String readLine = null; while ((readLine = br.readLine()) != null) {
			 * pw.println(readLine); } bw.flush();
			 */

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (br != null)
					br.close();
				if (pw != null)
					pw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
