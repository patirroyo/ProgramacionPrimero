/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio004;

public class Nif {
    public int dni;
    public char letra;
    public static char TABLA[] = {'T','R','W','A','G','M','Y','F','P','D','X',
                                'B','N','J','Z','S','Q','V','H','L','C','K','E'};
    //static nos indica que es una constante, no se puede modificar
    public Nif (int dni, char l) throws Exception {
    //para comprobar que la letra es la correcta, vamos a lanzar una comprobación de excepciones
        this.dni = dni;
        if(l != TABLA[dni % TABLA.length]){
            letra = TABLA[dni % TABLA.length];
            throw new Exception("Me has pasado mal el NIF");
        }
        letra = l;
    }
    public Nif (int dni){
        this.dni = dni;
        letra = TABLA[dni % TABLA.length];
    }
    public void mostrar(){
        System.out.println(dni + "-" + letra);
    }
}
