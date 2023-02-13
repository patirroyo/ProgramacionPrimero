/*
Sobre frase3, montar una frase que esté compuesta alternativamente
por una palabra de cada una de las frases anteriores.
A tener en cuenta, que si una frase termina, hay que escribir
el resto de las palabras de la otra.
 */
package primera2223;

public class Ejercicio081b {
     public static void main(String arg[]){
        String frase1 = "Había vez circo alegraba el ";
        String frase2 = "una un que siempre corazón sin temer jamás al frío o al calor ";
        String frase3 = "";
        int inicioF1 = 0;
        int finF1 = frase1.indexOf(" ");
        int inicioF2 = 0;
        int finF2 = frase2.indexOf(" ");
        
        
     
        while((finF1 != -1) || (finF2 != -1)){
            if(finF1 != -1){
                frase3 = frase3.concat(frase1.substring(inicioF1, finF1+1));
                inicioF1 = finF1 +1;
                finF1 = frase1.indexOf(" ", inicioF1);
            }
            if(finF2 != -1){
                frase3 = frase3.concat(frase2.substring(inicioF2, finF2+1));
                inicioF2 = finF2 + 1;
                finF2 = frase2.indexOf(" ", inicioF2);
            }
        }
        System.out.println(frase3);
     }
}
    
