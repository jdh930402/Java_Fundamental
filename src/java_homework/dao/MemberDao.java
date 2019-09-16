package java_homework.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java_homework.dto.MemberDto;

public class MemberDao {
	private static MemberDao single;
	static {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	private MemberDao() {
		
	}
	
	public static MemberDao getInstance() {
		if(single == null) {
			single = new MemberDao();
		}
		return single;
	}

	public boolean insert(MemberDto m) {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		int index = 0;
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic?user=kic12&password=kic1234");
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO member(m_seq, m_id, m_password) ");
			sql.append("VALUES(?, ?, PASSWORD(?)) ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(++index, m.getSeq());
			pstmt.setString(++index, m.getId());
			pstmt.setString(++index, m.getPwd());
			pstmt.executeUpdate();
			isSuccess = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return isSuccess;
	}
}
