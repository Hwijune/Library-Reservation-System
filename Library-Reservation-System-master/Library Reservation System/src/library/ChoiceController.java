
package library;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Vector;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ChoiceController implements Initializable
{
	public DbConnection dc;
	public TextField UserName;
	public Button one, log;
	public Button two;
	public AnchorPane pane;
	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		// TODO Auto-generated method stub
		dc=new DbConnection();
	}
	
	public void logout(MouseEvent event)
	{
		if(log.getText().equals("로그아웃"))
		{
			log.setText("login");
			UserName.setText("로그인하세요");
			try {
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
	
	Main town = new Main();
	public void floor1(MouseEvent event) throws IOException
	{	
		AnchorPane pane1 = town.pane1;
		town.maketable();
		checkreser();//자리확인
		
		Scene choice = new Scene(pane1);
		Stage sit = (Stage) ((Node) event.getSource()).getScene().getWindow();
		
		sit.setTitle("열람실 선택");
		sit.setScene(choice);
		sit.show();
		
	}
	public void checkreser()
	{
		try
		{
			Connection conn = dc.Connect();
			ResultSet rs = conn.createStatement().executeQuery("select resernum from LRS.reser");
			while (rs.next())
			{
				System.out.println(rs.getString(1));
				for (int i = 0; i < town.table.size(); i++)
				{
					if (town.table.get(i).getText().equals(rs.getString(1)))
					{
						town.table.get(i).setStyle("-fx-background-color:#FF0000;");
						town.table.get(i).setText("");
						town.table.get(i).setDisable(true);
					}
				}
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void floor2(MouseEvent event) throws IOException
	{
		Main town = new Main();
		AnchorPane pane1 = town.pane1;
		town.maketable();
		checkreser();//자리확인
		
		Scene choice = new Scene(pane1);
		Stage sit = (Stage) ((Node) event.getSource()).getScene().getWindow();
		
		sit.setTitle("열람실 선택");
		sit.setScene(choice);
		sit.show();
		
	}
	
}


