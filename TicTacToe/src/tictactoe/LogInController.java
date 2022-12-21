package tictactoe;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LogInController implements Initializable {

    @FXML
    private TextField emailField;

    @FXML
    private Button logInButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Text switchSignIn;
    private Parent root;
    private Stage stage;
    private Scene scene;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void LoginButton(ActionEvent event) {

        try {
            if (RequestLogin.checkLoginValidation(emailField.getText(), passwordField.getText()) == true) {
                ServerConnection severConnection = ServerConnection.getInstance("127.0.0.1");
                severConnection.writeDataLogin(emailField.getText(), passwordField.getText());
              

            }

            FXMLLoader loader = new FXMLLoader(getClass().getResource("TwoPlayerBoard.fxml"));
            root = loader.load();
            stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(WinningScreenController.class.getName()).log(Level.SEVERE, null, ex);
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
    public void signUpButton(ActionEvent e) {
        try {
            root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
            stage = (Stage) ((Button) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
