/*
Método de Ordenaciones parciales
Si solo miramos un elemento, éste está ordenado.
Luego miramos dos elementos, si el de la izquierda es menor lo cambiamos y 
ya estará ordenado; luego tres elementos y comparamos con el cuarto...
Si es más pequeño hacemos los intercambio, si no lo es pasamos, pues el resto
va a ser más pequeño.
 */
package primera2223;


public class Ejercicio042 {
    public static void main(String arg[]){
        int vector[] = {25, 2, 73, 81, 16, 4, 33};
        for(int i = 1; i < vector.length; i++){
            int x;
            int inter;
          // quito el if, porque no es necesario if(vector[i] < vector[i-1]){
                x = i;
                inter = 0;
                while((x > 0) && (vector[x] < vector[x-1])){ 
               /*mientras que el numero anterior sea O(||) Y(&&)
               en el bucle con && ponemos la condicion más restrictiva,
               en este caso para que no nos de una excepción al mirar el 
               vector de 0-1*/
                   inter = vector[x-1];
                   vector[x-1] = vector[x];
                   vector[x] = inter;
                   x--;
                }
           // de quitar el if }
        } 
        for(int i = 0; i < vector.length; i++)
            System.out.printf("%d - ",vector[i]);                  
}
    
}
