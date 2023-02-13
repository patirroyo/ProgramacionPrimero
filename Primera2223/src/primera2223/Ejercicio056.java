/*
Implementar una fucnión que devuelva otra frase en la que cada palabra
termine en 'X'
 */
package primera2223;


public class Ejercicio056 {
    public static void main(String arg[]){
        char frase[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ','M', 'a', 'n', 'c', 'h', 'a', ' '};  //char tipo de dato: un solo carácter del tipo ASCII
        char fraseMod[] = new char[50];
        modificarFrase(frase, fraseMod);
        System.out.println(fraseMod);
        System.out.printf("%c",modificarFrase(frase));
    }
        
    public static void modificarFrase(char[] fr,char[] frM){
        for(int i = 0, i2 = 0; i < fr.length; i++, i2++){//declaro dos contadores
            if(fr[i] == ' '){
                frM[i2] = 'X';
                i2++;
            }
            frM[i2] = fr[i];    
        } 
    }
    public static char[] modificarFrase(char[] fr){
        char[] frM = new char[50];
        for(int i = 0, i2 = 0; i < fr.length; i++, i2++){//declaro dos contadores
            if(fr[i] == ' '){
                frM[i2] = 'X';
                i2++;       
            }
            frM[i2] = fr[i];    
        } 
        return frM;
    }
}
