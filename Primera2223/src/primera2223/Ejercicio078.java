/*
convertir a mayúsculas la subcadena definida, cada vez que aparezca
en las frases.
 */
package primera2223;

public class Ejercicio078 {
     public static void main(String arg[]){
        String frase[] = {"en un lugar", " lugar en la Mancha", ", de cuyo lugar ", "no quiero acordarme"}; 
        String subcadena = "en";
        
        for(int i = 0; i < frase.length; i++)
            frase[i] = frase[i].replace(subcadena, subcadena.toUpperCase()); // llamo a la funcion replace y cambio cadena por cadena.toUpperCase
        
        frase[0] = frase[0].concat("hola"); //función concatenar, espera recibir un String y hay que llamarla desde un objeto de la clase String.
        
        for(int i = 0; i < frase.length; i++)
            System.out.print(frase[i]);
        
     }
}
    
