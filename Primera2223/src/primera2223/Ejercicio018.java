/*
Modificar el contenido de un vector, pasando los valores negativos a positivos
y multiplicando por 2 los positivos.
 */
package primera2223;

public class Ejercicio018 {
     public static void main(String arg[]){
        int datos[] = {10, -20, 30, -40, 50, 60};
        for(int i = 0; i < datos.length; i++){
             if(datos[i] < 0)
                datos[i] *= -1;
            else
                datos [i] *= 2;
        }
        for(int i = 0; i < datos.length; i++)
            if(i < datos.length -1)
                System.out.printf("%d, ", datos[i]);
            else
                System.out.println(datos[i] + ". ");
     }
    
}
