/*
Implementar un método que modifique los datos de una tabla,
multiplicándolos por un entero.
 */
package primera2223;

public class Ejercicio051 {
     public static void main(String arg[]){
        int tabla[][] = {{1, 2, 3, 4},
                         {5, 6, 7, 8},
                         {9, 10, 11, 12},
                         {13, 14, 15, 16}};
        int multiplicador = 4;
        multiplicar(tabla, multiplicador);
        for(int i = 0; i < tabla.length; i++){
            for(int j =0; j < tabla[i].length; j++)
                System.out.printf("%d ", tabla[i][j]);
            System.out.println();
        }
     }
     public static void multiplicar(int t[][], int x){
         for(int i = 0; i < t.length; i++)
             for(int j = 0; j < t[i].length; j++)
                 t[i][j] *= x;
     }
}
