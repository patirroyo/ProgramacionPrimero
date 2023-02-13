/*
Intercambiar el contenido de los elementos de un vector de enteros, de manera
que se intercambie lo que hay en la posición primera, con la ultima; la segunda
con la penúltima...
 */
package primera2223;
public class Ejercicio017 {
    public static void main(String arg[]){
        int datos[] = {10, 20, 30, 40, 50, 60};
        for(int i = 0; i < datos.length; i++)
             if(i < datos.length -1)
                System.out.print(datos[i] + " - ");
            else
                System.out.println(datos[i] + ". ");
        int inter;
        for(int i = 0; i < datos.length/2; i++){
            inter = datos[i];
            datos[i] = datos[datos.length - 1 -i]; 
            /* si no resto 1, va a buscar el elemento 6 que no existe, pues la 
            posición es la 5, por eso se crea una Exception*/
            datos[datos.length - 1 - i] = inter;   
        }
        for(int i = 0; i < datos.length; i++)
            if(i < datos.length -1)
                System.out.print(datos[i] + " - ");
            else
                System.out.println(datos[i] + ". ");
        
    }
}
        
                
   
