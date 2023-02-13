/*
Crear una funcion para el factorial y usarla en las combinaciones de tantos 
elementos tomados de tantos en tantos.
Combinaciones de A elementos tomados de b en b.
Cab= factorial (a) / factorial (a-b) * factorial (b)
 */
package primera2223;

public class Ejercicio049 {
     public static void main(String arg[]){
        int a = 5;
        int b = 2;
        int resultado = factorial(a)/(factorial (a-b)*factorial(b));
        
        System.out.printf("Variaciones de %d elementos, tomados de %d en %d = %d \n", a, b, b, resultado);
    }
     
    public static int factorial(int numero){
        int acumulador = 1;   
        for(int cont = 1; cont <= numero; cont++)
           acumulador *= cont;
        return acumulador;
    }
}
