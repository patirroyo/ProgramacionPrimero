/*
Calclular la media de goles de cada futbolista
Sacar la suma de los goles por temporada
 */
package primera2223;

/**
 *
 * @author alber
 */
public class Ejercicio039 {
      public static void main(String arg[]){
        int goles[][] = {{18, 19, 22, 33, 8},
                        {22, 24, 19, 18, 10},
                        {19, 20, 31, 42, 50},
                        {13, 14, 15, 16, 17}};
        String futbolistas[] = {"Messi", "Ronaldo", "Halland", "Mbappé", "Vinicius"};
        String temporadas[] = {"21/22", "20/21", "19/20", "18/19"};
        double acum;
        for(int j = 0; j < futbolistas.length; j++){
            acum = 0;
            for(int i = 0; i < goles.length; i++)
                acum += goles[i][j];
            System.out.printf("%s ha marcado %.1f goles de media en las últimas %d temporadas\n", futbolistas[j], (acum/goles.length), goles.length);
        }
        System.out.println();
      
        for(int i = 0; i < goles.length; i++){
            acum = 0;
            for(int j = 0; j < goles[i].length; j++)
                acum += goles[i][j];
            System.out.printf("En la temporada %s se han marcado %.0f goles\n", temporadas[i], acum);
                /*pongo %0.f porque la variable acum está declarada como double, sino usaría el %d*/
     
        }
    }
}