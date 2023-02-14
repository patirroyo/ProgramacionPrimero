/*
 Calcular el maximo comun divisor de dos números mediante el algoritmo de 
Euclides, con y sin recursividad.
Consiste en ir restando el número más pequeño del más grande hasta que los dos 
sean iguales. Cuando ambos son iguales, ese es el máximo cómun divisor.
 */
package primera2223;

/**
 *
 * @author alberto
 */
public class Ejercicio096 {
    public static void main(String arg[]){
        int n1 = 20;
        int n2 = 15;
        
        euclides(n1,n2);
        
        while(n1 != n2)
            if(n1 < n2)
                n2 -= n1;
            else
                n1 -= n2;
        System.out.println("El máximo común divisor es " + n1);
    }
    public static void euclides(int n1, int n2){
        if(n1 == n2)
            System.out.println("El máximo común divisor es " + n1);
        else
            if (n1>n2)
                euclides(n1-n2,n2);
            else
                euclides(n1,n2-n1);
    }
        
    
    
}
