
package library;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class UseController implements Initializable
{
	public Label txtlabel;
	@FXML
	public AnchorPane user;
	@FXML
	public TextField txtf1, txtf2, txtf3;
	@FXML
	public Label time1, time2;
	@FXML
	public Button btn1, btn2, btn3, btn4;
	public Button btn_confirm, btn_cancel;
	
	private DbConnection dc;
	public Main t = new Main();
	SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss");
	Calendar cal = Calendar.getInstance();
	String aftertime;// 종료시간
	
	public class time extends Thread
	{
		@FXML
		Label txtlabel;
		
		public time(Label txtlabel)
		{
			this.txtlabel = txtlabel;
		}
		
		public void run()
		{
			
			while (true)
			{
				try
				{
					Platform.runLater(() ->
					{
						txtlabel.setText(fmt.format(new Date()));
					});
					txtf1.setText(t.rsnum.get(t.rsnum.size() - 1));
					Thread.sleep(1000);
				} catch (Exception e)
				{
					e.printStackTrace();
					return;
				}
			}
			
		}
		
	}
	
	public Connection getConnection() throws Exception
	{
		
		try
		{
			String url = "jdbc:mysql://localhost:3306";
			String user = "root";
			String pw = "root";
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, user, pw);
			return connection;
			
		} catch (Exception e)
		{
			System.out.println(e);
		}
		return null;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		dc = new DbConnection();
		time t = new time(time1);
		t.setDaemon(true);
		t.start();
	}
	
	public void hour1(MouseEvent event) throws SQLException, Exception
	{
		if (btn1.getText().equals("1:00"))
		{
			Calendar cal = Calendar.getInstance();
			
			cal.setTime(new Date());
			
			// 10분 더하기
			cal.add(Calendar.HOUR, 1);
			
			aftertime = fmt.format(cal.getTime());
			time2.setText(aftertime);
		}
	}
	
	public void hour2(MouseEvent event)
	{
		if (btn2.getText().equals("2:00"))
		{
			Calendar cal = Calendar.getInstance();
			
			cal.setTime(new Date());
			
			// 10분 더하기
			cal.add(Calendar.HOUR, 2);
			
			aftertime = fmt.format(cal.getTime());
			time2.setText(aftertime);
		}
		
	}
	
	public void hour3(MouseEvent event)
	{
		if (btn3.getText().equals("3:00"))
		{
			Calendar cal = Calendar.getInstance();
			
			cal.setTime(new Date());
			
			// 10분 더하기
			cal.add(Calendar.HOUR, 3);
			
			aftertime = fmt.format(cal.getTime());
			time2.setText(aftertime);
			
		}
		
	}
	
	public void hour4(MouseEvent event)
	{
		if (btn4.getText().equals("4:00"))
		{
			Calendar cal = Calendar.getInstance();
			
			cal.setTime(new Date());
			
			// 10분 더하기
			cal.add(Calendar.HOUR, 4);
			
			aftertime = fmt.format(cal.getTime());
			time2.setText(aftertime);
			
		}
		
	}
	
	public void cancel(MouseEvent event)
	{
		Parent root1;
		try
		{
			root1 = FXMLLoader.load(getClass().getResource("/Main.fxml"));
			Scene select = new Scene(root1);
			Stage sit = (Stage) ((Node) event.getSource()).getScene().getWindow();
			
			sit.close();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void confirm(MouseEvent event) throws IOException
	{
		try
		{
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("대출");
			alert.setHeaderText("정상적으로 자리가 예약되었습니다.");
			alert.setContentText("자리번호 : " + txtf1.getText() + "\n시작시간 : " + time1.getText() + "\n종료시간 : "
					+ time2.getText() + "\n이용해주셔서 감사합니다.");
			
			//
			String usedb = "use LRS;";
			String insertdb = "INSERT INTO reser(resernum,time1,time2)" + "values('" + t.rsnum.get(t.rsnum.size() - 1)
					+ "','" + time1.getText() + "','" + time2.getText() + "')";
			Statement statement = getConnection().createStatement();
			statement.executeUpdate(usedb);
			statement.executeUpdate(insertdb);
			//
			alert.showAndWait();
			// Stage sit = (Stage) ((Node) event.getSource()).getScene().getWindow();
			// sit.close();
	 		try {
				Parent parent = FXMLLoader.load(getClass().getResource("../main/Main.fxml"));
				Scene scene = new Scene(parent);
				Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				stage.setScene(scene);
				stage.show();
				
				application.Main.rootStage.hide();
				// 불러낸 창 끄기
				
			} catch (Exception e) {
				e.printStackTrace();
			}	

		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
