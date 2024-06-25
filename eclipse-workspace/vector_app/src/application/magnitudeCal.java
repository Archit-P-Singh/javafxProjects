package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class magnitudeCal implements Initializable
{
	@FXML
	public Button backbutton,clearbutton;
	public Button enterbutton;
	public Label i,j,k;
	public TextField x,y,z,res;
	public AnchorPane scenePane;
	public Label offerer,apphead,result;
	public Label warninglabel,headlabel;
	
	Stage stage;
	Scene scene;
	Parent root;
	
	double x_val,y_val,z_val;
	double res_val;
	
	//id= EnterButton
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
			
			x_val=Math.pow(x_val, 2);
			y_val=Math.pow(y_val, 2);
			z_val=Math.pow(z_val, 2);
			res_val=Math.sqrt(x_val+y_val+z_val);
			
			res.setText(""+res_val);
			
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
			res.setText("");
			
			x_val=0.0;
			y_val=0.0;
			z_val=0.0;
			res_val=0.0;
			
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
		res.setEditable(false);
	}
}
