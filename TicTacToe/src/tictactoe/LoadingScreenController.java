
package tictactoe;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoadingScreenController implements Initializable {

    @FXML
    private AnchorPane LoadingScreenPane;
    
  
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        new LoadingScreen().start();
    }    
    class LoadingScreen extends Thread{
        public void run(){
        
            try {
                Thread.sleep(3000);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                      Parent root=null;
                        try {
                            root = FXMLLoader.load(getClass().getResource("choosingModeScene.fxml"));
                        } catch (IOException ex) {
                            Logger.getLogger(LoadingScreenController.class.getName()).log(Level.SEVERE, null, ex);
                        }

                Scene scene = new Scene(root);
                Stage stage=new Stage();
                stage.setScene(scene);
                stage.show();
                
                LoadingScreenPane.getScene().getWindow().hide();
                    }
                });
               
            } catch (InterruptedException ex) {
                Logger.getLogger(LoadingScreenController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    
    
    }
}
