/*
Multiplicar los elementos de una tabla, por los elementos de 
un vector
 */
package primera2223;

/**
 *
 * @author alber
 */
public class Ejercicio028 {
     public static void main(String arg[]){
        int tabla[][] = {{10, 20, 30, 40}, {40, 50, 60, 70}, {70, 80, 90, 100}};
        int v1[] ={2, 4, 6};
        for (int i = 0; i < tabla.length; i++){
            for (int j = 0; j < tabla[i].length; j++)
                System.out.printf("%d - ", tabla[i][j]*v1[i]);
        System.out.println();
        }
     }
    
}
