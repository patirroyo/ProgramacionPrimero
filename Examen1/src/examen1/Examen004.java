/*
Realizar una función que devuelva una tabla, resultado de la multiplicación de 
dos matrices cuadradas, que la función recibe.


El elemento  de la matriz producto se obtiene multiplicando cada elemento de la
fila  de la matriz  por cada elemento de la columna  de la matriz  y sumándolos.

 */
package examen1;


public class Examen004 {
     public static void main(String arg[]){//primero instancio las matrices
       int a[][] = {{2,0,1},
                    {3,0,0},
                    {5,1,1}};
       int b[][] = {{1,0,1},
                    {1,2,1},
                    {1,1,0}};
       
       
       for(int i = 0; i < b.length; i++){//un bucle anidado para mostrar por pantalla el resultado.
            for(int j = 0; j < b[i].length; j++)
                System.out.print(multiplicaMatriz(a, b)[i][j]+ " ");
            System.out.println();//dentro del bucle principal para pasar de fila 
       
       }
        
    }

    public static int[][] multiplicaMatriz(int[][] a, int[][] b) {
        
        int resultado[][] = new int[a.length][a[1].length];//instancio una matriz más para el resultado, del mismo tamaño que la matriz A
        for(int i = 0; i < b.length; i++)
            /*
            Voy a necesitar hacer tres bucles anidados:
            el primero y el segundo índices i y j nos servirán para recorrer la
            matriz resultado.
            El tercero nos sirve para ir acumulando las sumas en cada uno de los
            elementos de la matriz.
            */
            for(int j = 0; j < b[i].length; j++)
                for(int k = 0; k < a.length; k++)
                    resultado[i][j] += a[i][k]*b[k][j];
                
        /*
        Mientras recorremos la matriz resultado, vamos acumulando los
        los resultados de la suma de los elementos(recorremos con k) de cada columna[i]
        de la matriz A multiplicados por los elementos ("mantenemos" con j) de la
        la columna k (que vamos recorriendo).
        */
        
        return resultado;
        
    }
}
