package java_homework.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpDao {
	private static EmpDao single;
	static {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private EmpDao() {

	}

	public static EmpDao getInstance() {
		if (single == null) {
			single = new EmpDao();
		}
		return single;
	}

	public boolean insert(EmpDto e) {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		int index = 0;
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic?autoReconnect=true", "kic12", "kic12");
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO emp(empno, ename, job, mgr, hiredate, sal, comm, deptno) ");
			sql.append("VALUES(?, ?, ?, ?, ?, ?, ? ,?) ");
			pstmt = con.prepareStatement(sql.toString());

			pstmt.setInt(++index, e.getEmpno());
			pstmt.setString(++index, e.getEname());
			pstmt.setString(++index, e.getJob());
			pstmt.setInt(++index, e.getMgr());
			pstmt.setString(++index, e.getDate());
			pstmt.setInt(++index, e.getSal());
			pstmt.setInt(++index, e.getComm());
			pstmt.setInt(++index, e.getDeptno());
			
			pstmt.executeUpdate();
			isSuccess = true;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return isSuccess;
	}

	public boolean update(EmpDto e) {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		int index = 0;
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic?autoReconnect=true", "kic12", "kic12");
			StringBuffer sql = new StringBuffer();
			sql.append("UPDATE emp ");
			sql.append("SET sal = ? ");
			sql.append("WHERE empno = ? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(++index, e.getSal());
			pstmt.setInt(++index , e.getEmpno());
			pstmt.executeUpdate();
			isSuccess = true;

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return isSuccess;
	}

	public boolean delete(EmpDto e) {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		int index = 0;
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic?autoReconnect=true", "kic12", "kic12");
			StringBuffer sql = new StringBuffer();
			sql.append("DELETE FROM emp ");
			sql.append("WHERE empno = ? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(++index, e.getEmpno());
			pstmt.executeUpdate();
			isSuccess = true;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return isSuccess;
	}

	public ArrayList<EmpDto> select() {
		ArrayList<EmpDto> list = new ArrayList<EmpDto>();
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kic?autoReconnect=true", "kic12", "kic12");
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno ");
			sql.append("FROM emp ");
			sql.append("ORDER BY ASC ");
			pstmt = con.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int index = 0;
				int no = rs.getInt(++index);
				String name = rs.getString(++index);
				String job = rs.getString(++index);
				int mgr = rs.getInt(++index);
				String date = rs.getString(++index);
				int sal = rs.getInt(++index);
				int comm = rs.getInt(++index);
				int deptno = rs.getInt(++index);
								
				list.add(new EmpDto( no, name, job, mgr, date, sal, comm, deptno));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
