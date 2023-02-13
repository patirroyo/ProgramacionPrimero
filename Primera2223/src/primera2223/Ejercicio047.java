/*
Dado un vector unidimensional de enteros
crear un método "ordenar()" que lo ordene
 */
package primera2223;

public class Ejercicio047 {
    public static void main(String arg[]){
    int vector[] = {25, 2, 73, 81, 16, 4, 33};  
    ordenar(vector);//llamo a la función ordenar y le entrego el vector
    for(int i = 0; i < vector.length; i++)
            System.out.printf("%d - ",vector[i]);
    
    }
    public static void ordenar(int v[]){//he copidado el método de la burbuja y nombro el vector como v (para hacerlo diferente al otro, pero le puedo dar el nombre que me de la gana)
        int inter = 0;
        for(int i = 0; i < v.length - 1; i++){
            for(int j = v.length - 1; j > i; j--)
                if(v[j] < v[j-1]){
                    inter = v[j-1];
                    v[j-1] = v[j];
                    v[j] = inter;
                }
        }
    }
}
