/*
Campanadas: nos tiene que devolver las campanadas que se han dado hasta el momento.
A las tres de la mañana: 3 + 2+ 1 = 6 campanadas
 */
package primera2223;


public class Ejercicio090 {
    public static void main(String arg[]){
        int hora = 24;
        int campanadas = 0;
        System.out.printf("A las %d se han dado %d campanadas.\n", hora, campanadas(hora));
        
        campanadas = campanadas1(hora, campanadas);
        System.out.printf("A las %d se han dado %d campanadas.\n", hora, campanadas);
                
    }

    public static int campanadas1(int hora, int campanadas) {
        for(int i = 0; i <= hora; i++)
            if(i > 12)
                campanadas += i-12;
            else
                campanadas += i;
        return campanadas;
    }
    
    public static int campanadas(int hora){
        if(hora > 12)
            return campanadas(12) + campanadas(hora-12);
        if(hora == 0)
            return 0;
        return hora + campanadas(hora-1);
    }
}
