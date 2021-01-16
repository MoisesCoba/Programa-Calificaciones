
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicaciones;

import static Aplicaciones.ControladorCalificaciones.editPersona;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Haylin
 */
public class EditarCalificaciones extends ControladorCalificaciones implements Initializable{
    @FXML
    private Button btnActualizar;
    @FXML
    private Button btnCancelar;
    @FXML
    private Label Matricula;
    @FXML
    private Label Materia;
    @FXML
    private TextField fildCali;
    
    @FXML
    private void Actualizar(ActionEvent event)  {
        int Califi=parseInt(fildCali.getText());
        
        editPersona.setCali(Califi);
        
        try {
        navegador(event, getClass().getResource("Calificaciones.fxml"));
    } catch(Exception e) {
        e.printStackTrace();
    }
    }
    @FXML
     private void CancelarA(ActionEvent event)  {
          try {
       
        navegador(event, getClass().getResource("Calificaciones.fxml"));
    } catch(Exception e) {
        e.printStackTrace();
    }
     }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Matricula.setText(editPersona.getMatricula());
        Materia.setText(editPersona.getMateria());
        String Califi=String.valueOf(editPersona.getCali());
        fildCali.setText(Califi);
    }
}
