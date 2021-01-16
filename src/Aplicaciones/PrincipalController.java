package Aplicaciones;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import viw.Usuario;
public class PrincipalController extends BaseControlador implements Initializable {
    ArrayList<Usuario> listaDatos2=new ArrayList<>();
   @FXML
    private TextField fildContra;
    @FXML
    private TextField fildUsuario;
            @FXML
    private void Iniciar(ActionEvent event) {
        
        try{
            
            BufferedReader csv=new BufferedReader(new FileReader("Contrasenias.csv"));
            
            String linea2=csv.readLine();
            linea2=csv.readLine(); 
            
            while(linea2!=null){
                String[] campos2=linea2.split(",");
                
                Usuario temporal=new Usuario(campos2[0],campos2[1]);
                listaDatos2.add(temporal); 
                linea2=csv.readLine(); 
            }
            csv.close();
        }catch(IOException e){
            System.out.println("Error al leer archivos");
            System.exit(0);
        }
        System.out.println(" Datos");
        for(int i=0;i<listaDatos2.size();i++){
            

        }   
       
        Scanner scanner = new Scanner(System.in);
        String Usuario;
        String Contra;
        String UsuarioO="";
        String ContraO;

        
        
       Usuario= fildUsuario.getText();
      
       Contra = fildContra.getText();
       char array[]=Contra.toCharArray();
                for(int i=0;i<array.length;i++){
                    array[i]=(char)(array[i]+(char)5);
                }
                      String encriptado=String.valueOf(array);

       ContraO=Usuario;
        for(int i=0;i<listaDatos2.size();i++){
            if(listaDatos2.get(i).toString().equals(Usuario+","+encriptado))
            {
                UsuarioO=Usuario;
                
                

            
            }
        }
       
       
        if(UsuarioO != ContraO){
            System.out.println("LA CONTRASENIA O EL USUARIO SON INCORRECTOS");
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
             alert.setHeaderText(null);
             alert.setTitle("Informacion");
             alert.setContentText("LA CONTRASEÑA O  EL USUARIO SONINCORRECTOS");
             alert.showAndWait();
             fildUsuario.clear();
             fildContra.clear();
       
    }
        else{
           fildUsuario.clear();
             fildContra.clear();
        System.out.println("Usuario Aceptado");
         Alert alert=new Alert(Alert.AlertType.INFORMATION);
             alert.setHeaderText(null);
             alert.setTitle("Informacion");
             alert.setContentText("USUARIO ACEPTADO");
             alert.showAndWait();
        
        
        try {
        navegador(event, getClass().getResource("Calificaciones.fxml"));
    } catch(Exception e) {
        e.printStackTrace();
    }
         
        }
    }
    

        @FXML
    private void Registrar(ActionEvent event)  {
        
       
       try {
      
        navegador(event, getClass().getResource("RegistarUsuario.fxml"));
        } catch(Exception e) {
        e.printStackTrace();
                             }
   
        
       
    } 

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    
}
