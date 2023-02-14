/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio003;

/**
 *
 * @author alberto
 */
public class Mono extends Animal {
    String habilidades;
    Boolean cola;
    
    public Mono (int c, String s, String n, String h, Boolean col){
        super(c, s, n, "au, au!");
        habilidades = h;
        cola = col;
    }
    public void hablar(){
        if(cola){
            System.out.println(onomatopeya + " Hola, soy " + nombre + ", mi código es: "
                + codigo + ", soy " + sexo + ", tengo estas habilidades: " 
                + habilidades + " y tengo cola.");
        }
        else
            System.out.println(onomatopeya + " Hola, soy " + nombre + ", mi código es: "
                + codigo + ", soy " + sexo + ", tengo estas habilidades: " 
                + habilidades + " y no tengo cola.");
        
    }
    
}
