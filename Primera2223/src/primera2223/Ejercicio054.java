/*
Implementar la función sumarKilos que te devuelva un vector de
2 elementos con los kilos que se han vendido de cada producto.
 */
package primera2223;

public class Ejercicio054 {
    public static void main(String arg[]){
        int kilos[][] = {{5, 6, 9, 23, 7, 14, 0},
                         {16, 8, 4, 33, 15, 21, 0}};
        String productos[] = {"Peras", "Manzanas"};
        int ventas[] = sumarKilos(kilos);
        for(int i = 0; i < productos.length; i++)
            System.out.printf("Se han vendido %d Kg de %s.\n", ventas[i], productos[i]);
    }
    public static int[] sumarKilos(int k[][]){
        int[] v = new int[k.length];
        for (int i = 0; i < k.length; i++)
            for (int j = 0; j < k[i].length; j++)
                v[i] += k[i][j];
        return v;
    }
}
