/*
Dada una cadena de caracteres cuyas palabras están separadas por un espacio en blanco
cambiar a mayúsculas las palabras cuya longitud sea mayor a 3;
-Hacerlo sobre la propia cadena.
-Hacerlo sobre una nueva cadena.
 */

package primera2223;
    
public class Ejercicio095 {
    public static void main(String arg[]){
        char frase[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ','M', 'a', 'n', 'c', 'h', 'a', ' '}; 
        int posini = 0;
        int posfin = 0;
        char frase2[] = new char[frase.length];
        
        for(int i = 0; i < frase.length; i++){
            frase2[i]=frase[i];
            if(frase[i] == ' '){
                posfin = i;
                if(posfin - posini > 3)
                    while(posini < posfin){
                        frase2[posini] = Character.toUpperCase(frase[posini]);
                        posini++;
                    }
                posini = posfin = posfin +1;
            }
        }     
        System.out.println(frase2);
        
        posini = 0;
  
        
        for(int i = 0; i < frase.length; i++){
            if(frase[i] == ' '){
                posfin = i;
                if(posfin - posini > 3)
                    while(posini < posfin){
                        frase[posini] = Character.toUpperCase(frase[posini]);
                        posini++;
                    }
                    
                posini = posfin = posfin +1;
            }
        
        }
        System.out.println(frase);
    }
}


