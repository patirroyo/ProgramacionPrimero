/*
 * Modificar la frase, transformando cada palabra de manera que desplacemos todos
los caracteres a la derecha y el último a la primera posición.
Encontrar pos inicio y pos final de cada palabra e intercambiar con un inter.
 */
package primera2223;


public class Ejercicio063 {
    public static void main(String arg[]){
        char frase[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ','M', 'a', 'n', 'c', 'h', 'a', ' '};
        int inicio = 0, fin = 0, fin2 = 0;
        while(inicio < frase.length){
            while(frase[fin] != ' ')
                fin++;
            fin2 = fin;
            while(fin2 > inicio){
                frase[fin2] = frase[fin2-1];
                fin2--;
            }
            frase[inicio] = frase[fin];
            frase[fin] = ' ';
            inicio = fin = fin +1;
        }
         System.out.println(frase);   
    }
}
    
   