package application;

import java.io.IOException;

import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.shape.*;
import javafx.stage.*;

public class ball_control {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	
	
	
	@FXML
	public Label nameLabel;
	public Circle myCircle;
	double x;
	double y;
	
	
	
	public void displayName(String username)//String date)
	{
		 nameLabel.setText("Hello! "+username);
	}
	
	public void exitBallGame(ActionEvent e) throws IOException
	{
		root=FXMLLoader.load(getClass().getResource("welcome_page.fxml"));
		stage=(Stage)((Node)(e.getSource())).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void up(ActionEvent e)
	{
		//System.out.println("UP");
		myCircle.setCenterY(y-=5);
	}
	
	public void down(ActionEvent e)
	{
		//System.out.println("DOWN");
		myCircle.setCenterY(y+=5);
	}
	
	public void left(ActionEvent e)
	{
		//System.out.println("LEFT");
		myCircle.setCenterX(x-=5);
	}
	
	public void right(ActionEvent e)
	{
		//System.out.println("RIGHT");
		myCircle.setCenterX(x+=5);
	}
}
