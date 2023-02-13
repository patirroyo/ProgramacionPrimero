/*
Ordenar los nombres del vector en orden alfabético
 */
package primera2223;

public class Ejercicio073 {
     public static void main(String arg[]){
        String nombres[] = {"Pepe", "Juan", "María", "Antonio", "Luisa"};
        
       // nombres[0].compareTo(nombres[1]);Una comparación es una resta; Accedo a esta función con un objeto y me pide otro con el que compararlo.
        String inter;
        for(int i = 0; i < nombres.length - 1; i++){
            for(int j = nombres.length - 1; j > i; j--)
                if(nombres[j].compareTo(nombres[j-1])< 0){
                    inter = nombres[j-1];
                    nombres[j-1] = nombres[j];
                    nombres[j] = inter;
                }
        }
        for(int i = 0; i < nombres.length; i++)
            System.out.printf("%s\n",nombres[i]);
    
    

                
    }
    
}
