/*
Escribir frase1 sobre frase2, pero los carácteres deben estar invertdos.
Quedaría: "nózaroc le abargela..."
 */
package primera2223;

public class Ejercicio082 {
     public static void main(String arg[]){
        String frase1 = "Había una vez, un circo que alegraba siempre el corazón";
        String frase2 = "";
      
        
        for(int j = frase1.length()-1; j >= 0; j--){
            frase2 += frase1.charAt(j);
        }
        
       
        System.out.println(frase2);
     }
}
    
