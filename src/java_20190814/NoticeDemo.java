package java_20190814;

public class NoticeDemo {
	public static void main(String[] args) {
		NoticeDto n1 = new NoticeDto(1, "하", "하", "하", "");
		NoticeDao dao = NoticeDao.getInstance();
		boolean isSuccess = false;

		isSuccess = dao.insert(n1);
		if (isSuccess) {
			System.out.println("삽입 성공");
		}else {
			System.out.println("삽입 실패");
		}
		
		
		isSuccess = dao.delete(13);
		if (isSuccess) {
			System.out.println("삭제 성공");
		}else {
			System.out.println("삭제 실패");
		}
		
		for(NoticeDto n : dao.select()) {
			System.out.printf("%d\t %s\t %s\t %s\t %s\n", n.getNum(), n.getWrite(), n.getTitle(), n.getContent(), n.getRegdate());
		}
	
		NoticeDto n2 = new NoticeDto(1, "호", "하", "호", "");
		isSuccess = dao.update(n2);
		if (isSuccess) {
			System.out.println("수정 성공");
		}else {
			System.out.println("수정 실패");
		}

		
	}
}
