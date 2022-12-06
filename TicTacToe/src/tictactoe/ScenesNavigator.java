
package tictactoe;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ScenesNavigator {
    private Stage stage;
    private Scene scene;
    private Parent root;
   
                public void switchToSinglePlayerScene(ActionEvent event){
        try {
            root = FXMLLoader.load(getClass().getResource("SinglePlayerName.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ScenesNavigator.class.getName()).log(Level.SEVERE, null, ex);
        }
                    stage=(Stage)((Button)event.getSource()).getScene().getWindow();
                    scene=new Scene(root);
                    stage.setScene(scene);
                    stage.show();
               
                }
                  public void switchToTwoPlayerScene(ActionEvent event){
        try {
            root = FXMLLoader.load(getClass().getResource("TwoPlayersName.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ScenesNavigator.class.getName()).log(Level.SEVERE, null, ex);
        }
                    stage=(Stage)((Button)event.getSource()).getScene().getWindow();
                    scene=new Scene(root);
                    stage.setScene(scene);
                    stage.show();
               
                }
                   public void backArrow(ActionEvent event){
       try {
            root = FXMLLoader.load(getClass().getResource("choosingModeScene.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ScenesNavigator.class.getName()).log(Level.SEVERE, null, ex);
        }
                    stage=(Stage)((Button)event.getSource()).getScene().getWindow();
                    scene=new Scene(root);
                    stage.setScene(scene);
                    stage.show();
               
                }
                   public void homeButton(ActionEvent event){
                       Alert alert = new Alert(AlertType.CONFIRMATION, "Are you sure you want to back the home page? All records will be deleted");
       try {
            root = FXMLLoader.load(getClass().getResource("choosingModeScene.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ScenesNavigator.class.getName()).log(Level.SEVERE, null, ex);
        }
                    stage=(Stage)((Button)event.getSource()).getScene().getWindow();
                    scene=new Scene(root);
                    stage.setScene(scene);
                    stage.show();
               
                }
            public void NextButtonTwoPlayer(ActionEvent event){
       try {
            root = FXMLLoader.load(getClass().getResource("TwoPlayerBoard.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ScenesNavigator.class.getName()).log(Level.SEVERE, null, ex);
        }
                    stage=(Stage)((Button)event.getSource()).getScene().getWindow();
                    scene=new Scene(root);
                    stage.setScene(scene);
                    stage.show();
               
                } public void NextButtonSinglePlayer(ActionEvent event){
       try {
            root = FXMLLoader.load(getClass().getResource("Defficulty.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ScenesNavigator.class.getName()).log(Level.SEVERE, null, ex);
        }
                    stage=(Stage)((Button)event.getSource()).getScene().getWindow();
                    scene=new Scene(root);
                    stage.setScene(scene);
                    stage.show();
               
                }
                 public void easyButton(ActionEvent event){
       try {
            root = FXMLLoader.load(getClass().getResource("SinglePlayerBoard.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ScenesNavigator.class.getName()).log(Level.SEVERE, null, ex);
        }
                    stage=(Stage)((Button)event.getSource()).getScene().getWindow();
                    scene=new Scene(root);
                    stage.setScene(scene);
                    stage.show();
               
                }
            
                 public void exitButton(ActionEvent event){
       Platform.exit();}
    }
    
      
 

