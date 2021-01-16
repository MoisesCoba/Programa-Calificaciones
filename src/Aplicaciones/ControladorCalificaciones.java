/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicaciones;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import viw.Calificaciones;
import viw.Estudiantes;

/**
 *
 * @author Haylin
 */
public class ControladorCalificaciones extends BaseControlador{
    protected static ArrayList<Estudiantes> listaDatos=new ArrayList<>();
    protected static ObservableList <Estudiantes> PersonaVista = FXCollections.observableList(listaDatos);
     protected static ArrayList<Calificaciones> listaDatos2=new ArrayList<>();
    protected static ObservableList <Calificaciones> CaliVista = FXCollections.observableList(listaDatos2);
     protected static Calificaciones editPersona=null;
    public void Leer(){
    try{
            
            BufferedReader CSV=new BufferedReader(new FileReader("Estudiantes.csv"));
            
            String linea=CSV.readLine();
            linea=CSV.readLine(); 
            
            while(linea!=null){
                String[] campos=linea.split(",");
                
                Estudiantes temporalPropiedades=new Estudiantes(campos[0],campos[1],campos[2],campos[3]);
                listaDatos.add(temporalPropiedades); 
                
                linea=CSV.readLine(); 
            }
            CSV.close();
        }catch(IOException e){
            System.out.println("Error al leer archivos");
            System.exit(0);
        }
        
}
    public void Leer2(){
          try{
            
            BufferedReader CSV=new BufferedReader(new FileReader("Calificaciones.csv"));
            
            String linea=CSV.readLine();
            linea=CSV.readLine(); 
            
            while(linea!=null){
                String[] campos=linea.split(",");
                
               // Calificaciones temporal=new Calificaciones(campos[0],campos[1],campos[2]);
               // listaDatos2.add(temporal);
                
                linea=CSV.readLine(); 
            }
            CSV.close();
        }catch(IOException e){
            System.out.println("Error al leer archivos");
            System.exit(0);
        }
    }
    
}