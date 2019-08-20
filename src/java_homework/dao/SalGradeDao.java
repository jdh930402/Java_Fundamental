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

		public static SalGradeDao getInstance() {
			if (single == null) {
				single = new SalGradeDao();
			}
			return single;
		}
		
		public boolean insert(SalGradeDto s) {
			Connection con = null;
			PreparedStatement pstmt = null;
			boolean isSuccess = false;
			int index = 0;

			try {
				con = DriverManager.getConnection("jdbc:mariadb://localhost/kic?autoReconnect=true", "kic12", "kic12");
				StringBuffer sql = new StringBuffer();
				sql.append("INSERT INTO salgrade(grade, losal, hisal) ");
				sql.append("VALUES(?, ?, ?) ");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setInt(++index, s.getGrade());
				pstmt.setInt(++index, s.getLosal());
				pstmt.setInt(++index, s.getHisal());
				
				pstmt.executeUpdate();
				isSuccess = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return isSuccess;
		}

		public boolean update(SalGradeDto s) {
			boolean isSuccess = false;
			Connection con = null;
			PreparedStatement pstmt = null;
			int index = 0;
			try {
				con = DriverManager.getConnection("jdbc:mariadb://localhost/kic?autoReconnect=true", "kic12", "kic12");
				StringBuffer sql = new StringBuffer();
				sql.append("UPDATE salgrade ");
				sql.append("SET losal = ?, hisal = ? ");
				sql.append("WHERE grade = ? ");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setInt(++index, s.getLosal());
				pstmt.setInt(++index , s.getHisal());
				pstmt.setInt(++index, s.getGrade());
				pstmt.executeUpdate();
				isSuccess = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return isSuccess;
		}

		public boolean delete(SalGradeDto s) {
			boolean isSuccess = false;
			Connection con = null;
			PreparedStatement pstmt = null;
			int index = 0;
			try {
				con = DriverManager.getConnection("jdbc:mariadb://localhost/kic?autoReconnect=true", "kic12", "kic12");
				StringBuffer sql = new StringBuffer();
				sql.append("DELETE FROM salgrade ");
				sql.append("WHERE grade = ? ");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setInt(++index, s.getGrade());
				pstmt.executeUpdate();
				isSuccess = true;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return isSuccess;
		}
		
		public ArrayList<SalGradeDto> select(){
			ArrayList<SalGradeDto> list = new ArrayList<SalGradeDto>();
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = DriverManager.getConnection("jdbc:mariadb://localhost/kic?autoReconnect=true", "kic12", "kic12");
				StringBuffer sql = new StringBuffer();
				sql.append("SELECT grade, losal, hisal ");
				sql.append("FROM salgrade ");
				pstmt = con.prepareStatement(sql.toString());
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					int index = 0;
					int grade = rs.getInt(++index);
					int losal = rs.getInt(++index);
					int hisal = rs.getInt(++index);
					
					list.add(new SalGradeDto(grade, losal, hisal));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			return list;
		}


}
