/*
sustituir todos los espacios en blanco por uno solo.
 */
package primera2223;

public class Ejercicio084 {
     public static void main(String arg[]){
        String frase1 = "Había    una vez,     un    circo que    alegraba siempre el    corazón ";
        //frase1 = frase1.replaceAll(" +", " ");
        
        int posicion = frase1.indexOf(" ");
        int primerEspacio = posicion;
        int espacio = 0;
        while(posicion != -1){
            espacio = posicion;
            posicion = frase1.indexOf(" ", posicion + 1);
            if(posicion - espacio > 1){
                frase1 = frase1.substring(0, primerEspacio).concat(frase1.substring(espacio));
                posicion = frase1.indexOf(" ", primerEspacio + 1);
                primerEspacio = posicion;
            }
         }
        frase1 = frase1.substring(0, primerEspacio).concat(frase1.substring(espacio+1));
        
        
        
        System.out.println(frase1);
     }
}
    
