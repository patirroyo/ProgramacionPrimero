/*
 Mostrar por pantalla si un número es múltiplo de otro o no
 */
package primera2223;

/**
 *
 * @author alber
 */
public class Ejercicio007 {
     public static void main(String arg[]){
         int x, y, inter;
         x = 21;
         y = 3;
         /*declaro una variable intermedia si x es menor que y*/
         if (y > x){
             inter = y;
             y = x;
             x = inter;
             /* Si y es mayor que x, lo que hago es que y pase a memoria intermedia,
             para guardarlos, el hueco de y lo relleno con la x y luego lo que 
             tengo guardado en el inter se lo pongo a x; de este modo siempre 
             el primer número será el mayor*/
         }//Cuando llegamos a este punto, siempre la x será mayor que y
         if((x % y) == 0)  
             System.out.println(x + " es múltiplo de " + y);
         else
             System.out.println(x + " no es múltiplo de " + y);     
     }
}

