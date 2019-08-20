package java_homework.dao;

public class EmpDemo {
	public static void main(String[] args) {
		EmpDto dto = new EmpDto(9000, "JI", "DEVELOPEMENT", 7935, "2019-08-19", 1000, 500, 10);
		EmpDao dao = EmpDao.getInstance();

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

		for (EmpDto e : dao.select()) {
			System.out.printf("%d\t %s\t %s\t %d\t %s\t %d\t %d\t %d", e.getEmpno(), e.getEname(), e.getJob(),
					e.getMgr(), e.getDate(), e.getSal(), e.getComm(), e.getDeptno());
		}
	}
}
