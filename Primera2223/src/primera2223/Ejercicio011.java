/*
 Multiplicación mediante sumas
7*5 es igual a 7+7+7+7+7
 */
package primera2223;


public class Ejercicio011 {
    public static void main(String arg[]){
        int multiplicando = 7;
        int multiplicador = 5;
        int acumulador = 0;
        
        for (int cont = 1; cont <= multiplicador; cont++)
             acumulador += multiplicando; 
        System.out.println(multiplicando + " * " + multiplicador + " es igual a " + acumulador);
        
        
        acumulador = 0;
        
        for(int cont = multiplicador; cont >= 1; cont--)
           acumulador += multiplicando;       
        System.out.println(multiplicando + " * " + multiplicador + " es igual a " + acumulador);
    }
}