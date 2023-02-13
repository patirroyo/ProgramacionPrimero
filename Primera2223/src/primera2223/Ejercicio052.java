/*
Implementar una funcion que modifique el contenido de la tabla kilos
multiplicándolo cada uno de sus elementos por su precio.
Los precios están en el vector precios.
 */
package primera2223;


public class Ejercicio052 {
    public static void main(String arg[]){
        int kilos[][] = {{5, 6, 9, 23, 7, 14, 0},
                         {16, 8, 4, 33, 15, 21, 0}};
        int precios[] = {6, 7};
        modificar(kilos, precios);
        for(int i = 0; i < kilos.length; i++){
            for(int j =0; j < kilos[i].length; j++)
                System.out.printf("%d ", kilos[i][j]);
            System.out.println();
        }
      }
    public static void modificar(int t[][], int v[]){
        for (int i = 0; i < t.length; i++)
            for (int j = 0; j < t[i].length; j++)
                t[i][j] *= v[i];
          
      }
}
