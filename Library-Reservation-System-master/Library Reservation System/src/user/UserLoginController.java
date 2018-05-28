package user;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UserLoginController implements Initializable {

	@FXML private Button loginButton;
	@FXML private Button joinButton;
	@FXML private TextField userID;
	@FXML private PasswordField userPassword;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		loginButton.setOnAction(event->loginButtonAction(event));
		joinButton.setOnAction(event->joinButtonAction(event));
	}
	
	public void loginButtonAction(ActionEvent event) {
		String userID = this.userID.getText();
		String userPassword = this.userPassword.getText();
		if(userID == null || userPassword == null ||
		   userID.equals("") || userPassword.equals("")) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("오류 메시지");
			alert.setHeaderText("오류가 발생했습니다.");
			alert.setContentText("아이디 혹은 비밀번호는 빈 공간일 수 없습니다.");
			alert.showAndWait();
			return;
		}
		UserDAO userDAO = new UserDAO();
		int result = userDAO.login(userID, userPassword);
		if(result == 1) {
			try {
				Main.userID = userID;
				Parent parent = FXMLLoader.load(getClass().getResource("../main/Main.fxml"));
				Scene scene = new Scene(parent);
				Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				stage.setScene(scene);
				stage.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return;
		} else if (result == 0) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("오류 메시지");
			alert.setHeaderText("오류가 발생했습니다.");
			alert.setContentText("비밀번호가 틀립니다.");
			alert.showAndWait();
			return;
		} else if (result == -1) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("오류 메시지");
			alert.setHeaderText("오류가 발생했습니다.");
			alert.setContentText("존재하지 않는 아이디입니다.");
			alert.showAndWait();
			return;
		} else if (result == -2) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("오류 메시지");
			alert.setHeaderText("오류가 발생했습니다.");
			alert.setContentText("데이터베이스 오류가 발생했습니다.");
			alert.showAndWait();
			return;
		}
	}
	
	public void joinButtonAction(ActionEvent event) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("UserJoin.fxml"));
			Scene scene = new Scene(parent);
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
