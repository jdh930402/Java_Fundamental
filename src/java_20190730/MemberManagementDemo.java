package java_20190730;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberManagementDemo {
	private ArrayList<Member> list;

	public MemberManagementDemo() {
		list = new ArrayList<Member>();
	}

	public void print() {
		System.out.println("**********************************************");
		System.out.println("* 1.insert 2.update 3.delete 4.search 5.exit *");
		System.out.println("**********************************************");
	}

	public String console(String msg) {
		System.out.print(msg);
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}

	// 1.아이디를 입력받는다.
	// 2.이름을 입력받는다.
	// 3.ArrayList에 고객을 추가한다.
	// 4.ArrayList에 있는 고객을 모두 출력한다.
	// 5.print() 메서드를 호출한다
	// 6.번호를 선택하세요> 메세지를 출력후 키보드를 입력받는다.
	private void insert() {
		String id = console("아이디>");
		String name = console("이름>");
		Member m = new Member(id, name);
		list.add(m);
		Common();
	}

	// 1.수정할 아이디를 입력받는다.
	// 2.ArrayList에 있는 고객정보 중에서 수정할 아이디를 찾아서 있으면 수정할
	// 이름을 입력받고, ArrayList에 고객정보를 수정하고, "없으면 수정할 아이디가 없습니다." 메세지를 출력한다.
	// 3.ArrayList에 있는 모든 고객을 출력한다.
	// 5.print() 메서드를 호출한다
	// 6.번호를 선택하세요> 메세지를 출력후 키보드를 입력받는다.
	private void update() {
		String updateId = console("아이디>");
		boolean isExisted = false;
		for (Member member : list) {
			if (updateId.equals(member.getId())) {
				isExisted = true;
				break;
			}
		}
		if (isExisted) {
			String updateName = console("수정할 이름>");
			for (Member member : list) {
				if (updateId.equals(member.getId())) {
					member.setName(updateName);
					for (Member printMember : list) {
						System.out.println(printMember);
					}
					break;
				}
			}
		} else {
			System.out.println("수정할 아이디가 없습니다.");
		}
		Common();
	}

	// 1.삭제할 아이디를 입력받는다.
	// 2.ArrayList의 Member객체 중에서 삭제할 아이디를 찾아 있으면 삭제하고, 삭제할 아이디가 없으면 삭제할 아이디가 없습니다.
	// 메세지를 출력한다.
	// 3.ArrayList에 있는 모든 고객을 출력한다.
	// 4.print()호출
	// 5.번호를 선택하세요> 메세지를 출력후 키보드를 입력받는다.
	private void delete() {
		String deleteId = console("아이디>");
		boolean isExisted = false;
		for (Member member : list) {
			if (deleteId.equals(member.getId())) {
				list.remove(member);
				isExisted = true;
				break;
			}
		}
		if (!isExisted) {
			System.out.println("삭제할 아이디가 없습니다.");
		}
		Common();
	}
	
	// 1. 검색할 아이디를 입력받는다.
	// 2. ArrayList에 Member객체에 검색할 아이디를 찾아서 있으면 출력하고
	// 3. 없으면 검색된 결과가 없습니다. 메서자를 출력
	// 4.print()호출
	// 5.번호를 선택하세요> 메세지를 출력후 키보드를 입력받는다.
	private void search() {
		String searchId = console("검색할 아이디>");
		System.out.println("********************검색결과********************");
		boolean isExisted = false;
		for(Member member : list) {
			if(member.getId().equals(searchId)){
				isExisted = true;
				System.out.println(member);
				break;
			}		
		}
		if(!isExisted) {
			System.out.println("검색된 결과가 없습니다.");
		}
		System.out.println("**********************************************");
		Common();		
	}

	private void Common() {
		for(Member member : list) {
			System.out.println(member);
		}
		print();
		String selectedIndex = console("번호를 선택하세요 > ");
		run(selectedIndex);
	}

	private void run(String selectedIndex) {
		if (selectedIndex.equals("1")) {
			System.out.println("insert.....");
			insert();

		} else if (selectedIndex.equals("2")) {
			System.out.println("update.....");
			update();
		} else if (selectedIndex.equals("3")) {
			System.out.println("delete.....");
			delete();

		} else if (selectedIndex.equals("4")) {
			System.out.println("search.....");
			search();

		} else if (selectedIndex.equals("5")) {
			System.out.println("exit.....");
		} else {
			System.out.println("Warning...");
			print();
			selectedIndex = console("번호를 선택하세요 > ");
			run(selectedIndex);
		}
	}

	public static void main(String[] args) {
		MemberManagementDemo m1 = new MemberManagementDemo();
		m1.print();
		String selectedIndex = m1.console("번호를 선택하세요 > ");
		m1.run(selectedIndex);
	}
}
