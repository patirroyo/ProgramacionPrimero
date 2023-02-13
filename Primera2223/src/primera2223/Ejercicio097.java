/*
Multiplicar una tabla por un vector
 */

package primera2223;
    
public class Ejercicio097 {
    public static void main(String arg[]){
        int tabla[][] = {{1,2,3,4},{2,4,6,8},{3,6,9,12},{4,8,12,16}};
        int vector[] = {1,2,3,4};
        multiplicar(tabla, vector);
            
        
        
    }

    private static void multiplicar(int[][] tabla, int[] vector) {
        int resultado[][] = new int[4][4];
        
        for(int i = 0; i < tabla.length; i++){
            for(int j = 0; j < vector.length; j++){
                resultado[i][j] = tabla[i][j] * vector[j];
                System.out.print(resultado[i][j] + " ");
            }
            System.out.println();
        }
    }
}


