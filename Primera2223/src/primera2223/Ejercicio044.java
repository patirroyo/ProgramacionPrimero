/*
Implementar una función a la que le pases un vector de enteros y
que te devuelva la posición en la que se encuentra el máximo valor.
 */
package primera2223;

public class Ejercicio044 {
    public static void main (String arg[]){
        int vector1[] = {24, 45, 65, 12, 7, 123, 16, 50};
        int vector2[] = {24, 45, 65, 12, 7, 3, 16, 50};
        int posMaximo1 = maximo(vector1);
        int posMaximo2 = maximo(vector2);
        System.out.printf("El máximo del vector es %d y está en la posición %d.\n", vector1[posMaximo1], posMaximo1);
        System.out.printf("El máximo del vector es %d y está en la posición %d.\n", vector2[posMaximo2], posMaximo2);
    }
    public static int maximo(int v[]){
        int posmax = 0;
        for(int i = 1; i < v.length; i++)
            if(v[i]>v[posmax])
                posmax = i;
        return posmax;
            
    }
    
}

    

