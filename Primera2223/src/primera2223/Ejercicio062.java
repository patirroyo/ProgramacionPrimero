/*
 * Modificar la frase, transformando cada palabra de manera que el 
primer y último carácter de cada palabra se intercambie.
Encontrar pos inicio y pos final de cada palabra e intercambiar con un inter.
 */
package primera2223;


public class Ejercicio062 {
    public static void main(String arg[]){
        char frase[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ','M', 'a', 'n', 'c', 'h', 'a', ' '};
        char frase2[] = new char[frase.length];
        for(int i = 0; i < frase.length; i++)
            frase2[i] = frase[i];
        sustitucion(frase2);
        System.out.println(frase2);
        
        
    }
    
    public static void sustitucion(char[] fr){
        int posini = 0;
        int posfin;
        char inter;  
        for(int i = 0; i < fr.length; i++)
            if(fr[i] == ' '){
                posfin = i-1;
                inter = fr[posfin];
                fr[posfin] = fr[posini];
                fr[posini] = inter;
                posini = i +1;
                
                
            }
    }
}
    
   