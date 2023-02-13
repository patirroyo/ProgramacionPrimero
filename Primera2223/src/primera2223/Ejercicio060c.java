/*
 * Implementar una función que sustituya el caracter "sustituir" por la cadena
de caracteres sustituto en la misma frase
 */
package primera2223;


public class Ejercicio060c {
    public static void main(String arg[]){
        char frase[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ','M', 'a', 'n', 'c', 'h', 'a', ' '};
        char sustituir = 'n';
        char sustituto[] = {'X', 'Y', 'Z', 'a', 'b'};
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
                fr[i] = sustituto[0];
                for(int j = 1; j < sustituto.length; j++){
                    for(int z = (fr.length-1); z > (i + 1); z--)
                        fr[z] = fr[z-1];
                    i++;
                    fr[i] = sustituto[j];
                }
            }
    }
}
