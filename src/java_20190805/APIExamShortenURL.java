package java_20190805;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import util.Utility;

public class APIExamShortenURL {
	public static void main(String[] args) {
		String clientId = "xAtQJBgVYPgYJQS1i5UE";// 애플리케이션 클라이언트 아이디값";
		String clientSecret = "Rp1KnO3PJw";// 애플리케이션 클라이언트 시크릿값";
		String oriUrl = "https://docs.google.com/spreadsheets/d/1AEbbhYgDMouucbzE4OOxLUXoYLMr2nNyWqE4wq3rTeU/edit#gid=0";
		String url = Utility.getShortURL(clientId, clientSecret, oriUrl);
		//System.out.println(url);
		if(Utility.isQrcode(url, 300, 300)) {
			System.out.println("QR 코드 이미지 생성");
		}else {
			System.out.println("QR 코드 이미지 실패");
		}
	}
}
