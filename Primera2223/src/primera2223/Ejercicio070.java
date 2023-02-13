/*
poner en mayúsculas la primera y última letra de cada palabra.
 */
package primera2223;


public class Ejercicio070 {
    public static void main(String arg[]){
        char frase[] = {'e', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'e', 'n', ' ', 'd', 'e', ' ', 'L', 'a', ' ','M', 'a', 'n', 'c', 'h', 'a', ' '};
        int posini = 0;
        int posfin = 0;
        
        while(posfin < frase.length)
            if(frase[posfin] != ' ')
                posfin++;
            else{
                frase[posini] = Character.toUpperCase(frase[posini]);
                frase[posfin-1] = Character.toUpperCase(frase[posfin-1]);
                posini = posfin += 1;
        }
        System.out.println(frase);
    }
}
        