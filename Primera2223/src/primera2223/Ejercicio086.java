/*
La recursividad: funciones que se llaman a si mismas.
Para realizar un factorial de 5; primero hacemos 5 * factorial de 4, 
luego por 3, 2...
y cuando tenenemos el factorial de 2, caluculamos el de 3, el de 4 y finalmente el de 5
Es un camino de ida y vuelta; backtracking.
Todas las funciones recursivas deben tener una condición de finalización.
 */
package primera2223;


public class Ejercicio086 {
   public static void main(String arg[]){
       int numero = 5;
       System.out.println("El factorial de " + numero + " es: " + factorial(numero));
   } 
   
   
   public static int factorial(int x){
        if(x == 1)
            return 1;
        else
            return x * factorial(x-1);
   }
}
