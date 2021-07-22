package LMS;
import java.io.IOException;
import java.sql.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
// import javafx.fxml.FXMLLoader;
// import javafx.scene.Parent;
// import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
// import javafx.scene.layout.AnchorPane;
// import javafx.stage.Stage;
import javafx.stage.Stage;


public class login implements Initializable{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button btn;

    @FXML
   void log(ActionEvent event) throws IOException,SQLException {
        String user= username.getText();
        String pass= password.getText();
        int counter=0;
        System.out.println(user+" "+pass);
        Alert a=new Alert(AlertType.INFORMATION);
        if(user.isEmpty() || pass.isEmpty())
        {
            a.setContentText("The user and password field should not be blank");
            a.show();
        }
        else{
            try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");          //calling the database of dbforlogin
                Connection con = DriverManager.getConnection("jdbc:ucanaccess://src/databases/dbforlogin.accdb");
                Statement stmt = con.createStatement();
                ResultSet rs =stmt.executeQuery("select * from login");
                while(rs.next())
                {
                    String u= rs.getString("username");
                    String p= rs.getString("password");
                    if(user.equals(u) && pass.equals(p))
                { 
                    
                    Parent root= FXMLLoader.load(getClass().getResource("fxmls/main.fxml"));
                    Scene sc=new Scene(root);
                    Stage st =new Stage();
                    st.setScene(sc);
                    st.setTitle("Administrator Panel");
                    st.show();
                    ++counter;
                }
                

            }if(counter!=1){Alert b= new Alert(AlertType.INFORMATION);
                b.setContentText("Invaild username and password");
                b.show();}
            
                

            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
       
            }
    }

    @FXML
    void initialize() {
        // assert username != null : "fx:id=\"username\" was not injected: check your FXML file 'panel.fxml'.";
        // assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'panel.fxml'.";
        // assert btn != null : "fx:id=\"btn\" was not injected: check your FXML file 'panel.fxml'.";

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        
    }
}
