package LMS;
import javafx.application.Application;
import javafx.fxml.*;
import javafx.scene.Parent;
// import javafx.scene.Parent;
import javafx.scene.Scene;
// import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class App extends Application{
    public static void main(String[] args) throws Exception{
      Application.launch(args);  
    }

    @Override
    public void start(Stage Stage) throws Exception {
      //FXMLLoader fxml= new FXMLLoader();
      Parent root= FXMLLoader.load(getClass().getResource("fxmls/panel.fxml"));
     Stage.setScene(new Scene(root));
     Stage.setTitle("USER LOGIN");
     Stage.show();
        
    
    }

}