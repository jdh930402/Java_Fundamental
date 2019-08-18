package java_20190812;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcPractice {
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
			con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/kic?user=kic12&password=kic12");
			StringBuffer sql = new StringBuffer();
			sql.append("Delete from member ");
			sql.append("where num = ?");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, 12);		
			pstmt.executeUpdate();
			
			StringBuffer sql2 = new StringBuffer();
			sql2.append("select num, name, addr ");
			sql2.append("from member");
			
			pstmt = con.prepareStatement(sql2.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int num = rs.getInt(1);
				String name = rs.getString(2);
				String addr = rs.getString(3);
				System.out.printf("번호 : %d, 이름 : %s, 주소 : %s\n", num, name, addr);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
