/*
 * Modificar la frase, transformando cada palabra de manera que el 
primer y último carácter de cada palabra se intercambie.
Encontrar pos inicio y pos final de cada palabra e intercambiar con un inter.
 */
package primera2223;


public class Ejercicio062b {
    public static void main(String arg[]){
        char frase[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ','M', 'a', 'n', 'c', 'h', 'a', ' '};
       int inicio = 0, fin = 0;
       char intercambio;
       while(inicio < frase.length){
            while(frase[fin] != ' ')
                fin++;
            intercambio = frase[inicio];
            frase[inicio] = frase[fin-1];
            frase[fin-1] = intercambio;

            inicio = fin = fin + 1;//las dos lineas se pueden poner en una sola inicio = fin + 1 y fin = fin +1
            
       }
       System.out.println(frase);
    }
}
    
   