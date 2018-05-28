package t;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class rootcontroller2 implements Initializable
{
	@FXML
	public TableView<loandetails> tablebook2;
	@FXML
	public TableColumn<loandetails, String> columnbooknum;
	@FXML
	public TableColumn<loandetails, String> columnbookname;
	@FXML
	public TableColumn<loandetails, String> columnborrowdate;
	@FXML
	public TableColumn<loandetails, String> columnreturndate;
	@FXML
	ListView<String> listView;
	public DbConnection dc;
	public ObservableList<loandetails> data2;
	@FXML
	public Button loanbtn1;

	@FXML private Label userID;
	@FXML private Button cancelButton;
	
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
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		dc = new DbConnection();
		loanbtn1.setOnAction(e -> view(e));
		userID.setText(Main.userID);
		cancelButton.setOnAction(event->cancelButtonAction(event));
	}
	
	public void view(ActionEvent e)
	{
		try
		{
			if (loanbtn1.getText().equals("º¸±â"))
			{
				
				data2 = FXCollections.observableArrayList();
				Connection conn = dc.Connect();
				ResultSet rs = conn.createStatement().executeQuery("select * from LRS.borrow");
				System.out.println("Äõ¸®");
				while (rs.next())
				{
					System.out.println(rs.getString(1) + rs.getString(2) + rs.getString(3) + rs.getString(4));
					data2.add(new loandetails(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
				}
			}
		} catch (Exception e3)
		{
			System.out.println("error" + e3);
		}
		columnbooknum.setCellValueFactory(new PropertyValueFactory<>("booknum"));
		columnbookname.setCellValueFactory(new PropertyValueFactory<>("bookname"));
		columnborrowdate.setCellValueFactory(new PropertyValueFactory<>("borrowdate"));
		columnreturndate.setCellValueFactory(new PropertyValueFactory<>("returndate"));
		
		tablebook2.setItems(null);
		tablebook2.setItems(data2);
	}
	
	public void cancelButtonAction(ActionEvent event) {
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
	
}
