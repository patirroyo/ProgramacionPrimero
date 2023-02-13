/*
FUNCIONES
Tratamiento de funciones o métodos.

todos los métodos tienen un nombre que empieza por minúscula.
los modificadores van a la izquierda:
-public: es publico, se puede acceder a él desde otra clase
-static: se puede acceder a través del nombre del método
-void: hay que decir lo que devuelve el método, devuelve algo o nada (void)
- (): entre paréntesis los parámetros que le pasamos.
 */
package primera2223;

public class Ejercicio043 {
    public static void main(String arg[]){
       // String palabras; //declaro un String: una clase, un objeto porque empieza por mayúscula. como los Ejercicios
        escribir();//lamo a la funcion por su nombre        
        hablar("Buenos días 2H");
        // hablar(55);da error porque 55 es un int no es un String
        animalHabla("Me llamo Toby","Guau, guau");
        System.out.println(concatenar("En un lugar ", "de la Mancha"));//como la función devuelve un String la puede meter dentro del System.out
        System.out.printf("La suma de 1 y 2 es %d\n", suma(1,2));
    }
    public static void escribir(){
        System.out.println("hola");
    }
    public static void hablar(String frase){/* PASO DE PARÁMETROS a la funcion hablar hay que pasarle un String 
        que le vamos a llamar frase, será una variable local al método, que se usará en el método y no valdrá para otro*/
        System.out.println(frase);
    }
    public static void animalHabla(String frase, String onomatopeya){
        /*Así le decimos que va a recibir 2 parámetros, podemos poner tantos como queramos y se separan por comas*/
        System.out.println(frase + ": " + onomatopeya);
    }
    public static String concatenar(String frase1, String frase2){
        /*por primera vez esta función va a devolver un String y 
        le vamos a dar dos parámetros.
        */
        return frase1 + frase2; //cuando se ejecuta el return se acaba la funcion
    }
    public static int suma(int num1, int num2){
        return num1 + num2;
    }
}
