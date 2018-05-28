package t;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import application.Main;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.StringConverter;

public class rootcontroller implements Initializable
{
	
	@FXML
	public Button btn;
	@FXML
	public Button btn1;
	@FXML
	public TextField id;
	@FXML
	public TextField name;
	
	////////////////////////////////////////
	@FXML public Label label;
	@FXML public TableView<borrowdetails> tablebook;
	@FXML public TableColumn<borrowdetails, String> columnnum;
	@FXML public TableColumn<borrowdetails, String> columnname;
	@FXML public TableColumn<borrowdetails, String> columnauthor;
	@FXML public TableColumn<borrowdetails, String> columnstatus;
	@FXML public TableColumn<borrowdetails, String> t5;
	@FXML public TableColumn<borrowdetails, String> t6;
	@FXML public TableColumn<borrowdetails, String> t7;
	@FXML public Button loadbtn;
	@FXML public Label label1;
	@FXML public Label label2;
	@FXML public DatePicker datePicker;
	public ObservableList<borrowdetails> data;
	@FXML
	public TextField searchtext;
	@FXML ListView<String> listView;
	
	public DbConnection dc;
	Popup popup;
	TextArea textarea;

	@FXML private Button cancelButton;
	
	@FXML private Label userID;
	
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
		popup = new Popup();
		textarea = new TextArea("");
		
		dc = new DbConnection();
		btn.setOnAction(event -> {
			
			Insert(event);
			
		});
		loadbtn.setOnAction(e -> view1(e));

		cancelButton.setOnAction(event->cancelButtonAction(event));
		userID.setText(Main.userID);
	}
	
	public void view1(ActionEvent e)
	{
		try
		{
			if (searchtext.getText().equals(""))
			{
				data = FXCollections.observableArrayList();
				Connection conn = dc.Connect();
				ResultSet rs = conn.createStatement().executeQuery("select * from LRS.book");
				
				while (rs.next())
				{
					data.add(new borrowdetails(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7)));
				}
			} else
			{
				data = FXCollections.observableArrayList();
				data.clear();
				Connection conn = dc.Connect();
				ResultSet rs = conn.createStatement().executeQuery("select * from LRS.book WHERE title LIKE '%" + searchtext.getText() + "%'");
				
				while (rs.next())
				{
					data.add(new borrowdetails(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7)));
				}
			}
			
		} catch (Exception e3)
		{
			System.out.println("error" + e3);
		}
		columnnum.setCellValueFactory(new PropertyValueFactory<>("num"));
		columnname.setCellValueFactory(new PropertyValueFactory<>("name"));
		columnauthor.setCellValueFactory(new PropertyValueFactory<>("author"));
		columnstatus.setCellValueFactory(new PropertyValueFactory<>("status"));
		t5.setCellValueFactory(new PropertyValueFactory<>("tt5"));
		t6.setCellValueFactory(new PropertyValueFactory<>("tt6"));
		t7.setCellValueFactory(new PropertyValueFactory<>("tt7"));
		tablebook.setItems(null);
		tablebook.setItems(data);
	}
	
	@FXML
	public void ClickItem(MouseEvent event)
	{
		if (event.getClickCount() == 2) // Checking double click
		{
			String num = tablebook.getSelectionModel().getSelectedItem().getNum();
			String name = tablebook.getSelectionModel().getSelectedItem().getName();
			
			label2.setText(name);
			label1.setText(num);
		}
	}
	
	String strDate = new String();
	StringConverter<LocalDate> converter = new StringConverter<LocalDate>()
	{
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		@Override
		public LocalDate fromString(String str)
		{
			// TODO Auto-generated method stub
			if (str != null && !str.isEmpty())
				return LocalDate.parse(str, dateFormatter);
			else
				return null;
		}
		
		@Override
		public String toString(LocalDate date)
		{
			// TODO Auto-generated method stub
			if (date != null)
				return dateFormatter.format(date);
			else
				return null;
		}
		
	};
	int returnvalue = 0;
	String returndate = "";
	
	public void ttt(ActionEvent event)
	{
		datePicker.setConverter(converter);
		LocalDate value = datePicker.getValue();
		strDate = value.getYear() + "-" + value.getMonthValue() + "-" + value.getDayOfMonth();
		returnvalue = value.getDayOfMonth() + 14;
		returndate = value.getYear() + "-" + value.getMonthValue() + "-" + returnvalue;
		System.out.println(strDate);
		
	}
	
	public void Insert(ActionEvent event)
	{
		try
		{
			String usedb = "use LRS;";
			String insertdb = "INSERT INTO borrow(booknum,bookname,borrowdate,returndate)" + "values('"
					+ label1.getText() + "','" + label2.getText() + "','" + strDate + "','" + returndate + "'" + ")";
			Statement statement;
			
			System.out.println(insertdb);
			statement = getConnection().createStatement();
			statement.executeUpdate(usedb);
			statement.executeUpdate(insertdb);
			
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("대출");
			alert.setHeaderText("정상적으로 대출 되었습니다.");
			alert.setContentText(
					label1.getText() + "\n" + label2.getText() + "\n" + strDate + "\n" + "이용해주셔서 감사합니다.");
			
			alert.showAndWait();
			
		} catch (Exception e2)
		{
			System.out.println(e2);
			e2.printStackTrace();
		}
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