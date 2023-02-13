/*
Escribir en cadena2 la frase pero sustituyendo las oruccrencias de
subcad1, por el contenido de subcad2
 */
package primera2223;


public class Ejercicio066b {
    public static void main(String arg[]){
        char frase[] = {'e', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'e', 'n', ' ', 'L', 'a', ' ','M', 'a', 'n', 'c', 'h', 'a', ' '};
        char subcad1[] = {'e','n',' '};
        char subcad2[] = {'X','X','X','X','X'};
        
        char []frase2 = new char[150];
        int j;
        for(int i = 0, z = 0; i < frase.length; i++, z++){
            if(frase[i] == subcad1[0]){
                j = 1;
                while(j < subcad1.length && frase[i+j] == subcad1[j]){
                     j++;
                    for(int k = 0; k < subcad2.length; k++, z++)
                        frase2[z]= subcad2[k];
                    i += (subcad1.length - 1);
                }
            }
            else
                frase2[z] = frase[i];
        }
        System.out.println(frase2);
    }
}
 
