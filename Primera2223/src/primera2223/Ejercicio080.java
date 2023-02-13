/*
Tenemos una frase formada por palabras separadas por un espacio en blanco
Meter cada palabra en un vector y luego mostrar por pantalla.
 */
package primera2223;

public class Ejercicio080 {
     public static void main(String arg[]){
        String frase = "5Cinco 6Seis 2Dos 4Cuatro 1Uno 3Tres ";
     
        int cont = 0;
        for(int i = 0; i < frase.length(); i++)
            if(frase.charAt(i) == ' ')
                cont++;
        String vector[] = new String[cont];
        
        int posini = 0;
        int posfin = frase.indexOf(" ");
        cont = 0;
     
        while(cont < vector.length && posfin != -1){
            vector[cont] = frase.substring(posini,posfin+1);
            posini = posfin+1;
            posfin = frase.indexOf(' ', posini);
            
            cont++;
            
        }
        
        String inter;
        for(int i = 0; i < vector.length - 1; i++){
            for(int j = vector.length - 1; j > i; j--)
                if(vector[j].compareTo(vector[j-1])< 0){
                    inter = vector[j-1];
                    vector[j-1] = vector[j];
                    vector[j] = inter;
                }
        }
        frase = "";
        
        for(int i = 0; i < vector.length; i++)
            frase = frase.concat(vector[i]);
        
        System.out.println(frase);
        
       
        
        
        
     }
}
    
