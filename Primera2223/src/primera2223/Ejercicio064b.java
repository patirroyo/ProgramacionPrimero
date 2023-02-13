/*
Sustituir un caracter por una subcadena y hacerlo utilizando una nueva cadena
de caracteres.
 */
package primera2223;


public class Ejercicio064b {
    public static void main(String arg[]){
        char frase[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ','M', 'a', 'n', 'c', 'h', 'a', ' '};
        char caracter = 'a';
        char subCadena[] = {'A', 'B', 'C', 'D', 'E'};
        int cont = 0;
        for(int i = 0; i < frase.length; i++)
            if (frase[i] == caracter)
                cont++;
        char []frase2 = new char[frase.length+cont*(subCadena.length-1)];
        for(int i = 0; i < frase.length; i++)
            frase2[i] = frase[i];
        
        sustitucion(frase2, caracter, subCadena);
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
