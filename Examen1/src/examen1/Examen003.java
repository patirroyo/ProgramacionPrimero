/*
Tenemos un String frase = "En un lugar de La Mancha de cuyo nombre no quiero acordarme ";
Queremos que vaya apareciendo la frase en la pantalla, de la siguiente manera:
- un lugar de La Mancha de cuyo nombre no quiero acordarme En
- lugar de La Mancha de cuyo nombre no quiero acordarme En un
- de La Mancha de cuyo nombre no quiero acordarme En un lugar

(cada palabra que ocupe la primera posición en la frase, pasará a la última posición en la siguiente iteración.  Así hasta que vuelva a aparecer la frase original).
 funcion substring e indexOf
 */
package examen1;


public class Examen003 {
    public static void main(String arg[]){
        String frase = "En un lugar de La Mancha de cuyo nombre no quiero acordarme ";
        int cont = 0;
        int fin = frase.indexOf(" ");//instancio la posicion que ocupa el espacio despues de la primera palabra.
        for(int i = 0; i < frase.length(); i++)//creo un bucle para contar las palabras
            if(frase.charAt(i) == ' ')//cada vez que vea un espacio
                cont++;//aumento el contador
        
        for(int i = 0; i < cont; i++){//creo un bucle que durará el número de palabras de la frase
            frase = frase.substring(fin+1).concat(frase.substring(0,fin+1));
            /* creo un substring de la frase sin la primera palabra y sin el espacio (fin +1)
            y lo concateno con el inicio de la frase= primera palabra + espacio; 
            de esta manera en cada iteración del bucle pongo la primera palabra y el espacio
            al final y se podrá repetir indefinidamente, en este caso acabará cuando todas
            las palabras hayan cambiado de posición una vez.
            */
            System.out.println(frase); //en cada iteración del bucle lo muestro por pantalla
            fin = frase.indexOf(" ");//vuelvo a calcular la posición del fin de la primera palabra en la frase modificada.
        }
    }
    
}
