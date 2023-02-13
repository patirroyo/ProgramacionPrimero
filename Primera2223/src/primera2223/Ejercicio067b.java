/*
Meter en frase2 la misma frase, pero con las palabras en sentido inverso
mancha la en lugar un en
 */
package primera2223;


public class Ejercicio067b {
    public static void main(String arg[]){
        char frase[] = {' ','e', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'e', 'n', ' ', 'L', 'a', ' ','M', 'a', 'n', 'c', 'h', 'a',' '};
        char []frase2 = new char[150];
        int posini = frase.length - 1, posfin = frase.length - 1, i2 = 0;
        while(posini > 0){
            while(frase[posini] != ' ')
                posini--;
            for(int i = posini; i <= posfin; i++, i2++)
                frase2[i2] = frase[i];
            posini = posfin = posini -1;
        }
                    
       
           
        System.out.println(frase2);
    }
}
 
