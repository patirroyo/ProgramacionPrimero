/*
 Comparación entre dos números, decir cuál es mayor y también si son iguales
if anidados
 */
package primera2223;
public class Ejercicio003 {
     public static void main(String arg[]){ //método main, metodo ejecutable
       int x, y;
       x = 75;
       y = 75;
       if(x == y)
           System.out.println("Ambos números son iguales y valen : " + x);
       else if(x > y)
               System.out.println("El mayor es: " + x);
            else
               System.out.println("El mayor es: " + y);
    }
}