/*
 Mostrar por pantalla cuantos Kg de cada producto hemos vendido
 */
package primera2223;

public class Ejercicio030 {
    public static void main(String arg[]){
        int tabla[][] = {{10, 20, 30, 40}, {50, 60, 70, 80}, {90, 100, 110, 120}};
        String productos[] = {"Naranjas", "Peras", "Manzanas"};
                /*Un vector de string, de caracteres que van entre comillas, es
                una clase porque va con mayúsculas
                */
        int acum[] = {0, 0, 0};
        for (int i = 0; i < tabla.length; i++)
            for (int j = 0; j < tabla[i].length; j++)
                acum[i] += tabla[i][j];
        for(int i = 0; i < tabla.length; i++)
            System.out.printf("%d Kg de %s \n", acum[i], productos[i]);
            
    }
    
}
