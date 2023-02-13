/*
Multiplicar una tabla por un vector
 */

package primera2223;
    
public class Ejercicio097practica {
    public static void main(String[] args) {

        int num1 = 2;
        int num2 = 8;
        int resultado = 1;

        for (int i = 0; i < num2; i++)
            resultado*=num1;
        if (num2==0)
            resultado=1;
        System.out.println(resultado);
        System.out.println(elevar(num1,num2));
    }

    public static int  elevar(int n1, int n2){
        if (n2==0)
            return 1;
        
        else
            return n1 * elevar(n1,n2-1);
    }

}