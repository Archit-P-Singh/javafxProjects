package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.*;
import javafx.scene.control.ButtonType;


public class Main extends Application 
{
	
	@Override
	public void start(Stage stage) 
	{
		try 
		{
			Parent root = FXMLLoader.load(getClass().getResource("welcome_page.fxml"));
			Scene scene = new Scene(root);
			
			String css=this.getClass().getResource("Application.css").toExternalForm();
			scene.getStylesheets().add(css);
			
			
			stage.setOnCloseRequest(event->
			{
				event.consume();
				logoutDone(stage);
			});
			stage.setTitle("Ball Locator");
			stage.setScene(scene);
			stage.show();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public void logoutDone(Stage stage)
	{
		Alert alert=new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Exiting?");
		alert.setHeaderText("You are about Exit...");
		alert.setContentText("Are you sure?");
		
		if(alert.showAndWait().get()==ButtonType.OK)
		{
			//stage=(Stage)scenePane.getScene().getWindow();
			//System.out.println("You successfully logged out!");
			stage.close();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
