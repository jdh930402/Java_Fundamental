package java_homework.dto;

import java_homework.dao.MemberDao;

public class MemberDemo {
	public static void main(String[] args) {
		MemberDao dao = MemberDao.getInstance();
		MemberDto dto = new MemberDto(1, "syh1011", "1234");
		
		dao.insert(dto);
	}
}
