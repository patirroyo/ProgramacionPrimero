/*
Modificadores
Hay clases públicas o privadas.
Las públicas es que se puede acceder desde otros paquetes.
Si no pones nada, no es pública, no la puedes utilizar desde otros paquetes.

El modificador "abstract" aplicado a clases.

Se pueden poner varios modificadores, cuando pones el modificador abstract
significa que no puedes implementar objetos de esa clase.

 */
package ejercicio003;


public abstract class Animal {
    int codigo;
    String sexo;
    String nombre;
    String onomatopeya;
    
    public Animal(int cod, String sex, String nom, String ono){
        codigo = cod;
        sexo = sex;
        nombre = nom;
        onomatopeya = ono;
    }
    public abstract void hablar();//declaramos un método hablar, y lo modificamos
    /*En este caso el método no se implementa, no le ponemos ni llaves ni 
    instrucciones, entonces genera la obligación de implementar el método hablar
    en todas las subclases; solo ponemos el encabezado
    */
    
}
