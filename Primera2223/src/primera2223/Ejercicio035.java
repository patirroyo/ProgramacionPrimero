/*
Mostrar por pantalla el nombre del alumno que mejores notas ha sacado y 
cuál es su media, y el que peores notas has sacado y cuál es su media.
Y después mostrar la asignatura que mejores notas tiene y su media; y la
que tiene peores notas y su media.
 */
package primera2223;

public class Ejercicio035 {
    public static void main(String arg[]){
        int notas[][] = {{7, 9, 3, 8},
                         {10,9, 9, 8},
                         {9, 10, 7, 1},
                         {3, 10, 5, 6},
                         {8, 5, 4, 5}};
        String asignaturas[] = {"Programacion", "Leng.Marcas", "Sistemas", "Bases de datos"};
        String alumnos[] = {"Ismael Abed", "Mikel Aramburu", "Ismael Bernad", 
                            "Ignacio Bielsa", "Marcos Burgos",};
        double sumalum[] = {0, 0, 0, 0, 0};
        double sumasig[] = {0, 0, 0, 0};
        int alumTop = 0;//declaro posiciones de los mejores y peores
        int asigTop = 0;
        int alumBott = 0;
        int asigBott = 0;
        for(int i = 0; i < notas.length; i++){
            for(int j = 0; j < notas[i].length; j++){
                sumalum[i] += notas[i][j];
                sumasig[j] += notas[i][j];
            }
        }
        for(int i = 1; i < sumalum.length; i++){
            if(sumalum[i] > sumalum[alumTop])
                alumTop = i;
            if(sumalum[i] < sumalum[alumBott])
                alumBott = i;
        }
        for(int i = 1; i < sumasig.length; i++){
            if(sumasig[i] > sumasig[asigTop])
                asigTop = i;
            if(sumasig[i] < sumasig[asigBott])
                asigBott = i;
        }
        System.out.printf("El alumno que mejores notas tiene es %s con un %.2f\n", alumnos[alumTop], (sumalum[alumTop]/sumasig.length));
        System.out.printf("El alumno que peores notas tiene es %s con un %.2f\n", alumnos[alumBott], (sumalum[alumBott]/sumasig.length));
        System.out.printf("La asignatura que mejores notas tiene es %s con un %.2f\n", asignaturas[asigTop], (sumasig[asigTop]/sumalum.length));
        System.out.printf("La asignatura que peores notas tiene es %s con un %.2f\n", asignaturas[asigBott], (sumasig[asigBott]/sumalum.length));
        
    }
    
}
