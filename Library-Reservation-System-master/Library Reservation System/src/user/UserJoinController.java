package user;

import java.net.URL;
import java.util.ResourceBundle;

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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class UserJoinController implements Initializable {

	@FXML private TextField userID;
	@FXML private PasswordField userPassword;
	@FXML private PasswordField userPasswordCheck;
	@FXML private RadioButton userGenderMan;
	@FXML private RadioButton userGenderWoman;
	@FXML private TextField userAge;
	@FXML private TextField userEmail;
	@FXML private Button joinButton;
	@FXML private Button cancelButton;
	
	ToggleGroup group = new ToggleGroup();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		joinButton.setOnAction(event->joinButtonAction(event));
		cancelButton.setOnAction(event->cancelButtonAction(event));
		userGenderMan.setSelected(true);
		userGenderMan.setToggleGroup(group);
		userGenderWoman.setToggleGroup(group);
	}
	
	public void joinButtonAction(ActionEvent event) {
		String userID = this.userID.getText();
		String userPassword = this.userPassword.getText();
		String userPasswordCheck = this.userPasswordCheck.getText();
		String userGender = "남자";
		if(this.userGenderWoman.isSelected() == true) {
			userGender = "여자";
		}
		int userAge = 0;
		try {
			userAge = Integer.parseInt(this.userAge.getText());
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("오류 메시지");
			alert.setHeaderText("오류가 발생했습니다.");
			alert.setContentText("나이는 숫자만 들어갈 수 있습니다.");
			alert.showAndWait();
			return;
		}
		String userEmail = this.userEmail.getText();
		if(userID == null || userPassword == null ||
		   userPasswordCheck == null || userGender == null ||
		   userAge == 0 || userEmail == null ||
		   userID.equals("") || userPassword.equals("") ||
		   userPasswordCheck.equals("") || userGender.equals("") ||
		   userEmail.equals("")) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("오류 메시지");
			alert.setHeaderText("오류가 발생했습니다.");
			alert.setContentText("내용이 빈 칸일 수 없습니다.");
			alert.showAndWait();
			return;
		} else if(!userPassword.equals(userPasswordCheck)) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("오류 메시지");
			alert.setHeaderText("오류가 발생했습니다.");
			alert.setContentText("비밀번호와 비밀번호 확인이 같지 않습니다.");
			alert.showAndWait();
			return;
		}
		UserDAO userDAO = new UserDAO();
		UserDTO userDTO = new UserDTO(
			userID,
			userPassword,
			userGender,
			userAge,
			userEmail
		);
		userDTO.setUserID(userID);
		int result = userDAO.join(userDTO);
		if(result == 1) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("성공 메시지");
			alert.setHeaderText("성공 메시지입니다.");
			alert.setContentText("회원가입에 성공했습니다.");
			alert.showAndWait();
			try {
				Parent parent = FXMLLoader.load(getClass().getResource("UserLogin.fxml"));
				Scene scene = new Scene(parent);
				Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				stage.setScene(scene);
				stage.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return;
		} else if (result == -1) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("오류 메시지");
			alert.setHeaderText("오류가 발생했습니다.");
			alert.setContentText("아이디가 중복됩니다.");
			alert.showAndWait();
			return;
		}
	}
	
	public void cancelButtonAction(ActionEvent event) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("UserLogin.fxml"));
			Scene scene = new Scene(parent);
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
