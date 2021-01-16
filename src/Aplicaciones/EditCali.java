/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicaciones;

import static Aplicaciones.ControladorCalificaciones.PersonaVista;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import viw.Calificaciones;
import viw.Estudiantes;

/**
 *
 * @author Haylin
 */
public class EditCali extends ControladorCalificaciones implements Initializable{
 @FXML
    private TableColumn  tblMatricula;
    @FXML
    private  TableColumn tblAsig;
    
     @FXML
    private  TableColumn tblCali;
    @FXML
    private TableView<Calificaciones> tblCalifi;
    @FXML
    private Button Editar;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Leer2();
         tblMatricula.setCellValueFactory(
                new PropertyValueFactory<>("matricula"));
       tblAsig.setCellValueFactory(
                new PropertyValueFactory<>("Materia"));
       tblCali.setCellValueFactory(
                new PropertyValueFactory<>("Cali"));
       
       tblCalifi.setItems(CaliVista);
    }
     @FXML
    private void Editar(ActionEvent event) {
          editPersona=Calificaciones.class.cast(tblCalifi.getSelectionModel().getSelectedItem());
        if (editPersona==null) return;
        
     try {
      
        navegador(event, getClass().getResource("EditarCali2.fxml"));
        } catch(Exception e) {
        e.printStackTrace();
                             }
    }
    
    
    @FXML
    private void Editar2(MouseEvent event) throws IOException {
        editPersona=Calificaciones.class.cast(tblCalifi.getSelectionModel().getSelectedItem());
        if (editPersona==null) return;}
}
