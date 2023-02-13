/*
Mostrar por pantalla el distado de 10
 */
package primera2223;

public class Ejercicio036 {
    public static void main(String arg[]){
        int notas[][] = {{7, 9, 3, 8},
                         {10,9, 9, 8},
                         {9, 10, 7, 10},
                         {3, 10, 5, 6},
                         {8, 5, 4, 5}};
        String asignaturas[] = {"Programacion", "Leng.Marcas", "Sistemas", "Bases de datos"};
        String alumnos[] = {"Ismael Abed", "Mikel Aramburu", "Ismael Bernad", 
                            "Ignacio Bielsa", "Marcos Burgos",};
        
        System.out.println("Listado de dices");
        for(int i = 0; i < notas.length; i++){
            for(int j = 0; j < notas[i].length; j++){
                if(notas[i][j] == 10)
                System.out.printf("El alumno %s ha sacado un 10 en %s\n", alumnos[i], asignaturas[j]);
            }
        }
              
    }
    
}
