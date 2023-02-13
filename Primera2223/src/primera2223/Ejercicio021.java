/*
 Desplazar todos los números una posición hacia la derecha de un vector y 
el último a la primera posición.
 */
package primera2223;

public class Ejercicio021 {
    public static void main(String arg[]){
        int datos[] = {10, -20, 30, -40, 50, 60};
        int aux = datos[datos.length - 1];
        for(int i = datos.length - 1; i > 0; i--)
            datos[i] = datos [i - 1];
        datos[0] = aux;
        for(int i = 0; i < datos.length; i++)
            if(i < datos.length -1)
                System.out.print(datos[i] + ", ");
            else
                System.out.println(datos[i] + ". ");
    }
    
}
