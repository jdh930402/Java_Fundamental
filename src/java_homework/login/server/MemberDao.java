package java_homework.login.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
		if (single == null) {
			single = new MemberDao();
		}
		return single;
	}

	public boolean insert(MemberDto d) {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		int index = 0;

		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic?user=kic12&password=kic12");
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO member(id, pwd, mname) ");
			sql.append("VALUES(?, PASSWORD(?), ? )");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(++index, d.getId());
			pstmt.setString(++index, d.getPwd());
			pstmt.setString(++index, d.getName());
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

	public boolean update(MemberDto m) {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		int index = 0;
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic?user=kic12&password=kic12");
			StringBuffer sql = new StringBuffer();
			sql.append("UPDATE member ");
			sql.append("SET pwd = PASSWORD(?) ");
			sql.append("WHERE id = ? AND mname = ? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(++index, m.getPwd());
			pstmt.setString(++index, m.getId());
			pstmt.setString(++index, m.getName());
			pstmt.executeUpdate();
			isSuccess = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;
	}

	public boolean delete(MemberDto m) {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		int index = 0;
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic?user=kic12&password=kic12");
			StringBuffer sql = new StringBuffer();
			sql.append("DELETE FROM member ");
			sql.append("WHERE mname = ? AND id = ? AND pwd = PASSWORD(?) ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(++index, m.getName());
			pstmt.setString(++index, m.getId());
			pstmt.setString(++index, m.getPwd());
			pstmt.executeUpdate();
			isSuccess = true;
		} catch (SQLException e) {
			isSuccess = false;
			e.printStackTrace();
		}
		return isSuccess;
	}

	public ArrayList<MemberDto> checkAcct(MemberDto m) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ArrayList<MemberDto> list = new ArrayList<MemberDto>();
		int index = 0;
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic?user=kic12&password=kic12");
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT id, PASSWORD(pwd) ");
			sql.append("from member ");
			sql.append("where id = ? and pwd = Password(?) ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(++index, m.getId());
			pstmt.setString(++index, m.getPwd());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				index = 0;
				String id = rs.getString(++index);
				String password = rs.getString(++index);
				list.add(new MemberDto(id, password));
			}

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
		return list;
	}

	public ArrayList<MemberDto> changePwd(MemberDto m) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ArrayList<MemberDto> list = new ArrayList<MemberDto>();
		int index = 0;
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic?user=kic12&password=kic12");
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT id ");
			sql.append("from member ");
			sql.append("where id = ? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(++index, m.getId());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				index = 0;
				String id = rs.getString(++index);
				list.add(new MemberDto(id));
			}

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
		return list;
	}
}
