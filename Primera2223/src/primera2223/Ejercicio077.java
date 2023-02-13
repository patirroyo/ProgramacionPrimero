/*
Mostrar por pantalla el número de apariciones de una cadena
dentro de un vector de Strings.
 */
package primera2223;

public class Ejercicio077 {
     public static void main(String arg[]){
        String frase[] = {"en un lugar", " lugar de la Mancha", ", de cuyo lugar", "no quiero acordarme"}; 
        
        String subcadena = "en";
        
        int cont = 0;
        int posicion; 
        for(int i = 0; i < frase.length; i++){
            posicion = frase[i].indexOf(subcadena); //aquí nos da la primera posición de la subcadena
            while(posicion != -1){ //la funcion indexOf devuelve -1 si no lo encuentra
                cont++;
                posicion = frase[i].indexOf(subcadena, posicion + 1); // con esto hará que en el bucle empieze a buscar la subcadena a partir de la que ya acabamos de contar.
            }
        }
         System.out.printf("La cadena '%s' aparece %d veces.\n", subcadena, cont);
        }
}
    
