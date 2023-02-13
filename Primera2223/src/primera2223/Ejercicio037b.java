/*
Trasponer la matriz sin usar tabla2
 */
package primera2223;

/**
 *
 * @author alber
 */
public class Ejercicio037b {
    public static void main(String arg[]){
        int tabla[][] = {{1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}};
        int inter;
        for(int i = 0; i < tabla.length; i++){
            for(int j = i + 1; j < tabla[i].length; j++){/*como sólo tengo que dar la vuelta a la
                parte derecha de la mitad de la matriz lo hago que j sea i + 1*/
                inter = tabla[i][j];
                tabla[i][j] = tabla[j][i];
                tabla[j][i] = inter; 
            }
        }
        for(int i = 0; i < tabla.length; i++){
            for(int j = 0; j < tabla[i].length; j++)
                System.out.print(tabla[i][j] + " ");//aquí la muestro por pantalla.
        System.out.println();
        }
    }
}
