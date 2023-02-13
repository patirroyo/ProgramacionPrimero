/*
 Decir cuál de las 3 variables es mayor
 */
package primera2223;

public class Ejercicio004 {
     public static void main(String arg[]){
         int x;
         int y;
         int z;
         x = 12;
         y = 110;
         z = 65;
         if (x > y){
             if (x > z){
                 System.out.println("El mayor es: " + x);
             }else 
                 System.out.println("el mayor es: " + z);
        }else
             if (y > z){
                 System.out.println("El mayor es: " + y);
             }else{
                 System.out.println("el mayor es: " + z);
                }   
     }
}
