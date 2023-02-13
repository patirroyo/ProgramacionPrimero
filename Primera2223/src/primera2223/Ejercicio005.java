/*
 Mostrar por pantalla si un número es par o impar
 */
package primera2223;

/**
operador %; es el resto de la división entera
 */
public class Ejercicio005 {
     public static void main(String arg[]){
         int x, resto;
         x = 6;
         resto = x % 2;
         if (resto == 0){
             System.out.println("El número es par");
         }else
             System.out.println("El número es impar");
     }
}
