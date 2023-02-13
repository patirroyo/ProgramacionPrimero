/*
Mostrar el trimestre con mas nacimientos
El mes que más bajas se han producido. muertes + traslados
mostrar por pantalla cuantas personas nuevas y cuantas se han ido en total.
 */
package primera2223;



public class Ejercicio094 {
    public static void main(String arg[]){
        String movimientos[] = {"Nacimientos", "Defunciones", "Traslados fuera", "Nuevos asentamientos"};
        int movPoblacion[][] = {{3, 2, 0, 0}, {1, 5, 0 ,0}, {9, 4, 0,0}, {5, 4, 0, 1}, {3, 5, 0, 1}, {2, 4, 1 ,1}, {3, 6, 1,0}, {1, 4, 5, 1},{1, 3, 1, 1}, {4, 3, 2 ,6}, {5, 7, 1, 1}, {5, 4, 0, 1}};
        int trimestres[] = {0, 0, 0, 0};
        String meses[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre","Diciembre"};
        int posmax = 1;
        int mes[] = new int[movPoblacion.length];
        int nuevos = 0;
        int idos = 0;


        //1º Un bucle que recorre el vector de movPoblacion y va cargando en trimestres
        for(int i = 0; i < meses.length; i++){
            int trimestre = i/3;//Esto me lo puedo ahorrar y meterlo todo en la línea de abajo
            trimestres[trimestre] += movPoblacion[i][0];
        }
        for(int i = 0; i < trimestres.length; i++)
            if(trimestres[posmax] < trimestres[i])
                posmax = i;
        System.out.printf("El trimestre con más %s es el %dº con %d nuevos retoños.\n", movimientos[0], (posmax+1),trimestres[posmax]);

        //2º un bucle que va llenando un vector con las 
        /*for(int i = 0; i < mes.length; i++)
             mes[i] += movPoblacion[i][1] + movPoblacion[i][2]; NO es necesario hacer esto si lo hago como abajo, la suma en 
        el if.*/
        posmax = 1;
        for(int i = 0; i < movPoblacion.length; i++)
            if(movPoblacion[posmax][1]+movPoblacion[posmax][2] < movPoblacion[i][1]+movPoblacion[i][2])
                posmax = i;
        System.out.printf("El mes con más bajas es %s con %d bajas.\n" , (meses[posmax]), movPoblacion[posmax][1]+movPoblacion[posmax][2]);
        
       //3º Un bucle que recorre las 12 filas
        
        for(int i = 0; i < mes.length; i++)
            nuevos += movPoblacion[i][0] + movPoblacion[i][3];
        
        System.out.printf("En total hay %s personas más.\n", nuevos);
        
        for(int i = 0; i < mes.length; i++)
            idos += movPoblacion[i][1] + movPoblacion[i][2];
        
        System.out.printf("En total nos han abandonado %s personas.\n" , idos);
        System.out.printf("El balance total es de %s personas.\n" , nuevos-idos);
        }
    }

        
