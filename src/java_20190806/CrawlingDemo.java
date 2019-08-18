package java_20190806;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlingDemo {
	public static void main(String[] args) {
		/*String url = "http://www.imbc.com";
		
		// HTML 문서 전체를 관리하기 위한 객체
		Document doc = null;
		
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("성공...");		
		
		// 개체가 여러개일 경우 Elements로 접근하고 개체가 단일개체일 경우 Element로 접근한다.
		Elements elements = doc.select(".con-wrap.notice-wrap"); // 주의할점 : .클래스명, #id명으로 접근하고 여러개를 입력시 공백이 있으면 안된다.
		
		Elements noticeElements = elements.select("h3"); // h3를 가져온다.
		String noticeTitle = noticeElements.text();
		System.out.println(noticeTitle);
		
		Elements liElements = elements.select(".notice-list li");
		for(int i=0 ; i<liElements.size(); i++) {
			Element liEliment = liElements.get(i);
			System.out.println(liEliment.text());
		}
		*/
		
		String url = "https://sports.news.naver.com/kfootball/index.nhn?rc=N";		
		Document doc = null;
		
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("성공...");
		
		Elements news = doc.select(".home_news li");
		
		for(int i=0 ; i<news.size() ; i++) {
		Element newslist = news.get(i);
		System.out.println(newslist.text());
		}
	}
}
