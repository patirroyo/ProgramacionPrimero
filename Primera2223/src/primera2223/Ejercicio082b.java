/*
Escribir frase1 sobre frase2, pero los carácteres deben estar invertdos.
Quedaría: "nózaroc le abargela..."
 */
package primera2223;

public class Ejercicio082b {
     public static void main(String arg[]){
        String frase1 = "Había una vez, un circo que alegraba siempre el corazón";
        String frase2 = "";
      
        
        for(int i = frase1.length()-1; i >= 0; i--){
            frase2 = frase2.concat(Character.toString(frase1.charAt(i)));
        }
        
       
        System.out.println(frase2);
     }
}
    
