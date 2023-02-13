/*
Tenemos una frase formada por palabras separadas por un espacio en blanco
Meter cada palabra en un vector y luego mostrar por pantalla.
 */
package primera2223;

public class Ejercicio080b {
     public static void main(String arg[]){
        String frase = "5Cinco 6Seis 2Dos 4Cuatro 1Uno 3Tres ";
        String vector[];
     
        int cont = 0;
        int posicion = frase.indexOf(" ");
        while(posicion != -1){
                cont++;
                posicion = frase.indexOf(" ", posicion + 1);
        }
        
        vector = new String[cont];
        
        int posini = 0;
        int posfin = frase.indexOf(" ");
        int i = 0;
     
        while(posfin != -1){
            vector[i] = frase.substring(posini,posfin+1);
            posini = posfin+1;
            posfin = frase.indexOf(' ', posini+1);
            i++;
            
        }
        
        String inter;
        for(i = 0; i < vector.length - 1; i++){
            for(int j = vector.length - 1; j > i; j--)
                if(vector[j].compareTo(vector[j-1])< 0){
                    inter = vector[j-1];
                    vector[j-1] = vector[j];
                    vector[j] = inter;
                }
        }
        frase = "";
        
        for(i = 0; i < vector.length; i++)
            frase = frase.concat(vector[i]);
        
        System.out.println(frase);
        
       
        
        
        
     }
}
    
