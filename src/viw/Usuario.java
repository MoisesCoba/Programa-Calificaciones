/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viw;

/**
 *
 * @author Haylin
 */
public class Usuario {
     private String nombre;
    private String contra;
   
    public Usuario(String nombre, String contra) {
        this.nombre = nombre;
        this.contra = contra;
      
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String Contra) {
        this.contra = Contra;
    }

    
    
    
    @Override
    public String toString() {
        return nombre+","+contra;
    }
    
    
}
