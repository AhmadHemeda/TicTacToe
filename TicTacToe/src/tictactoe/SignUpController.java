package tictactoe;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.URL;
import java.util.Optional;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SignUpController implements Initializable {

    @FXML
    private Button signUpButton;
    @FXML
    private Text switchLogIn;
    @FXML
    private TextField passwordField;
    @FXML
    private PasswordField passwordFieldConfimation;
    @FXML
    private ImageView backArrow;
    @FXML
    private TextField emailField;
    @FXML
    private TextField nameField;
    private Parent root;
    private Stage stage;
    private Scene scene;
    private Root r;

    private static Socket userSockect;

    private ServerConnection connection;
    @FXML
    private Button backButton;

    String Data;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            //10.178.240.134
            //10.178.240.117
            connection = ServerConnection.getInstance("127.0.0.1");

        } catch (IOException ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void signUpButton(ActionEvent event) throws InterruptedException {

        if (nameField.getText().isEmpty() || emailField.getText().isEmpty() || passwordField.getText().isEmpty() || passwordField.getText().isEmpty() || !passwordField.getText().equals(passwordFieldConfimation.getText())) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setHeaderText("Please enter player name");
            a.setTitle("Pay Attention");
            Optional<ButtonType> result = a.showAndWait();

        } else {

            try {
              
                connection.writeData(nameField.getText(),
                        emailField.getText(),
                        passwordField.getText());
                
               
                root = FXMLLoader.load(getClass().getResource("TwoPlayerBoard.fxml"));
                stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
            }
                        } 
                    } 
               
          
               
           
            

                

      

    

    @FXML
    public void backButton(ActionEvent e) {
        try {
            root = FXMLLoader.load(getClass().getResource("choosingModeScene.fxml"));
            stage = (Stage) ((Button) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void loginButton(ActionEvent e) {
        try {
            root = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
            stage = (Stage) ((Button) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
