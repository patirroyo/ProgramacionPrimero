/*
tienes un número en decimal y lo tienes que mostrar por pantalla en binario.
 */
package primera2223;


public class Ejercicio092 {
     public static void main(String arg[]){
        int numero = 255; 
        binario(numero);
        System.out.println();
     }
     
     public static void binario(int numero){
         if(numero != 0){
            binario(numero/2);
            System.out.printf("%d", numero%2);
         }
         
     }
}
