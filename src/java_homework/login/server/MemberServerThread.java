package java_homework.login.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;

public class MemberServerThread implements Runnable {

	private Socket socket;
	private ArrayList<MemberServerThread> list;

	public MemberServerThread(Socket socket, ArrayList<MemberServerThread> list) {
		this.socket = socket;
		this.list = list;
	}

	@Override
	public void run() {
		BufferedReader br = null;
		BufferedWriter bw = null;
		boolean isSuccess = false;
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			boolean isTrue = false;
			
			while (!isTrue) {
				String[] split = br.readLine().split("#");
				MemberDao dao = MemberDao.getInstance();

				// 회원 가입
				if (split[0].equals("1")) {
					isSuccess = dao.insert(new MemberDto(split[1], split[2], split[3]));
					if (isSuccess) {
						System.out.println("회원가입에 성공하였습니다.");
						bw.write("회원가입을 성공하였습니다.");
						bw.newLine();
						bw.flush();
					} else {
						bw.write("이미 존재하는 회원이거나 아이디가 중복됩니다.");
						bw.newLine();
						bw.flush();
					}
				}

				// 로그인
				else if (split[0].equals("2")) {
					MemberDto login = new MemberDto(split[1], split[2]);
					if (dao.checkAcct(login).size() > 0) {
						System.out.println(login.getId() + "님이 로그인하였습니다.");
						bw.write("로그인하였습니다.");
						bw.newLine();
						bw.flush();
					} else {
						bw.write("아이디나 패스워드를 확인하세요.");
						bw.newLine();
						bw.flush();
					}
				}

				else if (split[0].equals("3")) {
					MemberDto changePwd = new MemberDto(split[1], split[2], split[3]);
					if (dao.changePwd(changePwd).size() > 0) {
						dao.update(changePwd);
						System.out.println(changePwd.getId() + "님이 비밀번호를 변경하였습니다.");
						bw.write("비밀번호를 변경하였습니다.");
						bw.newLine();
						bw.flush();
					} else {
						bw.write("존재하지 않는 아이디입니다.");
						bw.newLine();
						bw.flush();
					}
				}

				else if (split[0].equals("4")) {
					MemberDto closeAcct = new MemberDto(split[1], split[2], split[3]);
					if (dao.checkAcct(closeAcct).size() > 0) {
						dao.delete(closeAcct);
						System.out.println(closeAcct.getId() + "님이 탈퇴하였습니다.");
						bw.write("회원 탈퇴되었습니다.");
						bw.newLine();
						bw.flush();
					} else {
						bw.write("존재하지 않는 회원입니다.");
						bw.newLine();
						bw.flush();
					}
				}
				
				else if(split[0].equals("5")) {
					list.remove(this);
					isTrue = true;
					System.out.print("사용자가 접속을 해제하였습니다. [현재 사용자수 : " + list.size() + "]\n");
				}
			}

		} catch (IOException e) {			
			list.remove(this);
			System.out.print("사용자가 접속을 해제하였습니다. [현재 사용자수 : " + list.size() + "]\n");
			//e.printStackTrace();
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
}
