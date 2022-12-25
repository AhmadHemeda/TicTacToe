package tictactoe;

import java.io.IOException;
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
    private ServerConnection connection;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            connection = ServerConnection.getInstance("127.0.0.1");
        } catch (IOException ex) {
            Logger.getLogger(LogInController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void LoginButton(ActionEvent event) {

        if (emailField.getText().isEmpty() || passwordField.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Please enter all fields for succesful registeration");
            alert.setTitle("Pay Attention");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                try {
                    root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            connection.writeDataLogin(emailField.getText(), passwordField.getText());
            Platform.runLater(() -> {
                try {
                    Thread.sleep(1000);
                    String str = connection.getData();
                    System.out.println(str);
                    if (str.equals("false,notExist")) {
                        Alert a = new Alert(Alert.AlertType.WARNING);
                        a.setHeaderText("Please enter the correct email and password or sign up !");
                        a.setTitle("Invalid Email!");
                        Optional<ButtonType> result = a.showAndWait();
                        if (result.get() == ButtonType.OK) {
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

                    } else {
                        Alert a = new Alert(Alert.AlertType.WARNING);
                        a.setHeaderText("Login Successfull!");
                        a.setTitle("Login Up");
                        Optional<ButtonType> result = a.showAndWait();
                        if (result.get() == ButtonType.OK) {
                            try {
                                PlayerLoggedIn.setMail(emailField.getText());
                                root = FXMLLoader.load(getClass().getResource("RequestGame.fxml"));
                            } catch (IOException ex) {
                                Logger.getLogger(ServerConnection.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                            scene = new Scene(root);
                            stage.setScene(scene);
                            stage.show();

                        }

                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
                }

            });

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
