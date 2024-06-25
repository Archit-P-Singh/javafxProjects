package application;

import java.net.URL;
import java.util.ResourceBundle;
import java.io.IOException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.*;

public class selectionPage implements Initializable 
{
	
	@FXML
	public Button exitbutton;
	public Button enterbutton;
	public Button cancelbutton;
	public AnchorPane scenePane;
	public Label offerer;
	public ListView<String> choices;
	public ImageView homeImage;
	
	
	//UIViewwer
	Stage stage;
	Scene scene;
	Parent root;
	Image welcomePage=new Image(getClass().getResourceAsStream("images.jpeg"));
	
	//ChoiceManager
	String currentChoice="";
	String[] choice = 
		{
			"Magnitude Calculator",
			"Unit Vector Finder",
			"Adding Two Vetors",
			"Subtracting Two Vectors",
			"Dot Product Finder",
			"Cross Product Finder"
		};
	
	//id= ExitButton
	public void exiting(ActionEvent e)
	{
		Alert alert=new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Exiting?");
		alert.setHeaderText("You are about to exit the Vector App...");
		alert.setContentText("Are you sure?");
		
		if(alert.showAndWait().get()==ButtonType.OK)
		{
			stage=(Stage)scenePane.getScene().getWindow();
			//System.out.println("You successfully logged out!");
			stage.close();
		}
	}

	//choices in List viewer
	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		choices.getItems().addAll(choice);
		choices.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>()
			{

				@Override
				public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2)
				{
					currentChoice = choices.getSelectionModel().getSelectedItem();
					offerer.setText("Selected: "+currentChoice);
				}
				
			});
		//image settling
		homeImage.setImage(welcomePage);
	}
	
	//id: CancelButton
	public void cancelling(ActionEvent e)throws Exception
	{
		try
		{
			if(currentChoice!="")
			{
				root=FXMLLoader.load(getClass().getResource("selectionPage.fxml"));
				offerer.setText("Select Your Choice");
				currentChoice="";
			}
		}
		catch(Exception ex)
		{
			Alert alert=new Alert(AlertType.ERROR);
			alert.setTitle("Error!");
			alert.setHeaderText("The Application entered into an Error State!");
			alert.setContentText("Inconvenience is deeply regretted...");
			
			if(alert.showAndWait().get()==ButtonType.OK)
			{
				stage=(Stage)scenePane.getScene().getWindow();
				//System.out.println("You successfully logged out!");
				stage.close();
			}
		}
	}
	
	//id:EnterButton
	public void entering(ActionEvent e) throws Exception
	{
		try
		{
			/*if(currentChoice=="")
			{
				offerer.setTextFill(Color.RED);
			}
			else
			{
				offerer.setTextFill(Color.YELLOW);
			}*/
			
			//Magnitude
			if(currentChoice==choice[0])
			{
				FXMLLoader loader= new FXMLLoader(getClass().getResource("magnitudeCal.fxml"));
				root=loader.load();
				
				stage=(Stage)((Node)(e.getSource())).getScene().getWindow();
				scene=new Scene(root);
				
				String css=this.getClass().getResource("Application.css").toExternalForm();
				scene.getStylesheets().add(css);
				
				stage.setScene(scene);
				stage.show();
			}
			
			//Unit
			else if(currentChoice==choice[1])
			{
				FXMLLoader loader= new FXMLLoader(getClass().getResource("unitFind.fxml"));
				root=loader.load();
				
				stage=(Stage)((Node)(e.getSource())).getScene().getWindow();
				scene=new Scene(root);
				
				String css=this.getClass().getResource("Application.css").toExternalForm();
				scene.getStylesheets().add(css);
				
				stage.setScene(scene);
				stage.show();

			}
			
			//Add
			else if(currentChoice==choice[2])
			{
				FXMLLoader loader= new FXMLLoader(getClass().getResource("sumFind.fxml"));
				root=loader.load();
				
				stage=(Stage)((Node)(e.getSource())).getScene().getWindow();
				scene=new Scene(root);
				
				String css=this.getClass().getResource("Application.css").toExternalForm();
				scene.getStylesheets().add(css);
				
				stage.setScene(scene);
				stage.show();

			}
			
			//Sub
			else if(currentChoice==choice[3])
			{
				FXMLLoader loader= new FXMLLoader(getClass().getResource("findDiff.fxml"));
				root=loader.load();
				
				stage=(Stage)((Node)(e.getSource())).getScene().getWindow();
				scene=new Scene(root);
				
				String css=this.getClass().getResource("Application.css").toExternalForm();
				scene.getStylesheets().add(css);
				
				stage.setScene(scene);
				stage.show();

			}
			
			//Dot
			else if(currentChoice==choice[4])
			{
				FXMLLoader loader= new FXMLLoader(getClass().getResource("dotPro.fxml"));
				root=loader.load();
				
				stage=(Stage)((Node)(e.getSource())).getScene().getWindow();
				scene=new Scene(root);
				
				String css=this.getClass().getResource("Application.css").toExternalForm();
				scene.getStylesheets().add(css);
				
				stage.setScene(scene);
				stage.show();

			}
			
			//Cross
			else if(currentChoice==choice[5])
			{
				FXMLLoader loader= new FXMLLoader(getClass().getResource("crossPro.fxml"));
				root=loader.load();
				
				stage=(Stage)((Node)(e.getSource())).getScene().getWindow();
				scene=new Scene(root);
				
				String css=this.getClass().getResource("Application.css").toExternalForm();
				scene.getStylesheets().add(css);
				
				stage.setScene(scene);
				stage.show();

			}
			
			else if(currentChoice=="")
			{
				Text errorText=new Text();
				errorText.setText("Please Select the Choice!");
				errorText.setFill(Color.YELLOW);
				offerer.setText(errorText.getText());
			}
		}
		catch(Exception ex)
		{
			Alert alert=new Alert(AlertType.ERROR);
			alert.setTitle("Error!");
			alert.setHeaderText("The Vector App entered into an Error State!");
			alert.setContentText("Inconvenience is deeply regretted...");
			
			if(alert.showAndWait().get()==ButtonType.OK)
			{
				stage=(Stage)scenePane.getScene().getWindow();
				//System.out.println("You successfully logged out!");
				stage.close();
			}
		}
	}
	
	
}
