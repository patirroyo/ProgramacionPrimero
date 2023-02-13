/*
sustituir todos los espacios en blanco por uno solo.
 */
package primera2223;

public class Ejercicio084b {
     public static void main(String arg[]){
        String frase1 = "Había    una vez,     un    circo que    alegraba siempre el    corazón ";
        //frase1 = frase1.replaceAll(" +", " ");
        boolean primero = true;//declaramos un valor booleano, puede ser true o false. y nos dirá si el espacio es el primero
     
        
        for(int i = 0; i < frase1.length(); i++)
            if(frase1.charAt(i) == ' '){
                if(primero){//lo que tiene que haber entre paréntesis ya tiene el valor true o false, no hace falta comparar. Si NO es el primero
                    primero = false;
                }else{
                    frase1 = frase1.substring(0,i).concat(frase1.substring(i+1));
                    i--;
                }
            }
            else
                primero = true;
            
           
        System.out.println(frase1);
     }
}
    
