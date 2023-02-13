/*
Eliminar un caracter de una cadena en la misma cadena y desplazar todos lo carácteres a la izquierda.
 */
package primera2223;


public class Ejercicio068 {
    public static void main(String arg[]){
        char frase[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ','M', 'a', 'n', 'c', 'h', 'a'};
        char caracter = 'n';
        for(int i = 0; i < frase.length; i++)
            if(frase[i] == caracter)
                for(int i2 = i; i2 < frase.length-1; i2++){
                    frase[i2] = frase[i2+1];
                    frase[i2+1] = ' ';
                }
        System.out.println(frase);
        }
    
    
}
        