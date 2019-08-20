package java_20190819;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class Member {
	private String id;
	private String name;

	Member(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

public class TransactionDemo {

	public boolean insert() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;

		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic?autoReconnect=true", "kic12", "kic12");
			StringBuffer sql = new StringBuffer();
			
			con.setAutoCommit(false); // ★★★트랜잭션 시작
			sql.append("INSERT INTO member VALUES('id111', '123' ,'name111')");
			pstmt1 = con.prepareStatement(sql.toString());
			pstmt1.executeUpdate();
			
			sql.setLength(0);
			sql.append("INSERT INTO member VALU('id222', '123' ,'name222')");
			pstmt2 = con.prepareStatement(sql.toString());
			pstmt2.executeUpdate();
			
			isSuccess = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(isSuccess) { // ★★★ transaction의 종료
					con.commit();
				}else {
					con.rollback();
				}
				con.setAutoCommit(true); // ★★★ Connection pool 사용할때는 반드시해주어야함.
				if (pstmt1 != null)
					pstmt1.close();
				if (pstmt2 != null)
					pstmt2.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return isSuccess;

	}

	public static void main(String[] args) {
		new TransactionDemo().insert();
	}

}
