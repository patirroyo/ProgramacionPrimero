/*
Creamos la clase Chalet
Un Chalet es un tipo de casa, tiene los atributos de casa y además tiene
cosas propias; es decir, el chalet hereda todos los atributos de la casa.
 */
package ejercicio002;


public class Chalet extends Casa {
    int metrosJardin;
    boolean piscina = true;
    
    public Chalet(String d, int m, int hab, String p, int nMJ, boolean pis){
        /*lo primero que hay que hacer cuando la clase es heredada de otra es
        llamar al método constructor de la superclase, con super
        el método constructor de la superclase instancia un objeto de la 
        clase superior, una casa. Para construir un chalet primero construyo una
        casa.
        */
        super(d, m, hab, p);
        metrosJardin = nMJ;
        piscina = pis;
    }
    public void mostrar(){
        if(piscina)
            System.out.print("Esto es un Chalet con piscina. Ubicado en: ");
        else
            System.out.print("Esto es un Chalet sin piscina. Ubicado en: ");
        System.out.println(direccion + " - metros2: " + num_metros + " - " + 
                "habitaciones: " + numHabitaciones + " - " + pais + " y tiene "
                        + metrosJardin + " metros de jardin");
    }
}
