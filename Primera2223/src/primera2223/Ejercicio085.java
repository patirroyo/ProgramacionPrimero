/*
Separar las palabras de frase1 alternativametne en fraseA y en fraseB
 */
package primera2223;

public class Ejercicio085 {
     public static void main(String arg[]){
        String frase1 = "Había una vez un circo ";
        String fraseA = "";
        String fraseB = "";
        int posini = 0;
        int posfin = frase1.indexOf(" ");
        boolean enFA = true;
        
        while(posfin != -1){
            if(enFA){
                fraseA = fraseA.concat(frase1.substring(posini,posfin+1));
                enFA = false;
            }
            else{
                fraseB = fraseB.concat(frase1.substring(posini, posfin+1));
                enFA = true;
                
            }
            posini = posfin +1;
            posfin = frase1.indexOf(" ", posini);
        }
            
           
        System.out.println(fraseA);
        System.out.println(fraseB);
     }
}
    
