/*
Mostrar por pantalla el número de apariciones de un cacter
dentro de un vector de Strings.
 */
package primera2223;

public class Ejercicio076 {
     public static void main(String arg[]){
        String frase[] = {"en un lugar", " lugar de la Mancha", ", de cuyo lugar", "no quiero acordarme"}; 
        
        char caracter = 'a';
        
        int cont = 0;
        for(int i = 0; i < frase.length; i++)
           for(int j = 0; j < frase[i].length(); j++)
               if(frase[i].charAt(j) == caracter)
                cont++;
                            
         System.out.printf("El carácter '%s' aparece %d veces.\n", caracter, cont);
       }
}
    
