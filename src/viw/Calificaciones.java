/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viw;

import javafx.collections.ObservableList;

/**
 *
 * @author Haylin
 */
public class Calificaciones {

   
    private String matricula;
    private String Materia;
   
    private int Cali;

    public Calificaciones(String matricula, String Materia, int Cali) {
        this.matricula = matricula;
        this.Materia = Materia;
        
        this.Cali = Cali;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String Matricula) {
        this.matricula = Matricula;
    }

    public String getMateria() {
        return Materia;
    }

    public void setMateria(String Materia) {
        this.Materia = Materia;
    }

    public int getCali() {
        return Cali;
    }

    public void setCali(int Cali) {
        this.Cali = Cali;
    }

   
    
    
    
    @Override
    public String toString() {
        return matricula+","+Materia +"," +Cali  ;
    }
    
}
