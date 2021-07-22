package LMS;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

import java.sql.*;

public class categorycontroller implements Initializable{
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    void connect(){
    try {
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");          //calling the database of dbforlogin
        con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/yogesh/Desktop/files/java project/App/src/databases/category.accdb");
        
    } catch (Exception e) {//TODO: handle exception
    }}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<?> table;

    @FXML
    private Button add;

    @FXML
    private Button update;

    @FXML
    private Button delete;

    @FXML
    private Button cancel;

    @FXML
    private TextField bookname;

    @FXML
    private TextField status;

    @FXML
    void add(ActionEvent event) throws SQLException{
        
            connect();
            String str=bookname.getText();
        String stat=status.getText();
        pst = con.prepareStatement("insert into category (catname,status) values (?,?)");
        pst.setString(1, str);
        pst.setString(2, stat);
        int k= pst.executeUpdate();
        if(k==1){System.out.println("record added");bookname.setText("");status.setText("");
        Alert a=new Alert(AlertType.INFORMATION);
        a.setContentText("category added");
        a.show();
    
        }
        
        

    }

    @FXML
    void cancel(ActionEvent event) {

    }

    @FXML
    void delete(ActionEvent event) {

    }

    @FXML
    void update(ActionEvent event) {

    }

    @FXML
    void table(ActionEvent event) throws SQLException{
       


    }


    @FXML
    void initialize() {
        assert add != null : "fx:id=\"add\" was not injected: check your FXML file 'category.fxml'.";
        assert update != null : "fx:id=\"update\" was not injected: check your FXML file 'category.fxml'.";
        assert delete != null : "fx:id=\"delete\" was not injected: check your FXML file 'category.fxml'.";
        assert cancel != null : "fx:id=\"cancel\" was not injected: check your FXML file 'category.fxml'.";
        assert bookname != null : "fx:id=\"bookname\" was not injected: check your FXML file 'category.fxml'.";
        assert status != null : "fx:id=\"status\" was not injected: check your FXML file 'category.fxml'.";

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
    }
}
