/*
 Calcular el factorial de un número
5!=
 */
package primera2223;

/**
 *
 * @author alber
 */
public class Ejercicio010 {
   public static void main(String arg[]){
       int numero = 6;
       int acumulador = 1;   //inicializar la variable, darle un valor inicial
       for(int cont = 1; cont <= numero; cont++){//al declarar la variable dentro del bucle, cuando salimos desaparece; es local al for
           //acumulador = acumulador * cont; dos operaciones, primero multiplicación y luego asignación
           acumulador *= cont; 
           /*es un operador que es el acumulador de la multiplicación
           hay más: +=, -=, *=, /=
           */
       }
       System.out.println("El factorial de " + numero + " es " + acumulador);
      
       //int acumulador, una variable no se puede declarar dos veces, pero si la podemos usar dos veces
       acumulador = 1;
       for(int cont = numero; cont >= 1; cont--)
           acumulador *= cont;
       System.out.println("El factorial de " + numero + " es " + acumulador);
       }
           
       }
      
           

