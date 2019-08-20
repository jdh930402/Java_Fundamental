package java_homework.dao;

public class SalGradeDemo {
	public static void main(String[] args) {
		SalGradeDto dto = new SalGradeDto(6 , 4000, 6000);
		SalGradeDao dao = SalGradeDao.getInstance();

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

		for (SalGradeDto s : dao.select()) {
			System.out.printf("%d %d %d", s.getGrade(), s.getLosal(), s.getHisal());
		}
	}
}
