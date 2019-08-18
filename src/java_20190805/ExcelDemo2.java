package java_20190805;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelDemo2 {
	// 1. c:\dev\test\test1.txt 파일을 읽어온다. BufferedReader
	// 2. BufferedReader의 readLine()메서드를 이용해서 한줄씩 읽는다.
	// 3. 한줄 읽은 문자열을 String 클래스의 split("#")을 이용해서 String[] 반환한다.
	// 4. [0] => cell에 입력한다. [1] => cell에 입력한다. 2,3,4 반복 작업으로 엑셀에 입력한다.
	// 5. 엑셀 파일명 c:\dev\test\test2.xls 파일로 저장

	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader br = null;
		FileOutputStream fos = null;

		HSSFWorkbook workbook = new HSSFWorkbook(); // 새 엑셀파일 생성
		HSSFSheet sheet = workbook.createSheet("sheet1"); // 새 시트 생성
		HSSFRow row = null;
		HSSFCell cell = null;
		int rowNum = 0;

		try {
			fr = new FileReader("C:\\dev\\test\\test1.txt");
			br = new BufferedReader(fr);
			fos = new FileOutputStream("C:\\dev\\test\\test2.xls");
			String readLine = null;
			while ((readLine = br.readLine()) != null) {
				row = sheet.createRow(rowNum++);
				String[] split = readLine.split("#");
				for (int i = 0; i < split.length; i++) {
					cell = row.createCell(i);
					cell.setCellValue(split[i]);
				}
			}
			workbook.write(fos); // 시트를 쓰는 작업. 데이터를 읽고 쓰는 작업 후에 시트를 써야하므로 마지막에 위치해야한다.
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (fr != null)
					fr.close();
				if (br != null)
					fr.close();
				if (br != null)
					br.close();
				workbook.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
