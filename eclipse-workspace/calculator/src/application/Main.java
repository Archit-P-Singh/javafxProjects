package application;
	
import javafx.application.Application;
import javafx.fxml.*;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage stage) {
		try {
			Parent root =FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene scene = new Scene(root);
			
			Image icon=new Image("cal.png");
			stage.getIcons().add(icon);
			
			stage.setTitle("Calculator");
			
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
