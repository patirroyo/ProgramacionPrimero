/*
 Mostrar por pantalla el nombre de la película que consiguió mayor
número de especatadores en un día y que día de la semana ocurrió esto.
Lo mismo con la película que menos espectadores tuvo en un día.
Es decir el valor máximo y mínimo de toda la tabla.
 */
package primera2223;

public class Ejercicio034 {
     public static void main(String arg[]){
        int salas[][] = {{40, 50, 30, 40, 150, 230, 245},
            {50, 60, 70, 80, 175, 200, 170},
            {90, 100, 110, 120, 130, 125, 110},
            {10, 40, 80, 90, 110, 150, 115}};
        String peliculas[] = {"Avatar", "Gran Torino", "Blonde", "Kill Bill"};
        String dias[] = {"Lunes", "Martes", "Miércoles", "Jueves",
            "Viernes","Sábado", "Domingo"};
        int vposmax[] = {0, 0};
        int vposmin[] = {0, 0};
        for(int i = 0; i < salas.length; i++)
            for(int j = 0; j < salas[i].length; j++ ){
                if(salas[i][j] > salas[vposmax[0]][vposmax[1]]){
                    vposmax[0] = i;
                    vposmax[1] = j;
                }
                if(salas[i][j] < salas[vposmin[0]][vposmin[1]]){
                    vposmin[0] = i;
                    vposmin[1] = j;
                }             
            }
        System.out.printf("La película con más espectadores fue %s el %s con %d espectadores.\n", peliculas[vposmax[0]], dias[vposmax[1]], salas[vposmax[0]][vposmax[1]]);
        System.out.printf("La película con menos espectadores fue %s el %s con %d espectadores.\n", peliculas[vposmin[0]], dias[vposmin[1]], salas[vposmin[0]][vposmin[1]]);  
                
        
       
        
     }   
}
