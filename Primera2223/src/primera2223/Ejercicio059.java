/*
 * Implementar una función que sustituya el caracter "sustituir" por la cadena
de caracteres sustituto en un char[] nuevo.
 */
package primera2223;


public class Ejercicio059 {
    public static void main(String arg[]){
        char frase[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ','M', 'a', 'n', 'c', 'h', 'a', ' '};
        char sustituir = 'n';
        char sustituto[] = {'X', 'Y', 'Z'};
        System.out.println(sustitucion(frase, sustituir, sustituto));
        
    }
    
    public static char[] sustitucion(char[] fr, char sustituir, char[]sustituto){
        char frM[] = new char[100];
        for(int i1 = 0, i2 = 0; i1 < fr.length; i1++,i2++){
            if(fr[i1] == sustituir)
                for(int j = 0; j < sustituto.length; j++){
                frM[i2] = sustituto[j];
                i2++;
                }
            else
                frM[i2] = fr[i1];
        }
        return frM;
    }
}
