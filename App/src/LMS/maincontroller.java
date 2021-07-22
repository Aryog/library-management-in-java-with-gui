package LMS;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class maincontroller implements Initializable{

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    void issuebook(ActionEvent event) throws Exception {
        Parent root =FXMLLoader.load(getClass().getResource("fxmls/issuebook.fxml"));
        Scene sc=new Scene(root);
        Stage st=new Stage();
        st.setScene(sc);
        st.setMaximized(true);
        st.setTitle("Issue Book");
        st.show();


    }

    @FXML
    void members(ActionEvent event) throws Exception {
        Parent root =FXMLLoader.load(getClass().getResource("fxmls/members.fxml"));
        Scene sc=new Scene(root);
        Stage st=new Stage();
        st.setScene(sc);
        st.setMaximized(true);
        st.setTitle("Members");
        st.show();

    }

    @FXML
    void returnbook(ActionEvent event) throws Exception {
        Parent root =FXMLLoader.load(getClass().getResource("fxmls/returnbook.fxml"));
        Scene sc=new Scene(root);
        Stage st=new Stage();
        st.setScene(sc);
        st.setTitle("Return Book");
        st.show();


    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        
    }

}