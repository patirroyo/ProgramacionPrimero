/*
Vamos a quitar los espacios en blanco; funcion index of y concat
 */
package primera2223;

public class Ejercicio079 {
     public static void main(String arg[]){
        String frase = "Había una vez, un circo, que alegraba siempre el corazón";
        String frase2 = frase;
        int posicion = frase.indexOf(" ");//buscamos el espacio en blanco
        
        while(posicion != -1){
            frase2 = frase2.substring(0, posicion).concat(frase2.substring(posicion+1));//concatenamos el primer substring con el siguiente obviando el espacio
            posicion = frase2.indexOf(" ");//el siguiente espacio que busque desde donde acabamos de pegar
        }
        
        
        System.out.println(frase);
        System.out.println(frase2);

        
        
        
     }
}
    
