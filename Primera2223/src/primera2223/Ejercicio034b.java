/*
 Mostrar por pantalla el nombre de la película que consiguió mayor
número de especatadores en un día y que día de la semana ocurrió esto.
Lo mismo con la película que menos espectadores tuvo en un día.
Es decir el valor máximo y mínimo de toda la tabla.
 */
package primera2223;

public class Ejercicio034b {
     public static void main(String arg[]){
        int salas[][] = {{40, 50, 30, 40, 150, 230, 245},
            {50, 60, 70, 80, 175, 200, 170},
            {90, 100, 110, 120, 130, 125, 110},
            {10, 40, 80, 90, 110, 150, 115}};
        String peliculas[] = {"Avatar", "Gran Torino", "Blonde", "Kill Bill"};
        String dias[] = {"Lunes", "Martes", "Miércoles", "Jueves",
            "Viernes","Sábado", "Domingo"};
        int posMaxFila = 0;
        int posMaxCol = 0;
        int posMinFila = 0;
        int posMinCol = 0;
        
        for(int i = 0; i < salas.length; i++)
            for(int j = 0; j < salas[i].length; j++ ){
                if(salas[i][j] > salas[posMaxFila][posMaxCol]){
                    posMaxFila = i;
                    posMaxCol = j;
                }
                if(salas[i][j] < salas[posMinFila][posMinCol]){
                    posMinFila = i;
                    posMinCol = j;
                }             
            }
        System.out.printf("La película con más espectadores fue %s el %s con %d espectadores.\n", peliculas[posMaxFila], dias[posMaxCol], salas[posMaxFila][posMaxCol]);
        System.out.printf("La película con menos espectadores fue %s el %s con %d espectadores.\n", peliculas[posMinFila], dias[posMinCol], salas[posMinFila][posMinCol]);  
                
        
       
        
     }   
}
