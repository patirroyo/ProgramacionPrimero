/*
Dado un número entero que se encuentra dentro de una variable, diseccionarlo,
analizándolo hasta las centenas de millar.
 */
package primera2223;


public class Ejercicio091 {
    public static String medidas[] = {"Unidades", "Decenas", "Centenas", "Unidades de Millar", "Decenas de Millar", "Centenas de Millar"};
    /*al declararlo dentro de la clase, no es local a ningún método y lo puedo utilizar en todos*/
    public static void main(String arg[]){
        int numero = 256809; 
        analizar(numero, 0);
       
         
    }    
        
    
    
    public static void analizar (int numero, int indice){
         
         if(numero/10 == 0)
            System.out.printf("%d %s\n",numero%10, medidas[indice]);
         else
            analizar(numero/10, indice+1);
            System.out.printf("%d %s\n",numero%10, medidas[indice]);
         
 }
}
    
    

