package tictactoe;

import database.Player;
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
import javafx.scene.control.Label;
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SignUpConnection.Connect("127.0.0.1");
        
    }

    @FXML
    private void signUpButton(ActionEvent event) {
        try {
            RequestSignUp requestSignUp=new RequestSignUp(nameField.getText(), emailField.getText(), passwordField.getText()); 
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
}
