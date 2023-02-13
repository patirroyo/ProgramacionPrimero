/*
En cadena dos queremos la misma frase pero al reves.
 */
package primera2223;


public class Ejercicio065 {
    public static void main(String arg[]){
        char frase[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ','M', 'a', 'n', 'c', 'h', 'a', ' '};
        char []frase2 = new char[frase.length];
       
        inversion(frase, frase2);
        System.out.println(frase2);
       
        
    }
    
    public static void inversion(char[] fr, char[]frM){
        for(int i = 0, j = frM.length -1; i < fr.length; i++, j--)
            frM[j] = fr[i];
    }
}
 
