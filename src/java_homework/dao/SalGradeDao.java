package java_homework.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SalGradeDao {
		private static SalGradeDao single;
		static {
			try {
				Class.forName("org.mariadb.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		private SalGradeDao() {

		}

		public SalGradeDao getInstance() {
			if (single == null) {
				single = new SalGradeDao();
			}
			return single;
		}
		
		private boolean insert(SalGradeDao s) {
			Connection con = null;
			PreparedStatement pstmt = null;
			boolean isSuccess = false;
			int index = 0;

			try {
				con = DriverManager.getConnection("jdbc:mariadb://localhost/kic?autoReconnect=true", "kic12", "kic12");
				StringBuffer sql = new StringBuffer();
				sql.append("INSERT INTO salgrade(컬럼명...) ");
				sql.append("VALUES(?, ?, ?) ");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(++index, x);
				pstmt.setString(++index, x);
				pstmt.setString(++index, x);
				pstmt.executeUpdate();
				isSuccess = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return isSuccess;
		}

		private boolean update(SalGradeDao s) {
			boolean isSuccess = false;
			Connection con = null;
			PreparedStatement pstmt = null;
			int index = 0;
			try {
				con = DriverManager.getConnection("jdbc:mariadb://localhost/kic?autoReconnect=true", "kic12", "kic12");
				StringBuffer sql = new StringBuffer();
				sql.append("UPDATE salgrade ");
				sql.append("SET 컬럼명 = 변경값 ");
				sql.append("WHERE 조건 ");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(++index, x);
				pstmt.executeUpdate();
				isSuccess = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return isSuccess;
		}

		private boolean delete(SalGradeDao s) {
			boolean isSuccess = false;
			Connection con = null;
			PreparedStatement pstmt = null;
			int index = 0;
			try {
				con = DriverManager.getConnection("jdbc:mariadb://localhost/kic?autoReconnect=true", "kic12", "kic12");
				StringBuffer sql = new StringBuffer();
				sql.append("DELETE FROM salgrade ");
				sql.append("WHERE 조건 ");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(++index, x);
				pstmt.executeUpdate();
				isSuccess = true;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return isSuccess;
		}
		
		private ArrayList<BonusDto> select(){
			ArrayList<SalGradeDto> list = new ArrayList<SalGradeDto>();
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = DriverManager.getConnection("jdbc:mariadb://localhost/kic?autoReconnect=true", "kic12", "kic12");
				StringBuffer sql = new StringBuffer();
				sql.append("SELECT 컬럼명 ");
				sql.append("FROM salgrade ");
				pstmt = con.prepareStatement(sql.toString());
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					int index = 0;
					타입 변수 = rs.getString(++index);
					list.add(new SalGradeDto());
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}


}
