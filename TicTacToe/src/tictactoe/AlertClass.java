/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class AlertClass {

    public static Alert signUpAlert() {
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setHeaderText("This mail already registered before");
        a.setTitle("Invalid Email!");
      
        return a;

    }
     public static Alert logInAlert() {
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setHeaderText("Please Sign Up!");
        a.setTitle("Sign Up");
      
        return a;

    }
}
