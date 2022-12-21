package tictactoe;

import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

    private static Socket userSockect;

    private ServerConnection connection;
    @FXML
    private Button backButton;

    private CallBackServerSocket callback;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {

            connection = ServerConnection.getInstance("127.0.0.1");

        } catch (IOException ex) {
           
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("No Connnection");
            alert.setTitle("Pay Attention");
            Optional<ButtonType> result = alert.showAndWait();
            
            if(result.get()==ButtonType.OK){
               
                    connection.close();
                   
                     
               
            
            
            }
        }

    }

    @FXML
    private void signUpButton(ActionEvent event) {

        final String passwordRegex = "[0-9]+";

        if (nameField.getText().isEmpty() || emailField.getText().isEmpty() || passwordField.getText().isEmpty() || passwordFieldConfimation.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Please enter all fields for succesful registeration");
            alert.setTitle("Pay Attention");
            Optional<ButtonType> result = alert.showAndWait();
            if(result.get()==ButtonType.OK){
                try {
                    root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }

        } else if (!isNameValid(nameField.getText())) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Name should be only letters");
            alert.setTitle("Pay Attention");
            Optional<ButtonType> result = alert.showAndWait();
            if(result.get()==ButtonType.OK){
                try {
                    root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
        } else if (passwordField.getText().matches(passwordRegex)) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Password should not contain only numerics");
            alert.setTitle("Pay Attention");
            Optional<ButtonType> result = alert.showAndWait();
            if(result.get()==ButtonType.OK){
                try {
                    root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
        } else if (passwordField.getText().length() < 8) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Passsword should contain at least 8 alphanumeric characters");
            alert.setTitle("Pay Attention");
            Optional<ButtonType> result = alert.showAndWait();
            if(result.get()==ButtonType.OK){
                try {
                    root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }

        } else if (!passwordField.getText().equals(passwordFieldConfimation.getText())) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Password confirmation does not match");
            alert.setTitle("Pay Attention");
            Optional<ButtonType> result = alert.showAndWait();
            if(result.get()==ButtonType.OK){
                try {
                    root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
        } else if (!isEmailValid(emailField.getText())) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Invalid email!");
            alert.setTitle("Pay Attention");
            Optional<ButtonType> result = alert.showAndWait();
            if(result.get()==ButtonType.OK){
                try {
                    root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }

        } else if (nameField.getText().contains(",") || emailField.getText().contains(",") || passwordField.getText().contains(",")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Invalid comma usage");
            alert.setTitle("Pay Attention");
            Optional<ButtonType> result = alert.showAndWait();
            if(result.get()==ButtonType.OK){
                try {
                    root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
        } else {

            connection.writeData(nameField.getText(),
                    emailField.getText(),
                    passwordField.getText());
            try {
                
                root = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
            } catch (IOException ex) {
                Logger.getLogger(ServerConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
            stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

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

    public boolean isEmailValid(String email) {

        String emailRegex = "^[A-Z0-9]+@[A-Z0-9]+\\.[A-Z]{2,6}$";
        Pattern emailPattern = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher emailMatches = emailPattern.matcher(email);

        return emailMatches.find();
    }

    public boolean isNameValid(String name) {

        String nameRegex = "^[A-Z]{3,20}$";
        Pattern namePattern = Pattern.compile(nameRegex, Pattern.CASE_INSENSITIVE);
        Matcher nameMatches = namePattern.matcher(name);

        return nameMatches.find();
    }
}
