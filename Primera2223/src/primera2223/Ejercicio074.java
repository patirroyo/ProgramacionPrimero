/*
La funcion substring
 */
package primera2223;

/**
 *
 * @author alber
 */
public class Ejercicio074 {
     public static void main(String arg[]){
        String frase = "En un lugar de la Mancha, de cuyo nombre no quiero acordarme"; 
        
        System.out.printf("%s \n", frase.substring(3));
        
        for(int i=0; i<frase.length();i++)
            System.out.printf("%s\n", frase.substring(0, i+1));
        
     }
    
}
