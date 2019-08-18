package util;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.imageio.ImageIO;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class Utility {
	// calendar을 pattern에 맞게 변환
	public static String getDate(Calendar calendar, String pattern) {
		return new SimpleDateFormat(pattern).format(calendar.getTime());
	}

	// 디렉토리 생성
	public static Boolean mkdirs(String path) {
		boolean isSuccess = false;
		File f1 = new File(path);
		boolean isExisted = f1.isDirectory();
		if (!isExisted) {
			isSuccess = f1.mkdir();
		}
		return isSuccess;
	}

	// 정수형 숫자에 대해 컴마를 찍음
	public static String getComma(long name) {
		return String.format("%,d", name);
	}

	// 실수형 숫자에 대해 컴마를 찍음
	public static String getComma(double name, int precision) {
		return String.format("%,." + precision + "f", name);
	}

	// 파일 이름을 변경
	public static boolean changeFileName(String path) {
		boolean isSuccess = false;
		File oldFile = new File(path);
		String fileName = oldFile.getName();
		String name = fileName.substring(0, fileName.lastIndexOf("."));
		String extensionWithDot = fileName.substring(fileName.lastIndexOf("."));

		// 마음에 안들면 아래 부분을 수정하세요
		name = String.valueOf(System.currentTimeMillis());

		fileName = name + extensionWithDot;
		String parent = oldFile.getParent();
		File newFile = new File(parent, fileName);
		isSuccess = oldFile.renameTo(newFile);

		return isSuccess;
	}

	public static String getShortURL(String id, String secret, String oriUrl) {
		String clientId = id;// 애플리케이션 클라이언트 아이디값";
		String clientSecret = secret;// 애플리케이션 클라이언트 시크릿값";
		StringBuffer response = new StringBuffer();
		try {
			String text = oriUrl;
			String apiURL = "https://openapi.naver.com/v1/util/shorturl?url=" + text;
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();
			//System.out.println(response.toString());

			// java의 HashMap과 같다고 생각하면 된다.
			JSONParser jsonParse = new JSONParser();
			JSONObject jsonObj = (JSONObject) jsonParse.parse(response.toString()); // response를 jsonObject형식으로 변경
			JSONObject dataObj = (JSONObject) jsonObj.get("result"); // 현재 response는 key값으로 message와 result와 code로
																		// 이루져있고, result의 값을 읽어들임
			// result의 결과값 :
			// {"hash":"GKMOVTG6","url":"http://me2.do/GKMOVTG6","orgUrl":"https://docs.google.com/spreadsheets/d/1AEbbhYgDMouucbzE4OOxLUXoYLMr2nNyWqE4wq3rTeU/edit"},"code":"200"}
			response.setLength(0);
			response.append(dataObj.get("url")).toString(); // result의 결과값도 json형태이므로 다시한번 get(String key)를 이용하여 url의 값을
															// 가져온다.

		} catch (Exception e) {
			System.out.println(e);
		}
		return response.toString();
	}

	// captcha 키값 반환 메서드
	public static String getCaptchaKey(String id, String secret) {
		String key = null;
		String clientId = id;// 애플리케이션 클라이언트 아이디값";
		String clientSecret = secret;// 애플리케이션 클라이언트 시크릿값";
		StringBuffer response = new StringBuffer();
		try {
			String code = "0"; // 키 발급시 0, 캡차 이미지 비교시 1로 세팅
			String apiURL = "https://openapi.naver.com/v1/captcha/nkey?code=" + code;
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();
			// System.out.println(response.toString());
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObj = (JSONObject) jsonParser.parse(response.toString());
			key = (String) jsonObj.get("key");
		} catch (Exception e) {
			System.out.println(e);
		}
		return key;
	}

	//captcha 이미지 반환 메서드
	public static boolean isCaptchaImage(String id, String secret, String key) {
		boolean isSuccess = false;
		String clientId = id;// 애플리케이션 클라이언트 아이디값";
		String clientSecret = secret;// 애플리케이션 클라이언트 시크릿값";
		try {
			// String key = key; // https://openapi.naver.com/v1/captcha/nkey 호출로 받은 키값
			String apiURL = "https://openapi.naver.com/v1/captcha/ncaptcha.bin?key=" + key;
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) { // 정상 호출
				InputStream is = con.getInputStream();
				int read = 0;
				byte[] bytes = new byte[1024];
				// 랜덤한 이름으로 파일 생성
				String tempname = String.valueOf(new Date().getTime());
				String path = "C:\\dev\\test"; // 여러분 환경에 맞게 절대경로를 설정하세요.
				Calendar c = Calendar.getInstance();
				File file = new File(path,Utility.getDate(c, "yyyy\\MM\\dd"));
				file.mkdirs();
				File f = new File(file, tempname + ".jpg");
				// f.createNewFile(); => 어짜피 FileOutputStream에서 파일을 생성해줌
				FileOutputStream fos = new FileOutputStream(f);
				while ((read = is.read(bytes)) != -1) {
					fos.write(bytes, 0, read);
				}
				is.close();
				isSuccess = true;
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
				while ((inputLine = br.readLine()) != null) {
					response.append(inputLine);
				}
				br.close();
				System.out.println(response.toString());

			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return isSuccess;
	}

	// captcha 비교
	public static boolean isCaptchaResult(String id, String secret, String key, String value) {
		boolean result = false;
		String clientId = id; // 애플리케이션 클라이언트 아이디값";
		String clientSecret = secret; // 애플리케이션 클라이언트 시크릿값";
		try {
			String code = "1"; // 키 발급시 0, 캡차 이미지 비교시 1로 세팅
			// String key = "9y6etyRKcYTFkVDW"; // 캡차 키 발급시 받은 키값
			// String value = "p95y"; //사용자가 입력한 캡차 이미지 글자값
			String apiURL = "https://openapi.naver.com/v1/captcha/nkey?code=" + code + "&key=" + key + "&value="
					+ value;

			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();
			//System.out.println(response.toString()); 
			JSONParser jsonParser = new JSONParser(); 
			JSONObject jsonObj = (JSONObject)jsonParser.parse(response.toString());
			result = (boolean) jsonObj.get("result"); // auto-unboxing : Wrapper class => primitive type
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}
	
	//qrcode를 만드는 메서드
	public static boolean isQrcode(String content, int width, int height) {
		QRCodeWriter writer = new QRCodeWriter();
		boolean isSuccess = false;
		try {
			BitMatrix qrCode = writer.encode( content, BarcodeFormat.QR_CODE, width, height);
			BufferedImage qrImage = MatrixToImageWriter.toBufferedImage(qrCode);
			File f = new File("C:\\dev\\test\\qrcode.png");
			isSuccess = ImageIO.write(qrImage, "png", f);
		} catch (WriterException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	public static String getKoreanDate(String date) { //Aug 05, 2019 // 2019년 08월 05일
		String koreanDate = null;
		SimpleDateFormat from = new SimpleDateFormat("MMM dd, yyyy",Locale.US);
		SimpleDateFormat to = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			Date d = from.parse(date); // date => Aug 05, 2019
			koreanDate = to.format(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return koreanDate;// 2019-08-05, 타입을 마음대로 지정가능
	}
}
