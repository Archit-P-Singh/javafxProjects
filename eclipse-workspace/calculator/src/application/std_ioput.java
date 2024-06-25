package application;

import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;

public class std_ioput
{
	
	@FXML
	private TextField myTextField;
	String op="";
	double number1;
	double number2;
	boolean start=true;
	
	public void number(ActionEvent e)
	{
		if(start)
		{
			myTextField.setText("");
			start=false;
		}
		String num=((Button)e.getSource()).getText();
		myTextField.setText(myTextField.getText()+num);
		
	}
	
	public void operator(ActionEvent e)
	{
		String operation=((Button)e.getSource()).getText();
		if(!operation.equals("="))
		{
			if(!op.equals(""))
			{
				return;
			}
			op=operation;
			number1=Long.parseLong(myTextField.getText());
			myTextField.setText("");
		}
		else
		{
			if(op.isEmpty())
			{
				return;
			}
			number2=Long.parseLong(myTextField.getText());
			calculate(number1,number2,op);
			start=true;
			op="";
		}
	}
	
	public void calculate(double n1,double n2,String op)
	{
		switch(op)
		{
			case "+":myTextField.setText(n1+n2+"");
			break;
			case "-":myTextField.setText(n1-n2+"");
			break;
			case "*":myTextField.setText(n1*n2+"");
			break;
			case "/":if(n2==0)
						myTextField.setText("Math Error");
					 else
						myTextField.setText(n1/n2+"");
			break;
			default:myTextField.setText("");
		}
	}
}
