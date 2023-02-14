/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio002;


public class Programa {
    public static void main(String[] args) {
        Casa casa1;
        Casa casa2;
        Chalet chalet1;
        Chalet chalet2;
        
        casa1 = new Casa("Los póstigos", 89, 4,"España");
        casa2 = new Casa("Paseo Calanda", 77, 3, "España");
        
        chalet1 = new Chalet("SantaFe", 120, 6, "España", 1000, true);
        chalet2 = new Chalet("Lechago", 150, 7, "España", 10, false);
        
        casa1.mostrar();
        casa2.mostrar();
        chalet1.mostrar();
        chalet2.mostrar();
    }
}
