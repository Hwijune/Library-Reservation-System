
package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseUtil {

	public static Connection getConnection() {
		Connection conn = null;
		try {
			/* �ڽ��� �����ͺ��̽� ���̵� �� ��й�ȣ�� �°� �����ϱ� */
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
