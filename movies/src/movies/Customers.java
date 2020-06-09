package movies;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import java.sql.ResultSet;


public class Customers extends Application{
    public void start(Stage primaryStage) {
       Text text1= new Text("Name:");
       Text text2=new Text("Phone:");
       Text text3=new Text ("Email;");
        Text text4=new Text ("Registred:");
     
      
        ComboBox combobox4=new ComboBox();
        TextField textfield1 =new TextField();
        TextField textfield2 =new TextField();
        TextField textfield3 =new TextField();
        
        Button button3= new Button("Save Customer");
        Button button4=new Button("Remove Customer");
        
        
        
       GridPane grid=new GridPane();
       grid.setAlignment(Pos.CENTER);
       grid.setHgap(10);
       grid.setVgap(10);
       grid.setPadding(new Insets(25,25,25,25));
       
       grid.add(text1,0,1);
       grid.add(textfield1,0,2);
       
       grid.add(text2,0,3);
       grid.add(textfield2,0,4);
     
       
       grid.add(text3,0,6);
       grid.add(textfield3,0,7);
       grid.add(button3,0,8);
       
       grid.add(text4,0,9);
       grid.add(combobox4,0,10);
       grid.add(button4,0,11);
   
       
   
       try{
    	   Connection con =DriverManager.getConnection("jdbc:mysql://localhost:8889/movies?useSSL=false","root","root");
    	   Statement st=con.createStatement();

    	   String statement = "SELECT * FROM Client";
    	   ResultSet resultSet = st.executeQuery(statement);


    	   while (resultSet.next()) { // loop
    	       combobox4.getItems().addAll(resultSet.getString("Email"));
    	   }
    	   }
    	   catch(Exception ee){System.out.println(ee);text4.setText("Something is wrong");}
  
       button3.setOnMouseClicked((new EventHandler<MouseEvent>() {
       public void handle(MouseEvent event) {
       try{
       final String name=textfield1.getText();
       final String phone=textfield2.getText();
       final String email=textfield3.getText();
       Class.forName("com.mysql.jdbc.Driver");
      Connection con =DriverManager.getConnection("jdbc:mysql://localhost:8889/movies?useSSL=false","root","root");
       Statement st=con.createStatement();
       //ResultSet rs=st.executeQuery("select name from names");
      String sts = "INSERT INTO Client(Fullname, Phone, Email) VALUES ('"+name+"','"+phone+"','"+email+"')";
      st.executeUpdate(sts);
      text4.setText("Successfully inserted");
      }
      catch(ClassNotFoundException | SQLException ee){System.out.println(ee);text4.setText("Not Inserted");}

    }
    }));
       
       button4.setOnMouseClicked((new EventHandler<MouseEvent>() {
       public void handle(MouseEvent event) {
       try{
       final String email=combobox4.getPromptText();
       Class.forName("com.mysql.jdbc.Driver");
      Connection con =DriverManager.getConnection("jdbc:mysql://localhost:8889/movies?useSSL=false","root","root");
       Statement st=con.createStatement();
       //ResultSet rs=st.executeQuery("select name from names");
      String sts = "DELETE FROM Client WHERE Email='"+email+"'";
      st.executeUpdate(sts);
      text4.setText("Successfully DELETED");
      }
      catch(ClassNotFoundException | SQLException ee){System.out.println(ee);text4.setText("Not DELETED");}

    }
    }));
              
       Scene scene =new Scene (grid,350,350);
       primaryStage.setTitle("Movie Library System");
       primaryStage.setScene(scene);
       primaryStage.show();
         
    } 

   
       public static void main(String[] args) {
        launch(args);
    }
}

