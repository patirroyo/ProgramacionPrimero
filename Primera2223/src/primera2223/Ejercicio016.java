/*
Mostrar el valor máximo de un vector y su posición
Mostrar el valor mínimo de un vector y su posición
*/
package primera2223;

public class Ejercicio016 {
    public static void main(String arg[]){
        int datos[] = {-17, -55, -33, -11, -88};
        int posmax = 0;
        int posmin = 0;
        for(int i = 1; i < datos.length; i++){
            if(datos[i] > datos[posmax])
                 posmax = i;
            if(datos[i] < datos[posmin])
                 posmin = i;     
        }
    System.out.printf("El número mayor es %d y está en la posición %d. \nEl número menor es %d y está en la posición %d \n", datos[posmax], posmax, datos[posmin], posmin);
    }
}
   
