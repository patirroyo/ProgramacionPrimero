/*
Mostrar por pantalla, de cada producto, el dinero recaudado y tabién
tenemos que mostrar el dinero recaudado en total.
 */
package primera2223;

public class Ejercicio031 {
    public static void main(String arg[]){
        int tabla[][] = {{10, 20, 30, 40}, {50, 60, 70, 80}, {90, 100, 110, 120}};
        String productos[] = {"Naranjas", "Peras", "Manzanas"};
        double precios[] = {1.5, 2, 0.8}; //double o float para número con decimales
        double acum = 0;
        double total = 0;
            for (int i = 0; i < tabla.length; i++){
                acum = 0;
                for (int j = 0; j < tabla[i].length; j++)
                    acum += tabla[i][j];
                total += acum * precios[i];
                System.out.printf("He ganado %.2f € con las %s.\n", acum * precios[i], productos[i]);
            }
            System.out.printf("He ganado %.2f € en TOTAL. \n", total);
                
    }
      
}
