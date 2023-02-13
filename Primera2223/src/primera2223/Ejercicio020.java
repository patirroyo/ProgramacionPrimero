/*
 Desplazar todos los números una posición hacia la izquierda de un vector y 
el primero al final.
 */
package primera2223;

public class Ejercicio020 {
    public static void main(String arg[]){
        int datos[] = {10, -20, 30, -40, 50, 60};
        int aux = datos[0];
        for(int i = 1; i < datos.length; i++)
            datos[i - 1] = datos [i];
        datos[datos.length - 1] = aux;
        for(int i = 0; i < datos.length; i++)
            if(i < datos.length -1)
                System.out.print(datos[i] + ", ");
            else
                System.out.println(datos[i] + ". ");
    }
    
}
