package java_20190812;

public class MemberDemo {

	public static void main(String[] args) {
		MemberDao mdao = MemberDao.getInstance();
		MemberDto m1 = new MemberDto(2200," 트럼프3", "미국3");
		boolean isSuccess = mdao.insert(m1);
		if(isSuccess) {
			System.out.println("넣기 성공");
		}else {
			System.out.println("넣기 실패");
		}
		
		m1 = new MemberDto(22,"트럼프1", "미국1");
		isSuccess = mdao.update(m1);
		if(isSuccess) {
			System.out.println("수정 성공");
		}else {
			System.out.println("수정 실패");
		}
		
		isSuccess = mdao.delete(2200);
		if(isSuccess) {
			System.out.println("삭제 성공");
		}else {
			System.out.println("삭제 실패");
		}
		
		for(MemberDto m : mdao.select()) {
			System.out.printf("%d\t%s\t%s\t\n",m.getNum(), m.getName(), m.getAddr());			
		}
	}
}
