package application;
	
import java.io.IOException;
import java.util.Vector;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import library.DbConnection;

public class Main extends Application {
	
	public static String userID = "";
	
	AnchorPane pane1 = new AnchorPane();
	public DbConnection dc;
	
	
	public static Stage rootStage;
	
	Stage newStage;
	static Vector<String> rsnum = new Vector<String>();
	static Vector<Button> table = new Vector<Button>();
	
	public void maketable()
	{
		pane1.setMinSize(650, 600);
		
		Label tablela = new Label("자리를 선택해주세요.");
		tablela.setLayoutX(300);
		tablela.setLayoutY(30);
		tablela.setVisible(true);
		tablela.opacityProperty();
		tablela.setPrefWidth(200);
		tablela.setFont(new Font(20));
		pane1.getChildren().add(tablela);
		
		Label usetable = new Label();
		usetable.setLayoutX(550);
		usetable.setLayoutY(20);
		usetable.setVisible(true);
		usetable.opacityProperty();
		usetable.setPrefWidth(42);
		usetable.setPrefHeight(38);
		usetable.setStyle("-fx-background-color:#FF0000;");
		pane1.getChildren().add(usetable);
		
		Label tableex = new Label("사용중");
		tableex.setLayoutX(600);
		tableex.setLayoutY(27);
		tableex.setVisible(true);
		tableex.opacityProperty();
		tableex.setPrefWidth(200);
		tableex.setFont(new Font(15));
		pane1.getChildren().add(tableex);
		
		int xdis = 0;
		int xxdis = 0;
		int ydis = 0;
		for (int a = 0; a < 100; a++)
		{
			if (a % 10 == 0 && a != 0)
			{
				xxdis += 42;
				ydis = 0;
			}
			if (a % 20 == 0)
			{
				xdis += 50;
			}
			Button chair = new Button();
			chair.setText(a + 1 + "");
			chair.setLayoutX(20 + xdis + xxdis);
			chair.setLayoutY(85 + 40 * ydis);
			chair.setPrefWidth(42);
			chair.setPrefHeight(38);
			ydis++;
			chair.setVisible(true);
			chair.opacityProperty();
			pane1.getChildren().add(chair);
			
			chair.setOnMouseClicked((event) ->
			{
				try
				{
					rsnum.add(chair.getText());
					Parent load = FXMLLoader.load(getClass().getResource("/Use2.fxml"));
					Scene show = new Scene(load);
					newStage = new Stage();
					newStage.setTitle("이용시간");
					newStage.setScene(show);
					newStage.show();
					System.out.println(rsnum.get(rsnum.size() - 1));
				} catch (IOException e)
				{
					
				}
			});
			table.add(chair);
		}
		xdis = 30;
		xxdis = 0;
		ydis = 0;
		// 하단 배열
		for (int i = 0; i < 30; i++)
		{
			if (i == 15)
			{
				ydis = 0;
				xdis += 40;
				
			}
			Button chair = new Button();
			chair.setText(i + 1 + "");
			chair.setLayoutX(50 + 44 * ydis);
			chair.setLayoutY(460 + xdis);
			chair.setPrefWidth(42);
			chair.setPrefHeight(38);
			ydis++;
			chair.setVisible(true);
			chair.opacityProperty();
			pane1.getChildren().add(chair);
			chair.setOnMouseClicked((event) ->
			{
				try
				{
					rsnum.add(chair.getText());
					Parent load = FXMLLoader.load(getClass().getResource("/Use2.fxml"));
					Scene show = new Scene(load);
					newStage = new Stage();
					newStage.setTitle("이용시간");
					newStage.setScene(show);
					newStage.show();
					System.out.println(rsnum.get(rsnum.size() - 1));
				} catch (IOException e)
				{
					
				}
			});
			table.add(chair);
		}
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../user/UserLogin.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.initStyle(StageStyle.UNDECORATED);
			primaryStage.show();
			rootStage = primaryStage;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
