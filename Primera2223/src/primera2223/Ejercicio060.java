/*
 * Implementar una función que sustituya el caracter "sustituir" por la cadena
de caracteres sustituto en la misma frase
 */
package primera2223;


public class Ejercicio060 {
    public static void main(String arg[]){
        char frase[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ','M', 'a', 'n', 'c', 'h', 'a', ' '};
        char sustituir = 'n';
        char sustituto[] = {'X', 'Y', 'Z'};
        char frase2[] = new char[100];
        for(int i = 0; i < frase.length; i++)
            frase2[i] = frase[i];
        sustitucion(frase2, sustituir, sustituto);
        System.out.println(frase2);
        System.out.println(sustitucion2(frase,sustituir,sustituto));
        
    }
    
    public static void sustitucion(char[] fr, char sustituir, char[]sustituto){
        for(int i = 0; i < fr.length - sustituto.length+1; i++)
            if(fr[i] == sustituir){
                for(int j = fr.length - 1; j > (i+sustituto.length-1); j--)
                    fr[j]=fr[j-sustituto.length + 1];
                for(int i2 = 0; i2 < sustituto.length;i2++)
                    fr[i+i2] = sustituto[i2];
            }
    }
    
    public static char[] sustitucion2(char[] fr, char sustituir, char[]sustituto){
        /*en este caso lo hago con return y modificandolo en frM para que no interfiera con 
        con la funcion sustitucion; para resolver el ejercicio adecuadamente 
        desde la línea 36 hasta la 42 incluida deberían estar en el metodo main.*/
        int cont = 0;
        for(int i = 0; i < fr.length; i++)
            if (fr[i] == sustituir)
                cont++;
        char []frM = new char[fr.length+(cont*(sustituto.length-1))];
        for(int i = 0; i < fr.length; i++)
            frM[i] = fr[i];
        for(int i = 0; i < frM.length - sustituto.length+1; i++)
            if(frM[i] == sustituir){
                for(int j = frM.length - 1; j > (i+sustituto.length-1); j--)
                    frM[j]=frM[j-sustituto.length+1];
                for(int i2 = 0; i2 < sustituto.length;i2++)
                    frM[i+i2] = sustituto[i2];
            }
        return frM;
    }
           
}
