/*
Ordenar un vector por el método de la burbuja.
 */
package primera2223;

public class Ejercicio040 {
    public static void main(String arg[]){
        int vector[] = {25, 2, 73, 81, 16, 4, 33};
        /*Lo representamos de manera vertical y vamos haciendo el que el número 
        que tenemos vaya subiendo;
        empezamos abajo y la comparamos con la anterior (vamos a ir decrementando9
        Miramos si es menor que el de arriba, si no lo es pasamos, si lo es se
        intercambia y luego pasamos al siguiente*/
        int inter = 0;
        for(int i = 0; i < vector.length - 1; i++){
            for(int j = vector.length - 1; j > i; j--)
                if(vector[j] < vector[j-1]){
                    inter = vector[j-1];
                    vector[j-1] = vector[j];
                    vector[j] = inter;
                }
        }
        for(int i = 0; i < vector.length; i++)
            System.out.printf("%d - ",vector[i]);
    
    }
            
    
}
