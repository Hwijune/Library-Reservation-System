

package library;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.*;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.*;

import javafx.stage.Stage;

public class MainController implements Initializable
{
	
	public Button log;
	public TextField UserName;
	public Button choose;
	public Button move;

	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		// TODO Auto-generated method stu		
	}
	
	public void seat(MouseEvent event) throws IOException 
	{
		
		if(choose.getText().equals("좌석 선택"))
		{
			Parent root1 = FXMLLoader.load(getClass().getResource("/Choice.fxml"));
			
			
			Scene select = new Scene(root1);
			Stage sit = (Stage) ((Node) event.getSource()).getScene().getWindow();
			
			sit.setTitle("층 선택");
			sit.setScene(select);
			sit.show();
		}
	}
	
	public void logout(MouseEvent event)
	{
		if(log.getText().equals("로그아웃"))
		{
			log.setText("login");
			UserName.setText("로그인하세요");
			System.out.println("sdfsdf");			try {
				Parent parent = FXMLLoader.load(getClass().getResource("../main/Main.fxml"));
				Scene scene = new Scene(parent);
				Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				stage.setScene(scene);
				stage.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else
		{
			log.setText("logout");
			UserName.setText("사용자:  id");
		}
	}
	
	public void moveTo(MouseEvent event) throws IOException
	{
		if(move.getText().equals("좌석 이동"))
		{
			Parent MoveSeat = FXMLLoader.load(getClass().getResource("/Choice.fxml"));
			Scene moveone = new Scene(MoveSeat);
			Stage sit = (Stage) ((Node) event.getSource()).getScene().getWindow();
			
			sit.setTitle("층 선택");
			sit.setScene(moveone);
			sit.show();
		}
	}
	
	
	
}


