/*
Reemplazar en un String funcion replaceAll() y funcion indexOf()
 */
package primera2223;

/**
 *
 * @author alber
 */
public class Ejercicio075 {
     public static void main(String arg[]){
        String frase = "en un lugar lugar de la Mancha, de cuyo lugar no quiero acordarme"; 
        
        String frase2 = frase.replace('n', 'X'); //la función DEVUELVE un string, no modifica el actual
        //para modificar la frase frase = frase.replace('n', 'X');
        
        System.out.printf("%s \n", frase2);
        
        frase = frase2.replaceAll("X", "PpPp");
        System.out.printf("%s \n", frase);
        
        //1ªsi encuentra la subcadena dentro de la cadena devuelve la posición en la que ha encontrado la primera aparción, 
        //3ª la posición que ocupa la subcadena pero empezando a buscar a partir de la posición que indicamos
        //buscar en la frase cuantas veces aparece lugar
        String subcadena = "lugar";
        
        int cont = 0;
        int posicion = frase.indexOf(subcadena); 
        while(posicion != -1){ //la funcion indexOf devuelve -1 si no lo encuentra
            cont++;
            posicion = frase.indexOf(subcadena, posicion + 1);
        }
         System.out.printf("La cadena '%s' aparece %d veces.\n", subcadena, cont);
       
         
         /*for(int i = 0; i < frase.length(); i++){
            if(frase.indexOf(subcadena, i) == i)
                contador++;*/
           
            
           
        }
        
       
        
     }
    
