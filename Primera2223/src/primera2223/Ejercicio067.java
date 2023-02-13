/*
Meter en frase2 la misma frase, pero con las palabras en sentido inverso
mancha la en lugar un en
 */
package primera2223;


public class Ejercicio067 {
    public static void main(String arg[]){
        char frase[] = {' ','e', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'e', 'n', ' ', 'L', 'a', ' ','M', 'a', 'n', 'c', 'h', 'a',' '};
        char []frase2 = new char[frase.length-1];
        int posini, posfin = frase.length-1;
        for(int i = frase.length - 1, j = 0; i >= 0; i--)
            if(frase[i] == ' '){
                posini = i + 1;
                for(int z = posini; z <= posfin; z++, j++)
                    frase2[j] = frase[z];
                posfin = i;
            }
        System.out.println(frase2);
    }
}
 
