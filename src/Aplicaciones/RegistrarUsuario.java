package Aplicaciones;



import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;


public  class  RegistrarUsuario extends BaseControlador implements Initializable {
     @FXML
    private TextField fildregUs;
    @FXML
    private TextField fildRegisCon;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
      // RegistrarUsuario();
    }
    
String Usuario;
 String contra;

    
    
@FXML
     public void GuardarDatos(ActionEvent event) {
        
        Usuario=fildregUs.getText();
        contra=fildRegisCon.getText();
        
        BufferedWriter CSV;
        try{
            // se crea el nuevo calificaciones.csv .csv
            
           CSV = new BufferedWriter(new FileWriter("Contrasenias.csv"));
           String encabezadoCSV="Usuario,Contrasenia";
           CSV.write(encabezadoCSV);
           CSV.newLine();
            Scanner scanner = new Scanner(System.in);

            // recorrer datos del arreglo-------
            System.out.println("Registar  Usuario ");
            
                
                
                
               
                char array[]=contra.toCharArray();
                for(int i=0;i<array.length;i++){
                    array[i]=(char)(array[i]+(char)5);
                }
                      String encriptado=String.valueOf(array);
                      System.out.println("Encriptando Contraseia");
                      
               
                
                CSV.write(Usuario +","+encriptado);
                CSV.newLine();
                
                
                //cerrar archivo CSV
            CSV.close();

            
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
             alert.setHeaderText(null);
             alert.setTitle("Informacion");
             alert.setContentText("Guardado");
             alert.showAndWait();
                fildregUs.clear();
                fildRegisCon.clear();
            }catch(IOException e) {
                    System.out.println("No guardado");}
        
        
     }
     @FXML
     public void RegresarLogin(ActionEvent event) {
     try {
      
        navegador(event, getClass().getResource("Principal.fxml"));
        } catch(Exception e) {
        e.printStackTrace();
                             }
     }
    
     
}