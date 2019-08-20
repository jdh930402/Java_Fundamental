package java_homework.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BonusDao {
	private static BonusDao single;
	static {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private BonusDao() {

	}

	public static BonusDao getInstance() {
		if (single == null) {
			single = new BonusDao();
		}
		return single;
	}

	public boolean insert(BonusDto b) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean isSuccess = false;
		int index = 0;

		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic?autoReconnect=true", "kic12", "kic12");
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO bonus(ename, job, sal, comm) ");
			sql.append("VALUES(?, ?, ?, ?) ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(++index, b.getName());
			pstmt.setString(++index, b.getJob());
			pstmt.setInt(++index, b.getSal());
			pstmt.setInt(++index, b.getComm());
			pstmt.executeUpdate();
			isSuccess = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;
	}

	public boolean update(BonusDto b) {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		int index = 0;
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic?autoReconnect=true", "kic12", "kic12");
			StringBuffer sql = new StringBuffer();
			sql.append("UPDATE bonus ");
			sql.append("SET job = ? ");
			sql.append("WHERE ename = ? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(++index, b.getJob());
			pstmt.setString(++index, b.getName());
			pstmt.executeUpdate();
			isSuccess = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;
	}

	public boolean delete(BonusDto b) {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		int index = 0;
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic?autoReconnect=true", "kic12", "kic12");
			StringBuffer sql = new StringBuffer();
			sql.append("DELETE FROM bonus ");
			sql.append("WHERE ename = ? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(++index, b.getName());
			pstmt.executeUpdate();
			isSuccess = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;
	}

	public ArrayList<BonusDto> select() {
		ArrayList<BonusDto> list = new ArrayList<BonusDto>();
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic?autoReconnect=true", "kic12", "kic12");
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT 컬럼명 ");
			sql.append("FROM bonus ");
			pstmt = con.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int index = 0;
				String name = rs.getString(++index);
				String job = rs.getString(++index);
				int sal = rs.getInt(++index);
				int comm = rs.getInt(++index);
				list.add(new BonusDto(name, job, sal, comm));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
