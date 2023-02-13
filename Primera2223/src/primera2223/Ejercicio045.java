/*
Instanciamos un array bidimensional de enteros con los salarios de unos
trabajadores y creamos y llamamos a una función que sume todos esos 
salarios
 */
package primera2223;

public class Ejercicio045 {
    public static void main(String arg[]){
        int salarios[][] = {{700, 900, 1300, 800, 790, 850},
                            {1000, 950, 1080, 1070, 1200, 1100},
                            {1300, 930, 1200, 1170, 1000, 1100},
                            {1500, 1950, 1880, 1970, 2200, 2100}};
        System.out.printf("La suma de todos los salarios es %d €\n", suma(salarios));
    }
    public static int suma(int tabla[][]){
        int acum = 0;
        for(int i=0; i<tabla.length; i++)
            for(int j=0; j<tabla[i].length; j++)
                acum += tabla[i][j];
        return acum;
            
    }
}
