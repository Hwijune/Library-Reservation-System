package user;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class newBookController implements Initializable {

	@FXML private Label cancelButton;
	
	ToggleGroup group = new ToggleGroup();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cancelButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
		     @Override
		     public void handle(MouseEvent event) {
		 		try {
					Parent parent = FXMLLoader.load(getClass().getResource("../main/Main.fxml"));
					Scene scene = new Scene(parent);
					Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
					stage.setScene(scene);
					stage.show();
				} catch (Exception e) {
					e.printStackTrace();
				}	
		         event.consume();
		     }
		});
	}

}
