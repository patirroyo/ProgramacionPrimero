/*
 Vamos a ver la herencia.
Primero creamos la clase casa
 */
package ejercicio002;

public class Casa {
    String direccion;
    int num_metros;
    int numHabitaciones;
    String pais;
    
   public Casa (String dir, int metros, int hab, String pais){
       direccion = dir;
       num_metros = metros;
       numHabitaciones = hab;
       this.pais = pais;
   }
   
   public void mostrar(){
        System.out.println(direccion + " - metros2: " + num_metros + " - " + "habitaciones: " + numHabitaciones + " - " + pais);
   }
          
}
