/*
Implementar una función que devuelva el número de veces que
una subcadena aparece repetido dentro de una cadena.
 */
package primera2223;

/**
 *
 * @author alber
 */
public class Ejercicio061 {
     public static void main(String arg[]){
        char frase[] = {'E', 'n','n', 'n', 'n', ' ', 'n', 'n', 'n','n', 'r', ' ', 'n', 'n', 'n', ' ', 'L', 'a', ' ','M', 'a', 'n', 'c', 'h', 'a', ' '};
        char subcadena[] = {'n', 'n', 'n'};
        System.out.println("El número de veces que se repite la subcadena es: " + apariciones(frase, subcadena));
     }
     
     public static int apariciones(char[]fr, char[]subcad){
         int cont = 0;
         int j;
         for(int i = 0; i < fr.length; i++){
            if (fr[i] == subcad[0]){
                j = 1;
                while ((j < subcad.length) && (subcad[j] == fr[i+j]))
                     j++;
                if (j == subcad.length)
                        cont++;   
            }
        }
        return cont;
     }
}
