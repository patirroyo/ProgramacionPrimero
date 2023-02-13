/*
El binomio de Newton aplica la siguiente fórmula:

o lo que es lo mismo :


Realizar la función que resuelva el algoritmo de Newton.
(Para obtener la potencia de un número elevado a otro tenéis que utilizar la función Math.pow(número, potencia)).

 */
package examen1;


public class Examen001 {
   public static void main(String arg[]){
       int x = 2;
       int y = 3;
       int n = 5;
       System.out.printf("El resultado de (%d + %d)^%d es: %.0f\n",x,y,n,binomioNewton(x,y,n)); //llamo a la función para que muestre por pantalla el resultado
    
   }
       
    public static double binomioNewton(int x, int y, int n){   
        int resultado = 0;//instancio un entero para el resultado
        for(int k = 0; k <= n; k++){ //creo un bucle que durará n veces +1 (desde el 0 hasta n incluido)
           resultado += factorial(n)/(factorial(k)*factorial(n-k))*Math.pow(x,(n-k))*Math.pow(y, k); //voy acumulando el resultado
           
        }
        return resultado;   //devuelvo el resultado para mostrarlo por pantalla  
       
    }  
    public static int factorial(int x){ //he traído la funcion recursiva de factorial y añadido el caso de x = 0
        if(x == 0)
            return 1;
        if(x == 1)
            return 1;
        else
            return x * factorial(x-1);
   }
}
