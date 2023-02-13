/*
 Mostrar por pantalla la película más taquillera y cuántos espectadores ha tenido.
Y la menos taquillera y cuantos espectadores ha tenido.
 */
package primera2223;

public class Ejercicio033 {
    public static void main(String arg[]){
        int salas[][] = {{10, 20, 30, 40, 150, 230, 245},
            {50, 60, 70, 80, 175, 200, 170},
            {90, 100, 110, 120, 130, 125, 110},
            {50, 40, 80, 90, 110, 150, 115}};
        String peliculas[] = {"Avatar", "Gran Torino", "Blonde", "Kill Bill"};
        int vacum[] = {0, 0, 0, 0};
        int posmax = 0;
        int posmin = 0;
            for (int i = 0; i < salas.length; i++){
                for(int j = 0; j < salas[i].length; j++)
                  vacum[i] += salas[i][j];
            }
            for (int i = 1; i < vacum.length; i++){
                if(vacum[i] > vacum[posmax])
                     posmax = i;
                if(vacum[i] < vacum[posmin])
                    posmin = i;
            }
        System.out.printf("La película con más espectadores ha sido %s, con %d espectadores.\n", peliculas[posmax], vacum[posmax]);
        System.out.printf("La película con menos espectadores ha sido %s, con %d espectadores.\n", peliculas[posmin], vacum[posmin]);    
    
        
        
}   
}
