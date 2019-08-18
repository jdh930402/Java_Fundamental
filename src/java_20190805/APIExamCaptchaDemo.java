package java_20190805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

import util.Utility;

public class APIExamCaptchaDemo {
	public static String console(String str) throws IOException {
		System.out.print(str);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		return br.readLine();
	}

	public static void main(String[] args) {
		
		String id = "lXzey2jtwrfEAAWo9Lxn";
		String secret = "UH4P_T111V";
		String key = Utility.getCaptchaKey(id, secret);
		boolean isSuccess = Utility.isCaptchaImage(id, secret, key);
		if (isSuccess) {
			try {
				String readLine = console("이미지를 입력하세요>");
				boolean result = Utility.isCaptchaResult(id, secret, key, readLine);
				if(result) {
					System.out.println("로그인 성공");
				}else {
					System.out.println("로그인 실패");
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("다시 확인하세요");
		}
		
	}
}
