
package ejercicio001;


public class Programa {
    public static void main(String[] args) {
        Persona persona1;//Declaro un objeto (persona1) de la clase Persona
        //ahora el valor del puntero es "null"
        persona1 = new Persona(18447808, "Kevin", "22/9/2000", "Tafalla");//ahora lo instancio
        Persona persona2 = new Persona();
        Persona persona3 = new Persona(18447809, "Alejandro");
        persona1.mostrar();
        persona2.mostrar();
        persona3.mostrar();
    }
}
