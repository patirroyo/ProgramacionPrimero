/*
 Mostrar por pantalla cuantos Kg de cada producto hemos vendido
 */
package primera2223;

public class Ejercicio030b {
    public static void main(String arg[]){
        int tabla[][] = {{10, 20, 30, 40}, {50, 60, 70, 80}, {90, 100, 110, 120}};
        String productos[] = {"Naranjas", "Peras", "Manzanas"};
                /*Un vector de string, de caracteres que van entre comillas, es
                una clase porque va con mayúsculas
                */
        for (int i = 0; i < tabla.length; i++){
            int acum = 0;
            for (int j = 0; j < tabla[i].length; j++)
                acum += tabla[i][j];
         System.out.printf("He vendido %d Kg de %s.\n", acum, productos[i]);
       }     
    }
}
