package java_20190801;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

class FileDemo {
	public void mkdirs(String path) {
		File f1 = new File(path);
		boolean isExisted = f1.isDirectory();
		if (!isExisted) {
			f1.mkdirs();
		}
	}

	public void createFile(String name) {
		File f1 = new File(name);
		boolean isExisted = f1.isFile();
		if (!isExisted) {
			try {
				f1.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public String getComma(long name) {
		return String.format("%,d", name);
	}

	public String getComma(double name, int precision) {
		return String.format("%,." + precision + "f", name);
	}

	public void changeFile(String path) {
		// path => c:\dev\test\jdk.exe => c:\dev\test\현재시각의 밀리세컨드.exe
		File f1 = new File(path);
		String fileName = f1.getName(); // 전체 경로중 파일 이름만 반환
		String name = fileName.substring(0, fileName.lastIndexOf("."));
		String extension = fileName.substring(fileName.lastIndexOf("."));
		name = String.valueOf(System.currentTimeMillis());
		fileName = name + extension;
		String parent = f1.getParent(); // 파일에 있는 디렉토리까지만 반환한다.
		File f2 = new File(parent, fileName);
		f1.renameTo(f2);
	}

	public static void main(String[] args) {

		FileDemo f1 = new FileDemo();
		f1.mkdirs("C:\\dev\\test");
		f1.createFile("C:\\dev\\test\\test.txt");

		File f2 = new File("C:\\dev\\test", "jdk-11.0.3_windows-x64_bin.exe");
		long fileSize = f2.length() / 1024;
		System.out.println(f1.getComma(fileSize) + "KB");
		boolean isFile = f2.isFile();
		if (isFile) {
			if (f2.getName().endsWith("exe")) {
				System.out.println("exe파일");
			}
			if (f2.getName().endsWith("pdf")) {
				System.out.println("pdf파일");
			}
			if (f2.getName().endsWith("txt")) {
				System.out.println("txt파일");
			}
			if (f2.getName().endsWith("zip")) {
				System.out.println("zip파일");
			}
		} else {
			System.out.println("파일폴더");
		}
		File f3 = new File("C:\\dev\\test", "jdk.exe");
		f2.renameTo(f3); // f2에서 참조한파일을 f3에서 파일이름 변경.
		System.out.println(f3.getName());
		//f1.changeFile(f3.getPath());

		File f4 = new File("C:\\dev\\test", "jdk.exe");
		String fileName = f4.getName(); // 파일명
		String path = f4.getPath(); // 경로 + 파일명
		String parent = f4.getParent(); // 경로
		System.out.println(fileName);
		System.out.println(path);
		System.out.println(parent);
		System.out.println(f4.lastModified());

		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(f4.lastModified());
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		// c.set(year, month, day);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss E");
		String date = sdf.format(c.getTime());
		System.out.println(date);

		File f5 = new File("c:\\dev\\test");
		String[] lists = f5.list();
		for (String list : lists) {
			File f6 = new File(f5, list); // f5의 객체로 파일주소를 불러올 수 있다
			String name = f6.getName();
			if (f6.isDirectory()) {
				System.out.println(name + "-디렉토리");
			} else {
				fileSize = f6.length() / 1024;
				c.setTimeInMillis(f6.lastModified());
				String lastModified = sdf.format(c.getTime());
				System.out.println(name + "-파일" + "\t" + fileSize + "KB\t" + lastModified);
			}
		}
	}
}
