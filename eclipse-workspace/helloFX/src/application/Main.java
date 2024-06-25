package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.image.*;


public class Main extends Application 
{
	
	public static void main(String args[])
	{
		launch(args);
	}
	
	public void start(Stage arg0) {
		Stage stage=new Stage();
		Group root=new Group();
		Scene scene=new Scene(root,Color.BLACK);
		
		Image icon=new Image("cal.png");
		stage.getIcons().add(icon);
		
		stage.setTitle("Calculatori...");
		
		stage.setWidth(420);
		stage.setHeight(500);
		stage.setResizable(true);
//		stage.setX(950);
//		stage.setY(55);
//		stage.setFullScreen(true);
//		stage.setFullScreenExitKeyCombination(KeyComination.valueOf("e"));
		
		Text text=new Text();
		text.setText("Hello! I am Calculatori...");
		text.setX(40);
		text.setY(50);
		text.setFont(Font.font("Monotype Corsiva",36));
		text.setFill(Color.LIGHTGOLDENRODYELLOW);
		
		Line line=new Line();
		line.setStartX(30);
		line.setStartY(70);
		line.setEndX(400);
		line.setEndY(70);
		line.setStrokeWidth(5);
		line.setStroke(Color.TOMATO);
		line.setOpacity(0.5);
		
		Image image=new Image("cal.png");
		ImageView imageView=new ImageView(image);
		imageView.setX(100);
		imageView.setY(100);
		
		
		root.getChildren().add(text);
		root.getChildren().add(line);
		root.getChildren().add(imageView);
		
		stage.setScene(scene);
		stage.show();
	}
}
