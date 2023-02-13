/*
Instanciamos un array bidimensional de enteros con los salarios de unos
trabajadores; instanciar funciones para que devuelva de cada empleado su 
salario semestral.
1º Crear dos funciones llamada salariosSemestrales que devuelva un vector
de enteros con salario que ha acumulado cada empleado
en los seis meses de trabajo.
Sacar por pantalla los salarios acumulados de los empeados con una funcionción
que se va a llamar salariosSemestrales pero que no devuelve nada; como la morfología
no es la misma Java nos permite crearlas. Es un lenguaje polimorfo. 
Mientras que la primera pide algo y devuelve algo, la otra ni pide ni devuelve.
Los lenguajes orientados a objetos tienen que tener: herencia, encapsulamiento y polimorfismo
2º Crear dos funciones llamadas "sumaSalarios", que acumulen por meses
y después mostramos de cada mes cuánto hemos pagado a los empleados.
 */
package primera2223;

public class Ejercicio046 {
    public static void main(String arg[]){
        int salarios[][] = {{700, 900, 1300, 800, 790, 850},
                            {1000, 950, 1080, 1070, 1200, 1100},
                            {1300, 930, 1200, 1170, 1000, 1100},
                            {1500, 1950, 1880, 1970, 2200, 2100}};
        String empleados[] = {"Javier Marias", "Antonio Muñoz", "Isabel Allende", "José Saramago"};
        String meses[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio"};
       
        int emplAcum[] = salariosSemestrales(salarios);
        for(int i = 0; i < empleados.length; i++)
            System.out.printf("El salario acumulado por %s es de %d €\n", empleados[i],emplAcum[i]);
        System.out.println();
        
        int emplAcum2[] = new int[4];
        salariosSemestrales(salarios, emplAcum2);
        for(int i = 0; i < empleados.length; i++)
            System.out.printf("El salario acumulado por %s es de %d €\n", empleados[i],emplAcum2[i]);
        System.out.println();
        
        int mesAcum[] = sumaSalarios(salarios);
        for(int i = 0; i < meses.length; i++)
            System.out.printf("El salario acumulado en %s es de %d €\n", meses[i],mesAcum[i]);
        System.out.println();
        
        int mesAcum2[] = new int[6];
        sumaSalarios(salarios, mesAcum2);
         for(int i = 0; i < meses.length; i++)
            System.out.printf("El salario acumulado en %s es de %d €\n", meses[i],mesAcum2[i]);
       
        
    }
    public static int[] salariosSemestrales(int salario[][]){
        int acum[] = new int[4];//instanciar el vector, reservar memoria
        for(int i=0; i<salario.length; i++)
            for(int j=0; j<salario[i].length; j++)
                acum[i] += salario[i][j];
        return acum;
    }
    /*Creamos la funcion con el mismo nombre pero que no va a devolver nada,
    lo que va a hacer es directamente modificar la memoria RAM*/
    public static void salariosSemestrales(int salarios[][], int emplAcum2[]){
        for(int i=0; i<salarios.length; i++)
            for(int j=0; j<salarios[i].length; j++)
                emplAcum2[i] += salarios[i][j];
    }
    public static int[] sumaSalarios(int salario[][]){
        int acum[] = new int[6];//instanciar el vector, reservar memoria
        for(int i=0; i<salario.length; i++)
            for(int j=0; j<salario[i].length; j++)
                acum[j] += salario[i][j];
        return acum;
    }
    public static void sumaSalarios(int salarios[][], int mesAcum2[]){
        for(int i=0; i<salarios.length; i++)
            for(int j=0; j<salarios[i].length; j++)
                mesAcum2[j] += salarios[i][j];
    }
}
