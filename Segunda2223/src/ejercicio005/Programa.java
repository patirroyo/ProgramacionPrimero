/*
Primero crearemos un objeto de la clase bombo
Luego instanciamos una tabla para los resultados
Despues cargamos la tabla
Finalmente mostramos la tabla por pantalla
 */
package ejercicio005;

/**
 *
 * @author alberto
 */
public class Programa {
    public static void main(String arg[]) {
        Bombo bombo1 = new Bombo();
        int tabla[][] = new int[6][8];
        cargarTabla(tabla, bombo1);
        mostrarTabla(tabla);
    }
    
     private static void cargarTabla(int[][] tabla, Bombo bombo1) {
        for(int i = 0; i < tabla.length; i++)
            for (int j = 0; j < tabla[i].length; j++)
                tabla[i][j] = bombo1.sacarBola();
    }
    
    private static void mostrarTabla(int[][] tabla) {
        for(int i = 0; i < tabla.length; i++){
            for (int j = 0; j < tabla[i].length; j++)
                System.out.print(tabla[i][j] + " ");
            System.out.println();
        }
    }
}
