/*

 */
package ejercicio003;

/**
 *
 * @author alberto
 */
public class Perro extends Animal{
    
    String raza;
    String caracter;
    
    public Perro (int c, String s, String n, String r, String car){
        super(c, s, n, "guau, guau!");
        raza = r;
        caracter = car;
        
    }
    public void hablar(){
        System.out.println(onomatopeya + " Hola, soy " + nombre + ", mi código es: " + 
                codigo + ", soy " + sexo + " de raza: " + raza + " y soy " + 
                caracter);
        
    }
    
}
