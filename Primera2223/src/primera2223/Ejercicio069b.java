/*
Eliminar una subcadena de una cadena en la misma cadena y desplazar todos lo carácteres a la izquierda.
 */
package primera2223;


public class Ejercicio069b {
    public static void main(String arg[]){
        char frase[] = {' ','e', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'e', 'n', ' ', 'd', 'e', ' ', 'L', 'a', ' ','M', 'a', 'n', 'c', 'h', 'a'};
        char cadena[] = {'e', 'n', ' '};
        int j;
        for(int i = 0; i < frase.length; i++)
            if(frase[i] == cadena [0]){
                j = 1;
            while((j < cadena.length) && (cadena[j] == frase[i+j]))
                j++;
            if(j == cadena.length)
                for(int z = 1; z <= cadena.length; z++){
                    for (int x = (i+j-z); x < frase.length; x++)
                        frase[x-1] = frase[x];
                    frase[frase.length - z] = ' ';
                }
                   
                
        
        
            
        }
        System.out.println(frase);
    }   
}
    
        