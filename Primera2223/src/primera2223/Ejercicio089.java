/*
La recursividad: funciones que se llaman a si mismas.
Division mediante restas
Todas las funciones recursivas deben tener una condición de finalización.
 */
package primera2223;


public class Ejercicio089 {
   public static void main(String arg[]){
       mostrarFrase (5);
   } 
   
   
   public static void mostrarFrase(int a){
        if(a > 0){
           System.out.println("mostrarFrase(" + a + ")");
           mostrarFrase(a-1);
           System.out.println("mostrarFrase(" + a + ")");
        }
   }
}
