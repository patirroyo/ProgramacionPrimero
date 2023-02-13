/*
Modificar la frase para que pase sus carácteres a mayúsculas.
Usar la función Character.toUpperCase()
 */
package primera2223;


public class Ejercicio057 {
    public static void main(String arg[]){
        char frase[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ','M', 'a', 'n', 'c', 'h', 'a', ' '};  //char tipo de dato: un solo carácter del tipo ASCII
        modificarFrase(frase);
        System.out.println(frase);
       /* for(int i = 0; i < frase.length; i++)
            System.out.printf("%S",frase[i]);
        Así no modifico la frase pero si la muestro por pantalla con mayúsculas, al poner la S con mayúsculas en el printf*/
    }
        
    public static void modificarFrase(char[] fr){
        for(int i = 0; i < fr.length; i++){
            fr[i] = Character.toUpperCase(fr[i]);
               
        } 
    }
   
    
}
