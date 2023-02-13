/*
Intercambiar las diagonales de una matriz
 */
package primera2223;

/**
 *
 * @author alber
 */
public class Ejercicio038 {
    public static void main(String arg[]){
        int tabla[][] = {{1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}};
        int inter;
         for(int i = 0; i < tabla.length; i++){
            inter = tabla[i][i];
            tabla[i][i] = tabla[i][tabla[i].length-i-1];
            tabla[i][tabla[i].length-i-1] = inter; 
            }
         for(int i = 0; i < tabla.length; i++){
            for(int j = 0; j < tabla[i].length; j++)
                System.out.print(tabla[i][j] + " ");//aquí la muestro por pantalla.
        System.out.println();
        }
        System.out.println();          
        for(int i = 0, j = tabla[i].length-i-1; i < tabla.length; i++){
            /*puedo declarar varias variables, que sen del mismo tipo
            también puedo poner varias condiciones para que salga del bucle*/
            inter = tabla[i][i];
            tabla[i][i] = tabla[i][j];
            tabla[i][j] = inter; 
            }        
        for(int i = 0; i < tabla.length; i++){
            for(int j = 0; j < tabla[i].length; j++)
                System.out.print(tabla[i][j] + " ");//aquí la muestro por pantalla.
        System.out.println();
        }
    }
}
