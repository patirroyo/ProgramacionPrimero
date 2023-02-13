/*
Sobre frase3, montar una frase que esté compuesta alternativamente
por una palabra de cada una de las frases anteriores.
A tener en cuenta, que si una frase termina, hay que escribir
el resto de las palabras de la otra.
 */
package primera2223;

public class Ejercicio081 {
     public static void main(String arg[]){
        String frase1 = "Había vez circo alegraba el ";
        String frase2 = "una un que siempre corazón sin temer jamás al frío o al calor ";
        String frase3 = "";
        
        
        int cont = 0;
        int posicion = frase1.indexOf(" ");
        while(posicion != -1){
                cont++;
                posicion = frase1.indexOf(" ", posicion + 1);
        }
        String vector1[] = new String[cont];
        
        cont = 0;
        posicion = frase2.indexOf(" ");
        while(posicion != -1){
                cont++;
                posicion = frase2.indexOf(" ", posicion + 1);
        }
        String vector2[] = new String[cont];
        
        int posini = 0;
        int posfin = frase1.indexOf(" ");
        int i = 0;
     
        while(posfin != -1){
            vector1[i] = frase1.substring(posini,posfin+1);
            posini = posfin+1;
            posfin = frase1.indexOf(' ', posini+1);
            i++;
            
        }
        posini = 0;
        posfin = frase2.indexOf(" ");
        i = 0;
     
        while(posfin != -1){
            vector2[i] = frase2.substring(posini,posfin+1);
            posini = posfin+1;
            posfin = frase2.indexOf(' ', posini+1);
            i++;
            
        }
        i = 0;
        int j = 0;
     
        while(i < vector1.length && j < vector2.length){
            frase3 = frase3.concat(vector1[i]);
            frase3 = frase3.concat(vector2[i]);
            i++;
            j++;
        }
        if(vector1.length>vector2.length)
            while(i<vector1.length){              
                frase3 = frase3.concat(vector1[i]);
                i++;
                        }
        else        
            while(j<vector2.length){
                frase3 = frase3.concat(vector2[j]);
                j++;
            }
        
        System.out.println(frase3);
     }
}
    
