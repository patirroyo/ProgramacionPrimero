/*
 División entera mediante restas
 */
package primera2223;

/**
 *
 * @author alber
 */
public class Ejercicio012 {
    public static void main(String arg[]){
        int dividendo = 29;
        int divisor = 4;
        /*Vamos a usar el bucle while (_______) que solo tiene una condición
        Si utulizamos la variable dividendo, cada vez se va a ir restando,
        por lo que declaramos una variable para guardarlo
        */
        int aModificar = dividendo;
        int cuenta = 0; //inicializamos la variable que contara la cantidad de restas
        while(aModificar >= divisor){
            aModificar -= divisor;
            cuenta++; // = cuenta += 1 "o" cuenta = cuenta + 1
        }
        System.out.println(dividendo + " / " + divisor + " = " + cuenta);
        }
    }
    
