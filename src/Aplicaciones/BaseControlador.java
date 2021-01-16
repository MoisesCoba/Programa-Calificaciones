/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicaciones;

import java.io.IOException;
import java.net.URL;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
//5572
/**
 *
 * @author joseluislopezmartinez
 */
public class BaseControlador {
     protected void navegador(Event event, URL fxmlDocName) throws IOException {
        
        Parent pageParent = FXMLLoader.load(fxmlDocName);
        Scene scene = new Scene(pageParent);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.hide();
        appStage.setScene(scene);
        appStage.show();
    }
  
   protected void navegador2(Event event, String fxmlDocName) throws IOException {
          FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlDocName));
          Parent root1 = (Parent) fxmlLoader.load();
          Stage stage = new Stage();
          stage.setScene(new Scene(root1));  
          stage.show();
   }
   
   
   
   
   
}
