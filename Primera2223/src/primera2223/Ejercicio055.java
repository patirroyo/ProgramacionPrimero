/*
Implementar una fucnión que devuelva el número de palabras de una frase.
 */
package primera2223;


public class Ejercicio055 {
    public static void main(String arg[]){
        char frase[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ','M', 'a', 'n', 'c', 'h', 'a'};  //char tipo de dato: un solo carácter del tipo ASCII
        System.out.println("La frase tiene " + contarPalabras(frase) + " palabras.");
    }
        
    public static int contarPalabras(char[] fr){
        int cont = 0;
        for(int i = 0; i < fr.length; i++)
            if(fr[i] == ' ')
                cont++;
        return cont+1;//número de palabras es igual al número de espacios más uno.
    }
    
}
