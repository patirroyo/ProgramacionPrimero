/*
Tratamiento de Excepciones y lanzamiento
*/
package ejercicio004;

public class EjecutableNif {
    
   public static void main(String arg[])throws Exception{
//también hay que habilitar el método en el que se va a producir la excepcion

       /* try{//es una función que hace tratamiento de instrucciones
            int t = 33/0;
        }catch(ArithmeticException exc){/*si se produce la excepción arithmeetic,
            entonces se crea un objeto de la arithmeticException
            va al catch y se mete en el exc,  evitando que el programa pete.
            Luego sigue el programa normalmente.
            System.out.println("Has divido entre cero capullo: " + exc.getMessage());
        }
       System.out.println("Mostrar mensaje");
       */
       
       Nif nif1;
       nif1 = new Nif(18447807, 'J');
       
       Nif nif2;
       nif2 = new Nif(18447806);
       
       nif1.mostrar();
       nif2.mostrar();
   } 
}
