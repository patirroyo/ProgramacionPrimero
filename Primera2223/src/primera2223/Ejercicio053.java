/*
Implementar una funcion que cree una tabla llamda ventas que corresponda con
el contenido de la tabla kilos multiplicando cada uno de sus elementos por su precio.
Los precios están en el vector precios.
Crear funcion cargarTabla y ahi no hay que instanciar un array bidimiensional, 
hay que instanciarlo en el programa principal.
 */
package primera2223;


public class Ejercicio053 {
    public static void main(String arg[]){
        int kilos[][] = {{5, 6, 9, 23, 7, 14, 0},
                         {16, 8, 4, 33, 15, 21, 0}};
        int precios[] = {6, 7};
        int ventas[][] =  cargarTabla(kilos, precios);
        for(int i = 0; i < ventas.length; i++){
            for(int j =0; j < ventas[i].length; j++)
                System.out.printf("%d ", ventas[i][j]);
            System.out.println();
        }
        System.out.println();
        int ventas2[][] = new int[2][7];
        cargarTabla(kilos, ventas2 ,precios);
        for(int i = 0; i < ventas2.length; i++){
            for(int j =0; j < ventas2[i].length; j++)
                System.out.printf("%d ", ventas2[i][j]);
            System.out.println();
        }
      }
    public static int[][] cargarTabla(int k[][], int pr[]){
        int [][]v = new int[k.length][k[0].length];
        for (int i = 0; i < v.length; i++)
            for (int j = 0; j < v[i].length; j++)
                v[i][j] = k[i][j]* pr[i];
        return v;
          
      }
    public static void cargarTabla (int k[][],int v[][],int pr[]){
        for (int i = 0; i < v.length; i++)
            for (int j = 0; j < v[i].length; j++)
                v[i][j] = k[i][j]* pr[i];
        
    }
}
