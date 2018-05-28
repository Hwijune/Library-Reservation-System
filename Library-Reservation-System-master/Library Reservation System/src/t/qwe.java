package t;
import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class qwe extends Application{

   @Override
   public void start(Stage primaryStage) throws Exception {
      Parent root1 = FXMLLoader.load(getClass().getResource("test.fxml"));
      Scene scene = new Scene(root1);
      primaryStage.setTitle("qwe");
      primaryStage.setScene(scene);
      primaryStage.show();
   }
   public static void main(String[] args) {
      launch(args);
      
   }

   
}