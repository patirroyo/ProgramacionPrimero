/*
Variaciones de 7 elementos tomados de 4 en 4

Es factorial de 7 partido de factorial 4
7*6*5*4*3*2*1/4*3*2*1=7*6*5*4

se puede hacer con for y con while, sería más conveniente con el for porque
sabemos el número de iteraciones.
 */
package primera2223;

/**
 *
 * @author alber
 */
public class Ejercicio013 {
    public static void main(String arg[]){
        int elementos = 7;
        int tomados = 4;
        int acumulador = 1;
        for(int pos = elementos; pos > tomados; pos--){
            acumulador *= pos;
        }
        System.out.println("Variaciones de " + elementos + 
                " elementos, tomados de " + tomados + " en " + tomados + 
                " = " + acumulador);
        int pos = elementos;//puedo volverla a declarar porque la anterior estaba dentro del for
        acumulador = 1; //no la puedo volver a declarar porque ya está declarada
        while(pos > tomados){
            acumulador *= pos;
            pos--;
        }
        System.out.println("Variaciones de " + elementos + 
        " elementos, tomados de " + tomados + " en " + tomados + 
        " = " + acumulador);
        System.out.printf("Variaciones de %d elementos, tomados de %d en %d = %d \n", elementos, tomados, tomados, acumulador);
                /* %d: aquí vendrá un número en base 10 decimal.
                   %f: aquí vendría un número con decimales, numeros en coma flotante
                   \n: retorno de carro.
                   \ es una secuencia de escape, no se tiene en cuenta la \ y lo siguiente representa algo: n es salto de carro
                   Los número que vendrán aquí son los argumentos*/
        }
    }
