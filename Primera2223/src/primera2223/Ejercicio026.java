/*
 Creación y manipulación de una tabla
Es un vector cuyos elementos son a la vez vectores
 */
package primera2223;


public class Ejercicio026 {
    public static void main(String arg[]){
        int tabla[][] = {{10, 20, 30}, {40, 50, 60}, {70, 80, 90},{100, 110, 120}};
        for(int i = 0; i < tabla.length; i++){
            for(int j = 0; j < tabla[i].length; j++) // Como es un vector de vectores tiene la propiedad length
                System.out.printf("%d - ", tabla[i][j]);
            System.out.println();
    }
    }
    
}
