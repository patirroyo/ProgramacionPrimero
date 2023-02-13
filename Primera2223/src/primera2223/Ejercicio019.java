/*
Calcular la media de los elemntos del vector y mostrar por pantalla
 */
package primera2223;

public class Ejercicio019 {
    public static void main(String arg[]){
        int datos[] = {10, -20, 30, -40, 50, 60};
        int acum = datos [0];
        for(int i = 1; i < datos.length; i++){
            acum += datos[i];
        }
        System.out.printf("La media del los datos del vector es %d \n", (acum / datos.length));
        
    }
}
    
