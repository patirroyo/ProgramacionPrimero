/*
 División entera mediante restas
 */
package primera2223;

/**
 *
 * @author alber
 */
public class Ejercicio012b {
    public static void main(String arg[]){
        int dividendo = 29;
        int divisor = 4;
        int restando = dividendo;
        int cociente = 0;
        for(int cont = 0; restando >= 0; cont++){//no se usa porque no conocemos el numero de 
            restando -= divisor;
            cociente = cont;
        }
        System.out.println(dividendo + " / " + divisor + " = " + cociente);
        }
    }
    
