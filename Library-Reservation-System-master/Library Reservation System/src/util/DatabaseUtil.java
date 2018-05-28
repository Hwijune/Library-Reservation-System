
package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseUtil {

	public static Connection getConnection() {
		Connection conn = null;
		try {
			/* 자신의 데이터베이스 아이디 및 비밀번호에 맞게 변경하기 */
			String dbURL = "jdbc:mysql://localhost:3306/LRS?characterEncoding=utf8&verifyServerCertificate=false&useSSL=true";
			String dbID = "root";
			String dbPassword = "root";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
}
