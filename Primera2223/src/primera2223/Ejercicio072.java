/*
Trabajamos con la clase String.
la diferencia entre clase y tipo de dato es que en una clase hay atributos y métodos 
y en un dato no hay más que el dato.
 */
package primera2223;

/**
 *
 * @author alber
 */
public class Ejercicio072 {
    public static void main(String arg[]){
        String frase = "En un lugar de la Mancha, de cuyo nombre no quiero acordarme"; 
        /*ya no es una variable, es un objeto "En un lugar...", de una clase "String"
        Un objeto (variable de tipo puntero) apunta a una dirección de memoria o a null (si no apunta a ningún lado), a la dirección de memoria del
        primer elemento. Frase apunta a la dirección de memoria donde se encuentra "E"
        */
        char[] cadena = new char[frase.length()]; //declaramos un objeto de la clase char
        for(int i = 0; i < frase.length() ; i++)
            System.out.printf("%c-",frase.charAt(i));//nos devuelve el caracter que está en la posición i
        
        System.out.println();
        for(int i = 0; i < frase.length(); i++)
            cadena[i] = frase.charAt(i);
        System.out.println(cadena);
        
    }
    
}
