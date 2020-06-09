package movies;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;


public class Rentals extends Application{
    
    public void start(Stage primaryStage) {
       Text text1= new Text("Customer:");
       Text text2=new Text("Genre:");
       Text text3=new Text ("Movies:");
       Text text4=new Text ("Borrowed:");
       Text text5=new Text ("Returned:");  
       
        ComboBox combobox1=new ComboBox();
        ComboBox combobox2=new ComboBox();
        ComboBox combobox3=new ComboBox();
        ComboBox combobox4=new ComboBox();
        ComboBox combobox5=new ComboBox();
     
   
        
        Button button3= new Button("Save Rental");
        Button button4=new Button("Return Movie");
        
        
        
       GridPane grid=new GridPane();
       grid.setAlignment(Pos.CENTER);
       grid.setHgap(10);
       grid.setVgap(10);
       grid.setPadding(new Insets(25,25,25,25));
       
       grid.add(text1,0,1);
       grid.add(combobox1,0,2);
       
       grid.add(text2,0,3);
       grid.add(combobox2,0,4);
       
       
       grid.add(text3,0,5);
       grid.add(combobox3,0,6);
       grid.add(button3,0,7);
       
       grid.add(text4,0,8);
       grid.add(combobox4,0,9);
       grid.add(button4,0,10);
       
       grid.add(text5,0,11);
       grid.add(combobox5,0,12);
       
       
       try{
    	   Connection con =DriverManager.getConnection("jdbc:mysql://localhost:8889/movies?useSSL=false","root","root");
    	   Statement st=con.createStatement();

    	   String statement = "SELECT * FROM Client";
    	   ResultSet resultSet = st.executeQuery(statement);


    	   while (resultSet.next()) { // loop
    	       combobox1.getItems().addAll(resultSet.getString("Email"));
    	   }
    	   }
    	   catch(Exception ee){System.out.println(ee);text4.setText("Something is wrong");}
              
       
       try{
    	   Connection con =DriverManager.getConnection("jdbc:mysql://localhost:8889/movies?useSSL=false","root","root");
    	   Statement st=con.createStatement();

    	   String statement = "SELECT * FROM Genres";
    	   ResultSet resultSet = st.executeQuery(statement);


    	   while (resultSet.next()) { // loop
    	       combobox2.getItems().addAll(resultSet.getString("genre"));
    	   }
    	   }
    	   catch(Exception ee){System.out.println(ee);text4.setText("Something is wrong");}
       
       
       try{
    	   Connection con =DriverManager.getConnection("jdbc:mysql://localhost:8889/movies?useSSL=false","root","root");
    	   Statement st=con.createStatement();

    	   String statement = "SELECT * FROM Movies";
    	   ResultSet resultSet = st.executeQuery(statement);


    	   while (resultSet.next()) { // loop
    	       combobox3.getItems().addAll(resultSet.getString("Title"));
    	   }
    	   }
    	   catch(Exception ee){System.out.println(ee);text4.setText("Something is wrong");}
              
              
       
       
           Scene scene =new Scene (grid,400,400);
       primaryStage.setTitle("Movie Library System");
       primaryStage.setScene(scene);
       primaryStage.show();
          
    }

    public static void main(String[] args) {
        launch(args);
    }
}

