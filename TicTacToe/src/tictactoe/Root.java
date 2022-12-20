/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class Root {
     private  Parent root;

    public Parent getRoot() {
        return this.root;
    }

    public void setRoot(String r) {
         try {
             root = FXMLLoader.load(getClass().getResource(r));
         } catch (IOException ex) {
             Logger.getLogger(Root.class.getName()).log(Level.SEVERE, null, ex);
         }

    }

    public Root() {
    }
     
}
