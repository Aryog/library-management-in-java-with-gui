package LMS;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;


public class membercontroller implements Initializable{
    Connection con;
    PreparedStatement pst;
    Statement stmt;
    ObservableList<members_ref> list=FXCollections.observableArrayList();

    void connect() throws SQLException
    {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con=DriverManager.getConnection("jdbc:ucanaccess://src/databases/members.accdb");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    @FXML
    private TextField id;

    @FXML
    private TextField name;

    @FXML
    private TextField clas;

    @FXML
    private TextField sec;

    @FXML
    private TextField batch;

    @FXML
    private TextField address;

    @FXML
    private Button btn;

    @FXML
    private Button btn3;

    @FXML
    private Button btn2;

    @FXML
    private TableView<members_ref> table;

    @FXML
    private TableColumn<members_ref, String> id2;

    @FXML
    private TableColumn<members_ref, String> na;

    @FXML
    private TableColumn<members_ref, String> cla;

    @FXML
    private TableColumn<members_ref, String> se;

    @FXML
    private TableColumn<members_ref, String> ba;

    @FXML
    private TableColumn<members_ref, String> ad;


    @FXML
    void add(ActionEvent event) {
        try {
            connect();
            System.out.println("hello");
            String id1= id.getText();String n= name.getText();String c= clas.getText();String s= sec.getText();String b= batch.getText();String a= address.getText();
            pst = con.prepareStatement("insert into members (ID,Name,Grade,Section,Batch,Address) values (?,?,?,?,?,?)");
            pst.setString(1, id1);
            pst.setString(2, n);
            pst.setString(3, c);
            pst.setString(4, s);
            pst.setString(5, b);
            pst.setString(6, a);
            int k=pst.executeUpdate();
            if(k==1){System.out.println("added successfully");id.setText("");name.setText("");clas.setText("");sec.setText("");batch.setText("");address.setText("");
        Alert d=new Alert(AlertType.INFORMATION);
        d.setContentText("Added successfully!");
            d.show();
            table.getItems().clear();
            initialize(null, null);
            
        }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    /*** This is the tableview
          of the database ***/

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        id2.setCellValueFactory(new PropertyValueFactory<members_ref , String>("ID"));
        na.setCellValueFactory(new PropertyValueFactory<members_ref , String>("Name"));
        cla.setCellValueFactory(new PropertyValueFactory<members_ref , String>("Grade"));
        se.setCellValueFactory(new PropertyValueFactory<members_ref , String>("Section"));
        ba.setCellValueFactory(new PropertyValueFactory<members_ref , String>("Batch"));
        ad.setCellValueFactory(new PropertyValueFactory<members_ref , String>("Address"));
        try {
            connect();
            stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("select * from members");
        while(rs.next())
        {
            list.add(new members_ref(rs.getString("ID"),
            rs.getString("Name"),
            rs.getString("Grade"),
            rs.getString("Section"),
            rs.getString("Batch"),
            rs.getString("Address")
            
            ));
        }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
      table.setItems(list);
    }
    
    @FXML
    void row(MouseEvent event) throws Exception{
         if (event.getClickCount()>1)
         {
             clicked();
         }

    }
    public void clicked()
    {
        if(table.getSelectionModel().getSelectedItem()!=null)
        {
            members_ref user=table.getSelectionModel().getSelectedItem();
            id.setText(user.getID());
            name.setText(user.getName());
            clas.setText(user.getGrade());
            sec.setText(user.getSection());
            batch.setText(user.getBatch());
            address.setText(user.getAddress());

        }

    }

    // DELETE FROM THE DATA USING THE 
    //EMPLOYEE ID WHEN THE ROW IS SELECTED

    @FXML
    void del(ActionEvent event) throws SQLException {
        connect();
        pst=con.prepareStatement("delete from members where ID=?");
        pst.setString(1, id.getText());
        int k=pst.executeUpdate();
        if(k==1){id.setText("");name.setText("");clas.setText("");sec.setText("");batch.setText("");address.setText("");}
        pst.close();
        table.getItems().remove(table.getSelectionModel().getSelectedItem());
        Alert a= new Alert(AlertType.INFORMATION);
        a.setContentText("DELETED SUCCESSFULLY!");
        a.show();
        }

    @FXML
    void update(ActionEvent event) throws Exception{
            connect();
            String i=id.getText();
            String n=name.getText();
            String g=clas.getText();
            String s=sec.getText();
            String b=batch.getText();
            String a= address.getText();

            pst=con.prepareStatement("update members set ID='"+i+"', Name='"+n+"', Grade='"+g+"', Section='"+s+"', Batch='"+b+"', Address='"+a+"' where ID=?");
            pst.setString(1, id.getText());
            int k=pst.executeUpdate();
            if(k==1){id.setText("");name.setText("");clas.setText("");sec.setText("");batch.setText("");address.setText("");
            pst.close();
            Alert q= new Alert(AlertType.INFORMATION);
            q.setContentText("UPDATED SUCCESSFULLY");
            q.show();
            table.getItems().clear();
            initialize(null, null);
        }
        }

}
