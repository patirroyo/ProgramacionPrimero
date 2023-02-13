/*
Modificar la frase, transformando cada palabra de más de dos carácteres de manera que desplacemos todos
los caracteres a la derecha y el último a la primera posición.
Además invertiremos todas las palabras.
 */
package primera2223;


public class Ejercicio063b1 {
    public static void main(String arg[]){
        char frase[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ','M', 'a', 'n', 'c', 'h', 'a', ' '};
        int inicio = 0, fin = 0;
        while(inicio < frase.length){
            while(frase[fin] != ' ')
                fin++;
            desplazarD(frase, fin, inicio);//boton derecho > refactor > introduce > method...
            invertir(frase, fin, inicio);
            inicio = fin = fin +1;
        }
         System.out.println(frase);  
         
    
    }

    public static void desplazarD(char[] frase, int fin, int inicio) {
        char intercambio;
        if(fin-inicio>2){
            intercambio = frase[fin-1];
            for(int j = fin-1; j > inicio; j--)
                frase[j] = frase[j-1];
            frase[inicio] = intercambio;
        }
    }
    
    public static void invertir(char[] frase, int fin, int inicio){
        char intercambio;
        for(int i = inicio, j = fin-1; i < j ; i++, j--){
            intercambio = frase[i];
            frase[i] = frase[j];
            frase[j] = intercambio;
            
        }
    }
}
    
   