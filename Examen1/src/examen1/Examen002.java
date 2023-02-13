/*
Sin crear ninguna función y sobre la misma cadena de caracteres “frase2”, añadir una ‘A’ al final de cada palabra.

 */
package examen1;


public class Examen002 {
    public static void main(String arg[]){
        char frase2[] = new char[50];
        char frase[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a', ' '}; 
            for(int i=0; i < frase.length; i++)
                frase2[i] = frase[i];
        for(int i = 0; i < frase2.length; i++){//creo un bucle que recorra toda la frase
            if(frase2[i] == ' '){//cuando encuentra un espacio
                frase2[i] = 'A';//sustituyo el espacio por la letra 'A'
                for(int j = frase2.length -1; j > i; j--)//creo otro bucle para mover todos los carácteres una posición a la derecha
                    frase2[j] = frase2[j-1];
                frase2[i+1] = ' ';//recupero el espacio que antes he llenado con la A, una posicón a la derecha del espacio
                i++;//al añadir un carácter más aumento i para que no vuelva a encontrar espacio y evitar el error.
            
        }
         
        }
        System.out.println(frase2);
    } 
}
