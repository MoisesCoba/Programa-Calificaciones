/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicaciones;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import viw.Calificaciones;
import viw.Estudiantes;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Haylin
 */
public class TablaControlador extends ControladorCalificaciones implements Initializable {
@FXML
    private TableColumn tblMatricula;
    @FXML
    private TableColumn  tblNombre;
    @FXML
    private  TableColumn tblPaterno;
    
     @FXML
    private  TableColumn tblMaterno;
    @FXML
    private TableView<Estudiantes> Estudiantes;
    @FXML
    private Button btnGuardar;
    @FXML
    private TextField fildMatricula;
    @FXML
    private TextField fildCali;
    
    @FXML
    private Button btnGenerarA;
    @FXML
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Leer();
       tblMatricula.setCellValueFactory(
                new PropertyValueFactory<>("Matricula"));
       tblNombre.setCellValueFactory(
                new PropertyValueFactory<>("nombre"));
       tblPaterno.setCellValueFactory(
                new PropertyValueFactory<>("apellidoPaterno"));
       tblMaterno.setCellValueFactory(
                new PropertyValueFactory<>("apellidoMaterno"));
       Estudiantes.setItems(PersonaVista);
    }
    
     @FXML
    private void GuardadDatos(ActionEvent event) {
        String Matri;
        Matri=fildMatricula.getText();
        String Matricula2="";
        int Calificacion;
             Calificacion   =parseInt(fildCali.getText());
        for(int i=0;i<listaDatos.size();i++){
        if(listaDatos.get(i).getMatricula().equals(Matri))
        {
            Matricula2=Matri;
        }
            }
        if(Calificacion<0 || Calificacion>100){
             Alert alert=new Alert(Alert.AlertType.INFORMATION);
             alert.setHeaderText(null);
             alert.setTitle("Informacion");
             alert.setContentText("La Calificacion no va acorde");
             alert.showAndWait();
             fildMatricula.clear();
             fildCali.clear();}
        else{
        if(Matricula2==Matri){
            listaDatos2.add(new Calificaciones(Matricula2,"Disenio De Software",Calificacion));
             Alert alert=new Alert(Alert.AlertType.INFORMATION);
             alert.setHeaderText(null);
             alert.setTitle("Informacion");
             alert.setContentText("Calificacion Guardada");
             alert.showAndWait();
             fildMatricula.clear();
             fildCali.clear();
        }else{
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
             alert.setHeaderText(null);
             alert.setTitle("Informacion");
             alert.setContentText("La Matricula no Existe");
             alert.showAndWait();
             fildMatricula.clear();
             fildCali.clear();
        }
        }
       
    }

     @FXML
    private void GenerarArchivo(ActionEvent event)  {
        BufferedWriter CSV;
     try{   
    CSV = new BufferedWriter(new FileWriter("Calificaciones.csv"));
           String encabezadoCSV="Matricula,Asignatura,Calificacion";
           CSV.write(encabezadoCSV);
           CSV.newLine();
           
            for(int i=0;i<listaDatos2.size();i++){
                
             
                String lineaNueva=listaDatos2.get(i).getMatricula()+","+listaDatos2.get(i).getMateria()+","+listaDatos2.get(i).getCali();
                CSV.write(lineaNueva);
                CSV.newLine();
                
               

            }CSV.close();
                System.out.println(" guardado");
     }catch (IOException e) {
            System.out.println("No guardado");
    }
      Alert alert=new Alert(Alert.AlertType.INFORMATION);
             alert.setHeaderText(null);
             alert.setTitle("Informacion");
             alert.setContentText("Archivo Generado");
             alert.showAndWait();
             fildMatricula.clear();
             fildCali.clear();
    }
    @FXML
    private void VerCali(ActionEvent event) {
        
         try {
        navegador(event, getClass().getResource("EditarCalificaciones.fxml"));
    } catch(Exception e) {
        e.printStackTrace();
    }
         PersonaVista.clear();
      
    }
}
