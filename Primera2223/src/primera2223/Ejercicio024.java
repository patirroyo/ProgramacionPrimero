/*
 Mostrar por pantalla el contenido de los elementos de datos multiplicados
por los elementos de múltiplos, en tres líneas, una línea por cada uno de los
elementos contenidos en multiplos.
 */
package primera2223;

public class Ejercicio024 {
    public static void main(String arg[]){
        int[] datos = {10, 20, 30, 40, 50, 60};
        int[] multiplos = {3, 5, 7};
        for(int j = 0; j < multiplos.length; j++){
            for(int i = 0; i < datos.length; i++)
                if(i < datos.length - 1)
                    System.out.print(datos[i]*multiplos[j] + ", ");
                else
                    System.out.println(datos[i]*multiplos[j] + ".");
        }
    }
}
