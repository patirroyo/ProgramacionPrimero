/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio003;

public class Programa {
    public static void main(String arg[]){
        /*Animal animal1;
        animal1 = new Animal(123, "Copito", "macho", "HABLO");
        Da error porque es una clase abstract*/
        
        Perro perro1;
        perro1 = new Perro(1, "hembra", "Boira", "mezcla", "muy buena");
        
        Mono mono1;
        mono1 = new Mono(2, "macho", "Copito","Comer plátanos a dos manos", false);
        
        Mono mono2;
        mono2 = new Mono(3, "hembra", "Didy Kong", "Montar en rino", true);
        
        perro1.hablar();
        mono1.hablar();
        mono2.hablar();
        
        
    }
    
}
