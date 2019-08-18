package java_20190807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class UrlConnectionDemo {
	public static void main(String[] args) throws IOException {
		URL url = new URL("https://sports.news.naver.com/wbaseball/index.nhn");
		URLConnection urlCon = url.openConnection();

		String cacheControl = urlCon.getHeaderField("cache-control"); // inndex.nhn에 있는 key값을 넣어주면 value값을 가져온다.
		System.out.println("cacheControl : " + cacheControl);

		String contentType = urlCon.getHeaderField("content-type");
		System.out.println("content-type : " + contentType);

		String date = urlCon.getHeaderField("date");
		System.out.println("date : " + date);

		InputStream is = urlCon.getInputStream(); // HTML 정보를 가지고 온다. URL클래스의 openStream()메서드와 동일한 기능을 한다.
		// URL클래스와 URLConnection클래스의 차이점은 헤더정보를 가져올수 있느냐 없느냐의 차이이다.
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr); 
		String readLine = null;
		while ((readLine = br.readLine()) != null) {
			System.out.println(readLine);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
