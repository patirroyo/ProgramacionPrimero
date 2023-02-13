/*
Desplazamientos consecutivos de los elementos de un vector.
Sacar por pantalla 6 lineas
Mover a la derecha un vector hasta que vuelva a quedar en la posición inicial
Es mejor hacer primero el detalle y luego meterlo dentro del buche principal.
 */
package primera2223;

/**
 *
 * @author alber
 */
public class Ejercicio023 {
     public static void main(String arg[]){
        int datos[] = {10, -20, 30, -40, 50, 60};
        for(int j = 0; j < datos.length; j++){
            int aux = datos[datos.length - 1];
            for(int i = datos.length - 1; i > 0; i--)
                datos[i] = datos [i - 1];
            datos[0] = aux;
            for(int i = 0; i < datos.length; i++){
                if(i < datos.length -1)
                    System.out.print(datos[i] + ", ");
                else
                    System.out.println(datos[i] + ". ");
            }
        }
     }
}
