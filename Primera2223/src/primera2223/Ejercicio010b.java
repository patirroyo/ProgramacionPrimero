/*
 Calcular el factorial de un número
5!=
 */
package primera2223;

/**
 *
 * @author alber
 */
public class Ejercicio010b {
   public static void main(String arg[]){
       int numero = 5;
       int acumulador = 1;
       for(int cont = numero; cont >= 1; cont--){
           acumulador *= cont;                   
       }
       System.out.println("El factorial de " + numero + " es " + acumulador);
       
   }  
}

