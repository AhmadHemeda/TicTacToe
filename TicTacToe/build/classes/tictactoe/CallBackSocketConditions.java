package tictactoe;

import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class CallBackSocketConditions {

    private Parent root;
    private Stage stage;
    private Scene scene;

    public CallBackSocketConditions() {
    }

    public void registerSuccess() {

        System.out.println("success");

    }

    public void registerNotSuccess() {

        
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setHeaderText("This mail already registered before");
            a.setTitle("Invalid Email!");
            Optional<ButtonType> result = a.showAndWait();
            
    }
    
     public void loginNotFound() {

        
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setHeaderText("Please Sign Up");
            a.setTitle("Sign Up!");
            Optional<ButtonType> result = a.showAndWait();
            

        
    }
     public void loginFound() {
         System.out.println("login Success");
        }
     
     
    }

