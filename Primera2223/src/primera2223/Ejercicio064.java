/*
Sustituir un caracter por una subcadena y hacerlo utilizando una nueva cadena
de caracteres.
 */
package primera2223;


public class Ejercicio064 {
    public static void main(String arg[]){
        char frase[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ','M', 'a', 'n', 'c', 'h', 'a', ' '};
        char caracter = 'a';
        char subCadena[] = {'A', 'B', 'C', 'D', 'E'};
        //int cont = 0;
        //for(int i = 0; i < frase.length; i++)
            //if (frase[i] == caracter)
              //  cont++;
        char []frase2 = new char[150];
        for(int i = 0, j = 0; i < frase.length; i++, j++)
            if(frase[i] != caracter)
                frase2[j] = frase[i];
            else{
                for(int z = 0; z < subCadena.length; z++, j++)
                    frase2[j] = subCadena[z];
                j--;
            }
        
        System.out.println(frase2);
                    
                
        
                
                
    }
}
