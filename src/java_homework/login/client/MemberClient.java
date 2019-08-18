package java_homework.login.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MemberClient {
	private Socket socket;

	public MemberClient(String ip, int port) {
		try {
			socket = new Socket(ip, port);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String console(String str) {
		System.out.print(str);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String readLine = null;
		try {
			readLine = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return readLine;
	}

	private String ui() {
		System.out.println("1.sign up 2.login 3.change password 4.close my account 5.exit");
		String readLine = console("번호를 입력하세요>");
		return readLine;
	}

	public void run() {
		BufferedWriter bw = null;
		BufferedReader br = null;
		String id = null;
		String pwd = null;
		String name = null;

		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			boolean isLoop = false; 
			while (!isLoop) {
				String readNumber = ui();
				switch (readNumber) {
				// 회원 가입
				case "1":
					name = console("이름을 입력하세요>");
					id = console("아이디를 입력하세요>");
					pwd = console("비밀번호를 입력하세요>");
					bw.write("1#" + id + "#" + pwd + "#" + name);
					bw.newLine();
					bw.flush();

					System.out.println(br.readLine());
					run();
					break;

				// 로그인
				case "2":
					id = console("아이디를 입력하세요>");
					pwd = console("비밀번호를 입력하세요>");
					bw.write("2#" + id + "#" + pwd);
					bw.newLine();
					bw.flush();

					System.out.println(br.readLine());
					run();
					break;
				// 비밀번호 변경
				case "3":
					name = console("이름을 입력하세요>");
					id = console("아이디를 입력하세요>");
					pwd = console("변경할 비밀번호를 입력하세요>");
					bw.write("3#" + id + "#" + pwd + "#" + name);
					bw.newLine();
					bw.flush();

					System.out.println(br.readLine());
					run();
					break;

				// 회원 탈퇴
				case "4":
					name = console("이름을 입력하세요>");
					id = console("아이디를 입력하세요>");
					pwd = console("비밀번호를 입력하세요>");
					bw.write("4#" + id + "#" + pwd + "#" + name);
					bw.newLine();
					bw.flush();

					System.out.println(br.readLine());
					run();
					break;

				// 종료
				case "5":
					bw.write("5#");
					bw.newLine();
					bw.flush();
					isLoop = true;
					break;

					// 없는 값 입력시
				default:
					System.out.println("잘못된 입력입니다.");
					run();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (br != null)
					br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		}
	}

	public static void main(String[] args) {
		new MemberClient("127.0.0.1", 3000).run();
	}
}
