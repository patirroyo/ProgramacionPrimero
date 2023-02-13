/*
tienes un número en decimal y lo tienes que mostrar por pantalla en binario.
 */
package primera2223;


public class Ejercicio093b {
     public static void main(String arg[]){
        final int ESCANOS = 7; //modificador final es para definir constantes, no variables y se escriben con MAYÚSCULAS
        String partidos[] = {"P.P", "P.S.O.E.", "Podemos", "Ciudadanos", "Vox"};
        int votos[] = {119421, 157420, 57398, 46645, 91978};
        repartoEscanos(ESCANOS, partidos, votos);
     }
     
     public static void repartoEscanos (final int ESCANOS, String[] partidos, int[] votos){
        int coeficiente[] = new int[partidos.length];
        for(int i = 0; i < coeficiente.length; i++)
             coeficiente[i] = 1;
        for(int i = 0; i < ESCANOS; i++){
             int posmax = 0;
             for(int j = 1; j < partidos.length; j++)
                 if((votos[j]/coeficiente[j])> (votos[posmax]/coeficiente[posmax]))
                    posmax = j;
                
        coeficiente[posmax]++;    
                 
         }
          for(int i = 0; i < partidos.length; i++)
             System.out.printf("%s ha sacado %d escaños\n", partidos[i], coeficiente[i]-1);
         
     }
}