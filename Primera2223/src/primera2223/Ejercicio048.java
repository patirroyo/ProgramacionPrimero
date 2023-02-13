/*
Ordenar los vectores de una tabla, llamando al metodo ordenar.
 */
package primera2223;

public class Ejercicio048 {
    public static void main(String arg[]){
    int salarios[][] = {{700, 900, 1300, 800, 790, 850},
                            {1000, 950, 1080, 1070, 1200, 1100},
                            {1300, 930, 1200, 1170, 1000, 1100},
                            {1500, 1950, 1880, 1970, 2200, 2100}};
    for(int i = 0; i < salarios.length; i++)
        ordenar(salarios[i]);
    for(int i = 0; i < salarios.length; i++){
        for(int j = 0; j < salarios[i].length;j++)
            System.out.printf("%d ",salarios[i][j]);
    System.out.println();
    }
    }
     public static void ordenar(int v[]){
        int inter = 0;
        for(int i = 0; i < v.length - 1; i++){
            for(int j = v.length - 1; j > i; j--)
                if(v[j] < v[j-1]){
                    inter = v[j-1];
                    v[j-1] = v[j];
                    v[j] = inter;
                }
        }
    }
}
     
