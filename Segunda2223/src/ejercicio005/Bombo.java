/*
Vamos a crear una clase Bombo que está lleno de bombas,
Crearemos una función para sacar una bola y cada vez que saque la bola,
lo deje correcto para que no vuelva a salir repetido
 */
package ejercicio005;

public class Bombo {
    public static final int NUMBOLAS = 48;
    //public String nombre;
    /*El static sirve para decir que todos los objetos de la misma clasa tienen
    el mismo valor, es decir todos los bombos van a tener 48 bolas.
    Es un ATRIBUTO DE CLASE no un atributo de objeto.
    El segundo no es static por lo que cada objeto tendrá su nombre.
    Un atributo se declara como final si ese atributo es CONSTANTE. y se definen
    siempre con todas las letras en mayúsculas.
    */
    public int bombo[]; //creamos el vector
    public int bolasQuedan;
    
    public Bombo(){
        bombo = new int[NUMBOLAS]; /*instanciamos el vector, es decir, le decimos que 
                    reserve 48 * 4(lo que ocupa un int) direcciones de memoria*/
        bolasQuedan = NUMBOLAS;
        for(int i = 0; i < NUMBOLAS; i++)
            bombo[i] = i + 1;
    }
    
    public int sacarBola(){
        int aleatorio = (int)(Math.random() * bolasQuedan);/*paresamos, este método es [0,1[ (el 1 nunca sale), es un método estático
        se accede a él a través del nombre de la clase*/
        //Random.nextInt(bolasQuedan);
        int guardado = bombo[aleatorio];
        bombo[aleatorio] = bombo[bolasQuedan-1];
        bolasQuedan--;
        return guardado;
          
    }
    
}
