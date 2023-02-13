/*
Primer bucle anidado.
 */
package primera2223;

public class Ejercicio022 {
    public static void main(String arg[]){
        for(int i = 0; i < 5; i++){
            System.out.println("Fila: " + i);
            for (int j = 0; j < 5; j++)//Bucle anidado
                System.out.println("Fila: " + i + " Columna: " + j);
        }
    }
    
}
