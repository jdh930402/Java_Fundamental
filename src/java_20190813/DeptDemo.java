package java_20190813;

public class DeptDemo {
	public static void main(String[] args) {
		DeptDao dao = DeptDao.getInstance();
		boolean isSuccess = false;

		// insert
		isSuccess = dao.insert(new DeptDto(50, "Development", "강남역"));
		if (isSuccess) {
			System.out.println("부서가 추가되었습니다.");
		} else {
			System.out.println("추가 오류");
		}

		// update
		isSuccess = dao.update(new DeptDto(50, "개발부", "서초역"));
		if (isSuccess) {
			System.out.println("부서가 수정되었습니다.");
		} else {
			System.out.println("수정 오류");
		}

		// select
		for (DeptDto d : dao.select()) {
			System.out.printf("%d\t %s\t %s\n", d.getNo(), d.getName(), d.getLoc());
		}

		// delete
		isSuccess = dao.delete(50);
		if (isSuccess) {
			System.out.println("부서가 삭제되었습니다.");
		} else {
			System.out.println("삭제 오류");
		}

	}
}
