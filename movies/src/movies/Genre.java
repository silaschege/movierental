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




public class Genre extends Application{
    
        
    @Override
    public void start(Stage primaryStage) {
       Text text1= new Text("Genres:");
       Text text2=new Text("Registerd:");
    
      
       TextField textfield1 =new TextField();
       TextField textfield2 =new TextField();
        
        Button button1= new Button("Save");
        Button button2=new Button("Remove");
        
        
        
       GridPane grid=new GridPane();
       grid.setAlignment(Pos.CENTER);
       grid.setHgap(10);
       grid.setVgap(10);
       grid.setPadding(new Insets(25,25,25,25));
       
       grid.add(text1,0,1);
       grid.add(textfield1,0,2);
       grid.add(button1,0,3);
       
       grid.add(text2,0,4);
       grid.add(textfield2,0,5);
       grid.add(button2,0,6);
       
       button1.setOnMouseClicked((new EventHandler<MouseEvent>() {
       public void handle(MouseEvent event) {
       try{
       final String genre=textfield1.getText();
       Class.forName("com.mysql.jdbc.Driver");
      Connection con =DriverManager.getConnection("jdbc:mysql://localhost:8889/movies?useSSL=false","root","root");
       Statement st=con.createStatement();
       //ResultSet rs=st.executeQuery("select name from names");
      String sql = "INSERT INTO `Genres`(`genre`) VALUES ('"+genre+"')";
      st.executeUpdate(sql);
      text2.setText("Successfully inserted");
      }
      catch(ClassNotFoundException | SQLException ee){System.out.println(ee);text2.setText("Not Inserted");}

    }
    }));
  //?autoReconnect=true&useSSL=false

     primaryStage.setTitle("Save Movie Genre");
       
       
        button2.setOnMouseClicked((new EventHandler<MouseEvent>() {
       public void handle(MouseEvent event) {
       try{
       final String genre = textfield2.getText();
       Class.forName("com.mysql.jdbc.Driver");
      Connection con =DriverManager.getConnection("jdbc:mysql://localhost:8889/movies?useSSL=false","root","root");
       Statement st=con.createStatement();
       //ResultSet rs=st.executeQuery("select name from names");
      String sts = "DELETE FROM Genres WHERE genre='"+genre+"'";
      st.executeUpdate(sts);
      text2.setText("Successfully Deleted");
      }
      catch(Exception ee){System.out.println(ee);text2.setText("Not Deleted");}

    }
    }));

       
      
     primaryStage.setTitle("Delete Movie Genre");
       
       
              
       Scene scene =new Scene (grid,300,300);
       primaryStage.setTitle("Movie Library System");
       primaryStage.setScene(scene);
       primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
