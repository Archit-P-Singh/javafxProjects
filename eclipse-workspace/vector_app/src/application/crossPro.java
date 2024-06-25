package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.*;

public class crossPro implements Initializable
{
	
	@FXML
	public Button backbutton;
	public Button enterbutton;
	public Button clearbutton;
	public AnchorPane scenePane;
	public TextField x,y,z;
	public TextField x1,y1,z1;
	public TextField x2,y2,z2;
	public Label warninglabel;
	
	Stage stage;
	Scene scene;
	Parent root;
	
	double x_val,y_val,z_val;
	double x1_val,y1_val,z1_val;
	double x2_val,y2_val,z2_val;
	
	public void entering(ActionEvent e)
	{
		try
		{
			warninglabel.setText("");
			
			
			
			if(x.getText()=="") 
				x_val=0.0;
			else
				x_val=Double.parseDouble(x.getText());
			
			if(y.getText()=="") 
				y_val=0.0;
			else
				y_val=Double.parseDouble(y.getText());
			
			if(z.getText()=="") 
				z_val=0.0;
			else
				z_val=Double.parseDouble(z.getText());
			
			if(x1.getText()=="") 
				x1_val=0.0;
			else
				x1_val=Double.parseDouble(x1.getText());
			
			if(y1.getText()=="") 
				y1_val=0.0;
			else
				y1_val=Double.parseDouble(y1.getText());
			
			if(z1.getText()=="") 
				z1_val=0.0;
			else
				z1_val=Double.parseDouble(z1.getText());
			
			x2_val=((y_val*z1_val)-(z_val*y1_val));
			y2_val=((x_val*z1_val)-(z_val*x1_val))*(-1);
			z2_val=((x_val*y1_val)-(y_val*x1_val));
			
			x2.setText(""+x2_val);
			y2.setText(""+y2_val);
			z2.setText(""+z2_val);
			
		}
		catch(NumberFormatException ex)
		{
			warninglabel.setTextFill(Color.RED);
			warninglabel.setText("Please Enter only Numbers!");
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
	
	public void reseting(ActionEvent e)throws Exception
	{
		try
		{
			x.setText("");
			y.setText("");
			z.setText("");
			x1.setText("");
			y1.setText("");
			z1.setText("");
			x2.setText("");
			y2.setText("");
			z2.setText("");
			
			x_val=0.0;
			y_val=0.0;
			z_val=0.0;
			x1_val=0.0;
			y1_val=0.0;
			z1_val=0.0;
			x2_val=0.0;
			y2_val=0.0;
			z2_val=0.0;
			
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
	
	//id= ExitButton
	public void returning(ActionEvent e)
	{
		try
		{
			FXMLLoader loader= new FXMLLoader(getClass().getResource("selectionPage.fxml"));
			root=loader.load();
			
			stage=(Stage)((Node)(e.getSource())).getScene().getWindow();
			scene=new Scene(root);
			
			String css=this.getClass().getResource("Application.css").toExternalForm();
			scene.getStylesheets().add(css);
			
			stage.setScene(scene);
			stage.show();
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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		// TODO Auto-generated method stub
		x2.setEditable(false);
		y2.setEditable(false);
		z2.setEditable(false);
	}
	
}
