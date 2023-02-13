/*
implementar una función que sustituya las 'a' por 'X' */
package primera2223;


public class Ejercicio058 {
     public static void main(String arg[]){
        char frase[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ','M', 'a', 'n', 'c', 'h', 'a', ' '};
        cambiarAxX(frase);
        System.out.println(frase);
     }
     
     public static void cambiarAxX(char[] fr){
         for(int i = 0; i < fr.length; i++){
             if(fr[i] == 'a')
                fr[i] = 'X';
         }
               
    
    }
}
