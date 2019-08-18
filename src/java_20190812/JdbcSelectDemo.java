package java_20190812;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcSelectDemo {
	public static void main(String[] args) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic?user=kic12&password=kic12");
			StringBuffer sql = new StringBuffer();
			sql.append("Select num, name, addr ");
			sql.append("From member ");

			pstmt = con.prepareStatement(sql.toString());

			rs = pstmt.executeQuery();

			// 커서가 컬럼에 있다가 next()메서드에 의해 데이터가 있는 행으로 이동.
			// 만약 행이 존재하면 true, 없으면 false를 반환한다.
			while (rs.next()) {
				int num = rs.getInt(1); // 인덱스 번호는 1부터 시작한다.
				String name = rs.getString(2);
				String addr = rs.getString(3);
				System.out.printf("번호 : %d, 이름 : %s, 주소 : %s\n", num, name, addr);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
