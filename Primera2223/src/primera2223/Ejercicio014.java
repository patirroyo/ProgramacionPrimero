/*
 Declaración y manipulación de vectores
 
Hasta ahora conocemos la variable de tipo entero: x, pos, y...
Cuando tenemos muchas variables de numeros enteros, eso es un vector.
Cada uno de los elementos tiene una posición dentro del vector, es decir, 
ese vector tiene un índice: un vector de 10 elementos tiene 10 elementos,
el primero se sitúa en la posición 0 y luego en orden hasta 9.
Todos los elementos son del mismo tipo de datos, si es de enteros, en cada
elemento puedo meter un entero.
    int datos[] = {17 ,55, 33, 21, 88}
Para acceder a un elemento, nombramos al vector (elementos) y luego la
posición (1) entre []

elementos[1]

De esta manera declaramos un vector en lugar de 10 variables, lo nombramos
siempre en plural y las variables en singular; no dará error pero será una
mala práctica de programación
*/
package primera2223;

public class Ejercicio014 {
    public static void main(String arg []){
        int datos[] = {17 ,55, 33, 21, 88};
            for(int i = 0; i < datos.length; i++){
                /*nombrevector.length devuelve el número de elementos
                  en este caso 5
                */
                System.out.printf("datos [%d] = %d \n", i, datos[i]);
                               }
            System.out.println("Ahora los datos del vector * 2:");
                                
            for(int i = 0; i < datos.length; i++){
                datos[i] *= 2;
                System.out.printf("datos [%d] = %d \n", i, datos[i]);
                
                }
                
            
        
    }
    
}
