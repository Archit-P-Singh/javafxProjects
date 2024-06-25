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

public class unitFind implements Initializable
{
	@FXML
	public Button backbutton,clearbutton;
	public Button enterbutton;
	public Label i,j,k,i1,j1,k1;
	public TextField x,y,z,x1,y1,z1;
	public AnchorPane scenePane;
	public Label offerer,apphead,result;
	public Label warninglabel,headlabel;
	
	Stage stage;
	Scene scene;
	Parent root;
	
	double x_val,y_val,z_val;
	double x1_val,y1_val,z1_val;
	
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
			
			x1_val=x_val;
			y1_val=y_val;
			z1_val=z_val;
			
			x_val=Math.pow(x_val, 2);
			y_val=Math.pow(y_val, 2);
			z_val=Math.pow(z_val, 2);
			
			double magnitude=Math.sqrt(x_val+y_val+z_val);
			
			x1_val=x1_val/magnitude;
			y1_val=y1_val/magnitude;
			z1_val=z1_val/magnitude;
			
			x1.setText(""+x1_val);
			y1.setText(""+y1_val);
			z1.setText(""+z1_val);
			
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
	
	//id= ClearButton
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
			
			x_val=0.0;
			y_val=0.0;
			z_val=0.0;
			x1_val=0.0;
			y1_val=0.0;
			z1_val=0.0;
			
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
		x1.setEditable(false);
		y1.setEditable(false);
		z1.setEditable(false);
	}

}
