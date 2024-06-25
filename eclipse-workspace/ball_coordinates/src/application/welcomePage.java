package application;

import java.io.IOException;

import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class welcomePage {
	
	@FXML
	public TextField myTextField;
	public AnchorPane scenePane;
	public Button logout;
	public CheckBox myCheckBox;
	public Label warningLabel;
	//public DatePicker dateBox;
	
	 Stage stage;
	 Scene scene;
	 Parent root;
	 
	
	public void logoutDone(ActionEvent e)
	{
		Alert alert=new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Exiting?");
		alert.setHeaderText("You are about Exit...");
		alert.setContentText("Are you sure?");
		
		if(alert.showAndWait().get()==ButtonType.OK)
		{
			stage=(Stage)scenePane.getScene().getWindow();
			//System.out.println("You successfully logged out!");
			stage.close();
		}
	}
	
	public void change(ActionEvent e)
	{
		if(myCheckBox.isSelected())
		{
			warningLabel.setText("");
		}
		else
		{
			warningLabel.setText("Please verify the check box!");
		}
	}

	public void enterBallGame(ActionEvent e) throws IOException
	{
		String username=myTextField.getText();
		
		//LocalDate myDate=dateBox.getValue();
		//System.out.println(myDate.toString());
		//String myFormattedDate=myDate.format(DateTimeFormatter.ofPattern(dd-MM-yyyy));
		//MM->month in numerals
		//MMM->month in three alphabets
		//mm->minutes
		
		try
		{
			if(myCheckBox.isSelected())
			{
				FXMLLoader loader= new FXMLLoader(getClass().getResource("ball.fxml"));
				root=loader.load();
				
				ball_control ballcontroller = loader.getController();
				ballcontroller.displayName(username);//myDate.toString());
			}
			else
			{
				root=FXMLLoader.load(getClass().getResource("welcome_page.fxml"));
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error");
		}
		
		stage=(Stage)((Node)(e.getSource())).getScene().getWindow();
		scene=new Scene(root);
		
		String css=this.getClass().getResource("Application.css").toExternalForm();
		scene.getStylesheets().add(css);
		
		stage.setScene(scene);
		stage.show();

	}
	
}
