/*
La instruccion switch o case, del tipo pregunta:
Es para preguntas con respuestas N araias, muchas respuestas; no es booleana no tiene si o no;
Convertir las vocales minúsuculas a mayúsculas y las vocales mayúsuclas a minúsculas de la frase.
 */
package primera2223;


public class Ejercicio071 {
    public static void main(String arg[]){
        char cadena[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'e', 'n', ' ', 'L', 'A', ' ','M', 'A', 'n', 'c', 'h', 'a', ' '};
        
        for(int i = 0; i < cadena.length; i++) //un bucle para recorrer carácter a carácter la cadena
            switch(cadena[i]){//esto no va a ser fruto de una comparación, va a ser el contenido de una variable
                case 'a': case 'e': case 'i': case 'o': case 'u'://es la manera de analizar cada caso
                    cadena[i] = Character.toUpperCase(cadena[i]);
                    break; //es una instrucción que rompe la instrucción en la que estemos, en este caso el switch, otro caso puede ser un bucle.
                case 'A': case 'E': case 'I': case 'O': case 'U':
                     cadena[i] = Character.toLowerCase(cadena[i]);
                     break;
                default: //en cualquier otro caso, el resto, es decir las consonantes y los espacios.
                     cadena[i] = '$';
            }
        System.out.println(cadena);
    }
}
        