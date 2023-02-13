/*
 Mostrar por pantalla el mayor de dos números
 */
package primera2223;

/**
 *
 * @author alber
 */
public class Ejercicio002 {
    public static void main(String arg[]){
       int x, y; //puedo declarar dos variables del mismo tipo, separadas por coma
       x = 650;
       y = 440;
       if(x > y){
           /*ponemos valor booleano; cierto o falso, o condicion, respuesta binaria
           operadores: < menor, > mayor, <= menor o igual,
           >= mayor o igual, == igual, != distinto, ! negación
           
           nos va a devolver cierto o falso, nos va a devolver un "true"
           */ 
           System.out.println("El mayor es; " + x);//muestra en pantalla y hace retorno de carro, pasa de linea
           System.out.println("El mayor es; " + x);
       }else//si la condición es falsa, si y es <= x 
            /*lo rojo es un error de compilación, le falta un if o poner llaves
           Para el finde: hacer comparación de dos números, decir cual es el mayor y si son dos igual que lo diga*/
           System.out.println("El mayor es; " + y);
    }
    
}
