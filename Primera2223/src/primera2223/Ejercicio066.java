/*
Escribir en cadena2 la frase pero sustituyendo las oruccrencias de
subcad1, por el contenido de subcad2
 */
package primera2223;


public class Ejercicio066 {
    public static void main(String arg[]){
        char frase[] = {'e', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'e', 'n', ' ', 'L', 'a', ' ','M', 'a', 'n', 'c', 'h', 'a', ' '};
        char subcad1[] = {'e','n',' '};
        char subcad2[] = {'X','X','X','X','X'};
        
        char []frase2 = new char[150];
        int contador;
        for(int i = 0, j = 0; i < frase.length; i++, j++){
            contador = 0;
            while(contador<subcad1.length && frase[i+contador] == subcad1[contador])
                contador++;
            if(contador == subcad1.length){
                for(int z = 0; z<subcad2.length; z++, j++)
                    frase2[j]= subcad2[z];
                i += subcad1.length -1;
            }
            else
                frase2[j] = frase[i];
         }
        System.out.println(frase2);
    }
}
 
