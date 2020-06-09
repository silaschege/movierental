package movies;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.input.MouseEvent;

 


public class login extends Application{


@Override
public void start(Stage primaryStage) {
Text text1= new Text("User Name:");
Text text2=new Text("Password:");


TextField textfield1 =new TextField();
TextField textfield2 =new TextField();

Button button1= new Button("Login");



GridPane grid=new GridPane();
grid.setAlignment(Pos.CENTER);
grid.setHgap(10);
grid.setVgap(10);
grid.setPadding(new Insets(25,25,25,25));

grid.add(text1,0,1);
grid.add(textfield1,0,2);

grid.add(text2,0,3);
grid.add(textfield2,0,4);
grid.add(button1,0,5);





Scene scene =new Scene (grid,300,300);
primaryStage.setTitle("Movie Library System");
primaryStage.setScene(scene);
primaryStage.show();

}

public static void main(String[] args) {
launch(args);
}

}
