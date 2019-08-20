package java_homework.dao;

public class BonusDemo {
	public static void main(String[] args) {
		BonusDto dto = new BonusDto("홍길동", "무직", 100000, 100000);
		BonusDao dao = BonusDao.getInstance();
		
		boolean isSuccess = dao.insert(dto);
		if (isSuccess) {
			System.out.println("삽입 성공");
		} else {
			System.out.println("삽입 실패");
		}
		
		isSuccess = dao.update(dto);
		if (isSuccess) {
			System.out.println("수정 성공");
		} else {
			System.out.println("수정 실패");
		}
		
		isSuccess = dao.delete(dto);
		if (isSuccess) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
		
		for(BonusDto b : dao.select() ) {
			System.out.printf("%s\t %s\t %d\t %d", b.getName(), b.getJob(), b.getSal(), b.getComm());
		}
	}
}
