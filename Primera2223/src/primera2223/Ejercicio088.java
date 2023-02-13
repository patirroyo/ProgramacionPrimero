/*
La recursividad: funciones que se llaman a si mismas.
Division mediante restas
Todas las funciones recursivas deben tener una condición de finalización.
 */
package primera2223;


public class Ejercicio088 {
   public static void main(String arg[]){
       int dividendo = 10;
       int divisor = 3;
       System.out.println("El resultado de dividir " + dividendo + " entre " +  divisor + " es: " + division(dividendo, divisor));
   } 
   
   
   public static int division(int x, int y){
        if(x < y){
           return 0;
        }
        else
            return 1 + division(x-y, y);
    }
}
