package movies;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;


public class Movies extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       Text text1= new Text("Genres:");
       Text text2=new Text("Name:");
       Text text3=new Text ("Register:");
               
        ComboBox combobox1=new ComboBox();
        ComboBox combobox3=new ComboBox();
     
        TextField textfield2 =new TextField();
        
        Button button2= new Button("Save Movie");
        Button button3=new Button("Remove Movies");
        
        
        
       GridPane grid=new GridPane();
       grid.setAlignment(Pos.CENTER);
       grid.setHgap(10);
       grid.setVgap(10);
       grid.setPadding(new Insets(25,25,25,25));
       
       grid.add(text1,0,1);
       grid.add(combobox1,0,2);
       
       grid.add(text2,0,3);
       grid.add(textfield2,0,4);
       grid.add(button2,0,5);
       
       grid.add(text3,0,6);
       grid.add(combobox3,0,7);
       grid.add(button3,0,8);
       
       

      
       
       try{
    	   Connection con =DriverManager.getConnection("jdbc:mysql://localhost:8889/movies?useSSL=false","root","root");
    	   Statement st=con.createStatement();

    	   String statement = "SELECT * FROM Genres";
    	   ResultSet resultSet = st.executeQuery(statement);


    	   while (resultSet.next()) { // loop
    	       combobox1.getItems().addAll(resultSet.getString("id"));
    	   }
    	   }
    	   catch(Exception ee){System.out.println(ee);text1.setText("Something is wrong");}
       

      
       try{
    	   Connection con =DriverManager.getConnection("jdbc:mysql://localhost:8889/movies?useSSL=false","root","root");
    	   Statement st=con.createStatement();

    	   String statement = "SELECT * FROM Movies";
    	   ResultSet resultSet = st.executeQuery(statement);


    	   while (resultSet.next()) { // loop
    	       combobox3.getItems().addAll(resultSet.getString("Title"));
    	   }
    	   }
    	   catch(Exception ee){System.out.println(ee);text3.setText("Something is wrong");}
       
       
       
       button2.setOnMouseClicked((new EventHandler<MouseEvent>() {
       public void handle(MouseEvent event) {
       try{
       final String name=textfield2.getText();
       final Parent combo=combobox1.getParent();
       Class.forName("com.mysql.jdbc.Driver");
      Connection con =DriverManager.getConnection("jdbc:mysql://localhost:8889/movies?useSSL=false","root","root");
       Statement st=con.createStatement();
       //ResultSet rs=st.executeQuery("select name from names");
       String sql = "INSERT INTO Movies(genre_id,Title) VALUES ('"+combo+"','"+name+"')";
       //String sql = "INSERT INTO `Movies`(`genre_id`,`Title`) VALUES ("+"'"+combo+"'"+","+"'"+name+"'"+")";
      st.executeUpdate(sql);
      text3.setText("Successfully inserted");
      }
      catch(ClassNotFoundException | SQLException ee){System.out.println(ee);text3.setText("Not Inserted");}

    }
    }));
  
       button3.setOnMouseClicked((new EventHandler<MouseEvent>() {
       public void handle(MouseEvent event) {
       try{
       final Object title=(int) combobox3.getValue();
       Class.forName("com.mysql.jdbc.Driver");
      Connection con =DriverManager.getConnection("jdbc:mysql://localhost:8889/movies?useSSL=false","root","root");
       Statement st=con.createStatement();
       //ResultSet rs=st.executeQuery("select name from names");
      String sql = "DELETE FROM Movies WHERE Title='"+title+"'";
      st.executeUpdate(sql);
      text3.setText("Successfully inserted");
      }
      catch(ClassNotFoundException | SQLException ee){System.out.println(ee);text3.setText("Not Inserted");}

    }
    }));

     primaryStage.setTitle("Save Movie Genre");
       
              
       Scene scene =new Scene (grid,300,300);
       primaryStage.setTitle("Movie Library System");
       primaryStage.setScene(scene);
       primaryStage.show();
          
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}

