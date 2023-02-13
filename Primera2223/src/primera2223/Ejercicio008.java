/*
 El bucle, tipo "for"
Una repetición

Hay dos tipos de bucles:
-for: los que sabemos el número de iteraciones (veces que se repite)
-los que no sabemos el número de iteraciones

Los bucles con un número determinado son de tipo "for" y tienen que tener
una condición de finalización.

Todos los bucles tienen que tener una finalización

Mas bien lo contrario, el bucle durará mientras se cumpla una condición
 */
package primera2223;

/**
 *
 * @author alber
 */
public class Ejercicio008 {
    public static void main(String arg[]){
        int cont; //declaramos una variable de contador
        for(cont = 0; cont < 10; cont++)
            /*tiene tres partes:
            1.- la primera es un contador inicial que le damos un valor, en
            este caso 0.
            2.- la condición de finalización: el bucle debe durar mientras "
            cont" sea menor que 10. Cuando esto sea falso se sale del bucle.
            3.- Decimos como varía la variable "cont"; podemos decir que incremente
            o que decremente
                cont = cont+1 a la izquierda es variable, a la derecha valor
                como se usa muchas veces:
                cont++: incrementativo, aumenta en 1
                cont--: decrementativo, decrementa en 1
            
                cont++: postincrementativo, primero hace la operación y luego incrementa
                ++cont: preincrementativo, primero incrementa y luego hace la operación
            */
            System.out.println("Iteración : " + (cont+1));
        /* cont+1 para que muestre realmente la iteración que sea, la primera
        no es 0, es 1. 
        hay dos signos +; en el primero es una concatenación (un string) 
        y el segundo es una suma porque tiene paréntesis, sino sería una
        concatenación. El operador + puede funcionar como concatenación y como
        suma en una misma linea.
        */
    }
}
