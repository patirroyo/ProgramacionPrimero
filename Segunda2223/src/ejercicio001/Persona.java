package ejercicio001;
/*no vamos a crear un metodo main, vamos a declarar los atributos de la clase
Los atributos se definen con la primera legra en minúscula.
*/


public class Persona {
    int dni;
    String nombre;
    String fNac;
    String domicilio;
    
    /*Dentro de la clase, habrá metodos, a parte de los atributos.
    el método constructor es un método especial para las clases, el principal
    tiene el mismo nombre que la clase.
    Se escribe con la primera letra con mayúscula, se puede declarar o si no 
    se declara se da por implicito.
    Este método reserva memoria y da valores iniciales a los atributos.
    No devuelve nada, ni siquiera void.
    */
    
    public Persona(int dni, String nom, String fN, String dom){
     /*Los atributos globales se definen arriba, en el metodo constructor 
     declaramos variables locales; si se llaman igual podemos caer en una
     ambigüedad. Para ello se utilizará el this.
     */
     this.dni = dni; //this. es para el atributo de la clase, es como las lentejas, si quieres los pones o sino los dejas en JAVA
     nombre = nom;
     this.fNac = fN;
     domicilio = dom;
    }
    public Persona(){
        /*se utiliza si inicialmente los atributos tienen los mismos datos
        Jugamos con el polimorfismo*/
        dni = 155555555;
        nombre = "Pepe Pérez";
        fNac = "22/12/2000";
        domicilio = "su casa";
    }
    public Persona(int dni, String nombre){
        this.dni = dni; 
        this.nombre = nombre;
        fNac = "22/12/2000";
        domicilio = "su casa";
    }
    //el resto de métodos ya van en minúsuculas
    public void mostrar(){
        System.out.println(nombre + " - " + dni + " - " + "fnac: " + fNac + " - " + domicilio);
    }
    
}
