/*
Tendremos un cine con cuatro salas y vamos a ver el número de espectadores que 
visitan cada una cada día de la semana.
Mostrar por pantalla el día que más entradas se vendieron y cuántas fueron.
También el día que menos se vendieron y cuántas fueron.
 */
package primera2223;

/**
 *
 * @author alber
 */
public class Ejercicio032 {
     public static void main(String arg[]){
        int salas[][] = {{10, 20, 30, 40, 150, 230, 245},
            {50, 60, 70, 80, 175, 200, 170},
            {90, 100, 110, 120, 130, 125, 110}};
        String dias[] = {"Lunes", "Martes", "Miércoles", "Jueves",
            "Viernes","Sábado", "Domingo" };
        int posmax = 0;
        int posmin = 0;
        int vacum[] = {0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < salas.length; i++)
            for (int j = 0; j < salas[i].length; j++)
                vacum[j] += salas[i][j];
        for (int i = 1; i < vacum.length; i++){
            if(vacum[i] > vacum[posmax])
                posmax = i;
            if(vacum[i] < vacum[posmin])
                posmin = i;
        }
        System.out.printf("El día que más espectadores había fue el %s, con %d espectadores\n", dias[posmax], vacum[posmax]);
        System.out.printf("El día que menos espectadores había fue el %s, con %d espectadores\n", dias[posmin], vacum[posmin]);
            
                
                
                }
     }
