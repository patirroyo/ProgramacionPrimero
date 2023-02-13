/*
Añadir una "a" al final de cada palabra, sin usar replace
 */
package primera2223;

public class Ejercicio083 {
     public static void main(String arg[]){
        String frase1 = "Había una vez, un circo que alegraba siempre el corazón ";
       
        int posicion = frase1.indexOf(" ");
        while(posicion != -1){
            frase1 = frase1.substring(0,posicion).concat("A").concat(frase1.substring(posicion));
            posicion = frase1.indexOf(" ", posicion + 2);
        }
        
      
        System.out.println(frase1);
     }
}
    
