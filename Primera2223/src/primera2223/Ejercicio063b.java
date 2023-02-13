/*
 * Modificar la frase, transformando cada palabra de manera que desplacemos todos
los caracteres a la derecha y el último a la primera posición.
Encontrar pos inicio y pos final de cada palabra e intercambiar con un inter.
 */
package primera2223;


public class Ejercicio063b {
    public static void main(String arg[]){
        char frase[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ','M', 'a', 'n', 'c', 'h', 'a', ' '};
        int inicio = 0, fin = 0;
        while(inicio < frase.length){
            while(frase[fin] != ' ')
                fin++;
            desplazarI(frase, fin, inicio);//boton derecho > refactor > introduce > method...
            inicio = fin = fin +1;
        }
         System.out.println(frase);  
         
    }

    public static void desplazarI(char[] frase, int fin, int inicio) {
        char intercambio;
        intercambio = frase[inicio];
        for(int j = inicio; j < fin-1; j++)
            frase[j] = frase[j+1];
        frase[fin-1] = intercambio;
    }

    public static void desplazarD(char[] frase, int fin, int inicio) {
        char intercambio;
        intercambio = frase[fin-1];
        for(int j = fin-1; j > inicio; j--)
            frase[j] = frase[j-1];
        frase[inicio] = intercambio;
    }
}
    
   