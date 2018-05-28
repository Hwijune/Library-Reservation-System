package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DatabaseUtil;

public class UserDAO {

	public int login(String userID, String userPassword) {
		String SQL = "SELECT userPassword FROM USER WHERE userID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(userPassword))
					return 1; // 로그인 성공
				else
					return 0; // 비밀번호 틀림
			}
			return -1; // 아이디 없음
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) try {conn.close();} catch (Exception e) {e.printStackTrace();}
			if(pstmt != null) try {pstmt.close();} catch (Exception e) {e.printStackTrace();}
		}
		return -2; // 데이터베이스 오류
	}

	public int join(UserDTO userDTO) {
		String SQL = "INSERT INTO USER VALUES (?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userDTO.getUserID());
			pstmt.setString(2, userDTO.getUserPassword());
			pstmt.setString(3, userDTO.getUserGender());
			pstmt.setInt(4, userDTO.getUserAge());
			pstmt.setString(5, userDTO.getUserEmail());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(conn != null) try {conn.close();} catch (Exception e) {e.printStackTrace();}
			if(pstmt != null) try {pstmt.close();} catch (Exception e) {e.printStackTrace();}
		}
		return -1; // 데이터베이스 오류
	}
}
