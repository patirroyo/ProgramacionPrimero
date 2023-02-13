/*
 Mostrar por pantalla el contenido de los elementos de datos multiplicados
por los elementos de múltiplos, en tres líneas, una línea por cada uno de los
elementos contenidos en multiplos.
 */
package primera2223;

public class Ejercicio024b {
    public static void main(String arg[]){
        int[] datos = {10, 20, 30, 40, 50, 60};
        int[] multiplos = {3, 5, 7};
        for(int i = 0; i < multiplos.length; i++){
            for(int j = 0; j < datos.length; j++)
               System.out.printf(" %d - ", datos[j]*multiplos[i]);
        System.out.println();
        }
    }
}
