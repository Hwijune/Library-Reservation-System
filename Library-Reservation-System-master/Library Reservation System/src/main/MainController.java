package main;

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
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MainController implements Initializable {

	@FXML private ImageView image1;
	@FXML private ImageView image2;
	@FXML private ImageView image3;
	@FXML private ImageView image4;
	@FXML private ImageView image5;
	@FXML private Label userName;
	
	ToggleGroup group = new ToggleGroup();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		userName.setText(Main.userID + "님, 환영합니다.");
		image1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
		     @Override
		     public void handle(MouseEvent event) {
		 		try {
					Parent parent = FXMLLoader.load(getClass().getResource("../t/test.fxml"));
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
		image2.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
		     @Override
		     public void handle(MouseEvent event) {
		 		try {
					Parent parent = FXMLLoader.load(getClass().getResource("../Main.fxml"));
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
		image3.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
		     @Override
		     public void handle(MouseEvent event) {
		 		try {
					Parent parent = FXMLLoader.load(getClass().getResource("../user/newBook.fxml"));
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
		image4.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
		     @Override
		     public void handle(MouseEvent event) {
		 		try {
					Parent parent = FXMLLoader.load(getClass().getResource("../t/test2.fxml"));
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
		image5.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
		     @Override
		     public void handle(MouseEvent event) {
		 		try {
					Parent parent = FXMLLoader.load(getClass().getResource("../user/Location.fxml"));
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
