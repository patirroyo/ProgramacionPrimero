/*
Eliminar una subcadena de una cadena en la misma cadena y desplazar todos lo carácteres a la izquierda.
 */
package primera2223;


public class Ejercicio069 {
    public static void main(String arg[]){
        char frase[] = {' ','e', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'e', 'n', ' ', 'd', 'e', ' ', 'L', 'a', ' ','M', 'a', 'n', 'c', 'h', 'a'};
        char cadena[] = {'e', 'n', ' '};
        int cont;
        for(int i = 0; i < frase.length; i++){
            cont = 0;
            while(cont < cadena.length && frase[i+cont] == cadena[cont])
                cont++;
            if(cont == cadena.length)
                for(int i2 = i; i2 < frase.length-cadena.length; i2++){
                    frase[i2] = frase[i2+cadena.length];
                    frase[i2+cadena.length] = ' ';
                }
        }
        System.out.println(frase);
    }   
}
        