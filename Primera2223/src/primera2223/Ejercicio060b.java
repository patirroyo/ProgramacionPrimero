/*
 * Implementar una función que sustituya el caracter "sustituir" por la cadena
de caracteres sustituto en la misma frase
 */
package primera2223;


public class Ejercicio060b {
    public static void main(String arg[]){
        char frase[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ','M', 'a', 'n', 'c', 'h', 'a', ' '};
        char sustituir = 'n';
        char sustituto[] = {'X', 'Y', 'Z'};
        int cont = 0;
        for(int i = 0; i < frase.length; i++)//creo este bucle para instanciar frase2 con la longitud justa
            if (frase[i] == sustituir)
                cont++;
        char []frase2 = new char[frase.length+cont*(sustituto.length-1)];
        for(int i = 0; i < frase.length; i++)
            frase2[i] = frase[i];
        sustitucion(frase2, sustituir, sustituto);
        System.out.println(frase2);
       
        
    }
    
    public static void sustitucion(char[] fr, char sustituir, char[]sustituto){
        for(int i = 0; i < fr.length; i++)
            if(fr[i] == sustituir){
                for(int j = fr.length-1; j > (i+sustituto.length-1); j--)
                    fr[j]=fr[j-sustituto.length+1];
                for(int i2 = 0; i2 < sustituto.length;i2++)
                    fr[i+i2] = sustituto[i2];
            }
    }
}
