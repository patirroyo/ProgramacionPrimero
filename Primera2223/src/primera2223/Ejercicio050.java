/*
Crear una funcion Suma que nos devuelva la suma de los elementos de un vector.
 */
package primera2223;

/**
 *
 * @author alber
 */
public class Ejercicio050 {
    public static void main(String arg[]){
    int salarios[][] = {{700, 900, 1300, 800, 790, 850},
                            {1000, 950, 1080, 1070, 1200, 1100},
                            {1300, 930, 1200, 1170, 1000, 1100},
                            {1500, 1950, 1880, 1970, 2200, 2100}};
    String empleados[] = {"Javier Marías", "Antonio Muñoz", "Isabel Allende", "José Saramago"};
    for(int i=0; i<empleados.length; i++)    
        System.out.printf("El total acumulado en %d meses por %s es de %d €.\n", salarios[i].length, empleados[i], suma(salarios[i]));
            
    }
    public static int suma(int v[]){
        int suma = 0;
        for (int i = 0; i < v.length; i++)
            suma += v[i];
        return suma;
    }
    
}
