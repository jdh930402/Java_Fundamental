package java_20190806;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import util.Utility;

public class CoinMarketCapDemo {
	public static void main(String[] args) {
		String url = "https://coinmarketcap.com/currencies/bitcoin/historical-data/?start=20190101&end=20190806";
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println("Date\t Open\t High\t Low\t Close\t Volume\t Market Cap");
		// 같은 class일 경우 붙여서 .클래스명.클래스명과 같은 방식으로 사용하고,
		// 하위 class일 경우 띄어서 .클래스명 .클래스명과 같은 방식으로 사용해야한다.
		// 기본 태그들은 띄어쓰기를 하여 사용한다.
		Elements bodyElements = doc.select(".table-responsive .table tbody tr");

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Sheet");
		HSSFRow row = null;
		HSSFCell cell = null;

		row = sheet.createRow(0);

		cell = row.createCell(0);
		cell.setCellValue("Date");
		
		cell = row.createCell(1);
		cell.setCellValue("Open");
		
		cell = row.createCell(2);
		cell.setCellValue("High");
		
		cell = row.createCell(3);
		cell.setCellValue("Low");
		
		cell = row.createCell(4);
		cell.setCellValue("Close");
		
		cell = row.createCell(5);
		cell.setCellValue("Volume");
		
		cell = row.createCell(6);
		cell.setCellValue("Market Cap");

		for (int i = 0; i < bodyElements.size(); i++) {
			int index = 0;
			row = sheet.createRow(i + 1);

			Element trElement = bodyElements.get(i);
			cell = row.createCell(index);
			String date = trElement.child(index++).text(); // child():bodyElement에서 index의 값들만을 가져온다.
			date = Utility.getKoreanDate(date);
			cell.setCellValue(date);

			cell = row.createCell(index);
			String open = trElement.child(index++).text(); // child():bodyElement에서 index의 값들만을 가져온다.
			cell.setCellValue(open);

			cell = row.createCell(index);
			String high = trElement.child(index++).text();
			cell.setCellValue(high);

			cell = row.createCell(index);
			String low = trElement.child(index++).text();
			cell.setCellValue(low);

			cell = row.createCell(index);
			String close = trElement.child(index++).text();
			cell.setCellValue(close);

			cell = row.createCell(index);
			String volume = trElement.child(index++).text();
			cell.setCellValue(volume);

			cell = row.createCell(index);
			String marketCap = trElement.child(index++).text();
			cell.setCellValue(marketCap);

			// System.out.printf("%s\t %s\t %s\t %s\t %s\t %s\t %s\t \n", date, open, high,
			// low, close, volume, marketCap);
		}
		try {
			FileOutputStream fos = new FileOutputStream("C:\\dev\\test\\coin.xls");
			workbook.write(fos);

			fos.close();
			workbook.close();
			System.out.println("성공...");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
