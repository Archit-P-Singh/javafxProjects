package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.fxml.*;
import javafx.scene.image.*;
import javafx.scene.*;


public class Main extends Application 
{
	@Override
	public void start(Stage stage) 
	{
		try 
		{
			Parent root = FXMLLoader.load(getClass().getResource("selectionPage.fxml"));
			Scene scene = new Scene(root);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			stage.setOnCloseRequest(event->
			{
				event.consume();
				logoutDone(stage);
			});
			
			stage.setTitle("Vector App");
			stage.setScene(scene);
			stage.setResizable(false);
			stage.setFullScreen(false);
			stage.show();
			
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
	
	public void logoutDone(Stage stage) 
	{
		Alert alert=new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Exiting?");
		alert.setHeaderText("You are about to exit the Vector App...");
		alert.setContentText("Are you sure?");
		
		if(alert.showAndWait().get()==ButtonType.OK)
		{
			//stage=(Stage)scenePane.getScene().getWindow();
			//System.out.println("You successfully logged out!");
			stage.close();
		}
	}
}
