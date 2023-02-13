/*
Las 10 tablas de multiplicar
 */
package primera2223;

public class Ejercicio025 {
     public static void main(String arg[]){
        for(int i = 1; i <= 10; i++){
            for(int j = 1; j <= 10; j++)
                System.out.printf("%d * %d = %d \n", i, j, i*j);
        System.out.println();
        }
    } 
}
