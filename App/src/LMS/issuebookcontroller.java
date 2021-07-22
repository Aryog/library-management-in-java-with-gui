package LMS;

import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.sql.Statement;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

public class issuebookcontroller implements Initializable{
    Connection con;
    PreparedStatement pst;
   Statement stmt;
    ObservableList<issue_ref> list=FXCollections.observableArrayList();

    void connect() throws SQLException
    {
        try {
            System.out.println("hello");
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con=DriverManager.getConnection("jdbc:ucanaccess://src/databases/issuebook.accdb");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    @FXML
    private TextField idt;

    @FXML
    private TextField bo;

    @FXML
    private TextField au;

    @FXML
    private TextField ito;

    @FXML
    private TextField gra;

    @FXML
    private TextField idate;

    @FXML
    private TextField day;

    @FXML
    private Button add;

    @FXML
    private Button update;

    @FXML
    private Button delete;

    @FXML
    private TableView<issue_ref> table;

    @FXML
    private TableColumn<issue_ref, String> book;

    @FXML
    private TableColumn<issue_ref, String> author;

    @FXML
    private TableColumn<issue_ref, String> id2;

    @FXML
    private TableColumn<issue_ref, String> to;

    @FXML
    private TableColumn<issue_ref, String> gands;

    @FXML
    private TableColumn<issue_ref, String> date;

    @FXML
    private TableColumn<issue_ref, String> rdate;

    @FXML
    void ad(ActionEvent event) {
        try {
            connect();
            System.out.println("hello");
            String id1= idt.getText();String author= au.getText();String book= bo.getText();String issuedto= ito.getText();String grad= gra.getText();String issuedate= idate.getText();
            String rdat=day.getText();
            pst = con.prepareStatement("insert into issuebook (Book,Author,STUID,Issuedto,Grade,Issuedate,Returndate) values (?,?,?,?,?,?,?)");
            pst.setString(1, book);
            pst.setString(2, author);
            pst.setString(3, id1);
            pst.setString(4, issuedto);
            pst.setString(5, grad);
            pst.setString(6, issuedate);
            pst.setString(7, rdat);
            int k=pst.executeUpdate();
            if(k==1){System.out.println("added successfully");idt.setText("");au.setText("");bo.setText("");ito.setText("");gra.setText("");idate.setText("");day.setText("");
            pst.close();
            Alert d=new Alert(AlertType.INFORMATION);
        d.setContentText("Added successfully!");
            d.show();
            table.getItems().clear();
            initialize(null, null);
        }}
        catch(Exception e)
        {System.out.println("error adding");}
    }

    @FXML
    void dele(ActionEvent event) throws Exception {
        connect();
        pst=con.prepareStatement("delete from issuebook where STUID=?");
        pst.setString(1, idt.getText());
        int k=pst.executeUpdate();
        if(k==1){idt.setText("");bo.setText("");au.setText("");gra.setText("");ito.setText("");idate.setText("");rdate.setText("");}
        pst.close();
        table.getItems().remove(table.getSelectionModel().getSelectedItem());
        Alert a= new Alert(AlertType.INFORMATION);
        a.setContentText("DELETED SUCCESSFULLY!");
        a.show();

    }

    @FXML
    void upda(ActionEvent event) throws SQLException{
            connect();
            String i=idt.getText();
            String g=gra.getText();
            String a=au.getText();
            String it=ito.getText();
            String b=bo.getText();
            System.out.println(i);
            String idat=idate.getText();
            String r=day.getText();
            pst=con.prepareStatement("update issuebook set Book='"+b+"', Author='"+a+"', STUID='"+i+"', Issuedto='"+it+"', Grade='"+g+"', Issuedate='"+idat+"', Returndate='"+r+"' where STUID=?");
            pst.setString(1, idt.getText());
            int k=pst.executeUpdate();
            if(k==1){idt.setText("");gra.setText("");au.setText("");ito.setText("");bo.setText("");idate.setText("");rdate.setText("");
            pst.close();
            Alert q= new Alert(AlertType.INFORMATION);
            q.setContentText("UPDATED SUCCESSFULLY");
            q.show();
            table.getItems().clear();
            initialize(null, null);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb){
        id2.setCellValueFactory(new PropertyValueFactory<issue_ref , String>("STUID"));
        author.setCellValueFactory(new PropertyValueFactory<issue_ref , String>("Author"));
        book.setCellValueFactory(new PropertyValueFactory<issue_ref , String>("Book"));
        to.setCellValueFactory(new PropertyValueFactory<issue_ref , String>("Issuedto"));
        gands.setCellValueFactory(new PropertyValueFactory<issue_ref , String>("Grade"));
        date.setCellValueFactory(new PropertyValueFactory<issue_ref , String>("Issuedate"));
        rdate.setCellValueFactory(new PropertyValueFactory<issue_ref , String>("Returndate"));
        try {
            connect();
            stmt= con.createStatement();
             ResultSet rs=stmt.executeQuery("select * from issuebook");
            
        while(rs.next())
        {
            list.add(new issue_ref(rs.getString("Book"),
            rs.getString("Author"),
            rs.getString("STUID"),
            rs.getString("Issuedto"),
            rs.getString("Grade"),
            rs.getString("Issuedate"),
            rs.getString("Returndate")
            
            ));
        }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
      table.setItems(list);
    }
    @FXML
    void clk(MouseEvent event) throws Exception{
        if (event.getClickCount()>1)
        {
            clicked();
        }
    }
    public void clicked()
    {
        issue_ref ob=table.getSelectionModel().getSelectedItem();
        idt.setText(ob.getSTUID());
        bo.setText(ob.getBook());
        ito.setText(ob.getIssuedto());
        idate.setText(ob.getIssuedate());
        au.setText(ob.getAuthor());
        gra.setText(ob.getGrade());
        day.setText(ob.getReturndate());
    }

}
