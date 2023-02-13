/*
Ordenar un vector por el método ordenación directa.
 */
package primera2223;

public class Ejercicio041 {
    public static void main(String arg[]){
        int vector[] = {25, 2, 73, 81, 16, 4, 33};
        /*primero buscamos el elemento más pequeño por la posición y lo inter
        cambiamos por la posición 0; hacemos lo mismo con el resto, el bucle 
        anidado cada vez recorrerá menos parte del vector*/
        int inter = 0;
        int posmin;
        for(int i = 0; i < vector.length - 1; i++){
            posmin = i;
            for(int j = i + 1; j < vector.length; j++){
               if(vector[j] < vector[posmin])
                    posmin = j;
            }
            inter = vector[i];
            vector[i] = vector[posmin];
            vector[posmin] = inter; 
        }
        for(int i = 0; i < vector.length; i++)
            System.out.printf("%d - ",vector[i]);
    }
 }
