package java_20190812;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcInsertDemo {
	public static void main(String[] args) {
		// JDBC 드라이버 클래스를 로딩
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("Driver Load Success...");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Load Fail...");
		}

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic?autoReconnect=true", "kic12", "kic12");
			// getConnection(url, user, password); url, 사용자, 패스워드

			StringBuffer sql = new StringBuffer();
			sql.append("insert into member(num, name, addr)");
			sql.append("values (?,?,?)");

			pstmt = con.prepareStatement(sql.toString());
			// pstmt.setInt(1, 11);
			// pstmt.setString(2, "베조스");
			// pstmt.setString(3, "캐나다");

			pstmt.setInt(1, 12);
			pstmt.setString(2, "주커버그");
			pstmt.setString(3, "이스라엘");

			// excuteUpdate() => insert, update, delete문 일때 사용. 반환값은 갱신된 행의 수이다.
			//
			int resultCount = pstmt.executeUpdate(); // sql문 전송
			System.out.println("갱신된 행의 수 : " + resultCount);

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
