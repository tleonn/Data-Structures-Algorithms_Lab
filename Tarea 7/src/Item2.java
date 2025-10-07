import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Item2{
    
    public static int sumaMaxima(int[][] x) {
        int maxSum = 0;
        int fila = x.length;
        int columna = x[0].length;

        for (int cambioFila = 0; cambioFila < (1 << fila); cambioFila++) {
            for (int cambioColumna = 0; cambioColumna < (1 << columna); cambioColumna++) {
                int[][] x1 = cambioMatriz(x, cambioFila, cambioColumna);
                int sum = suma(x1);
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    public static int[][] cambioMatriz(int[][] x, int cambioFila, int cambioColumna) {
        int fila = x.length;
        int columna = x[0].length;
        int[][] x2 = new int[fila][columna];

        for (int i = 0; i < fila; i++) {
            if ((cambioFila & (1 << i)) != 0) {
                for (int j = 0; j < columna; j++) {
                    x2[i][j] = 1 - x[i][j];
                }
            }else 
                x2[i] = x[i].clone();
        }

        for (int j = 0; j < columna; j++) {
            if ((cambioColumna & (1 << j)) != 0) {
                for (int i = 0; i < fila; i++) {
                    x2[i][j] = 1 - x2[i][j];
                }
            }
        }
        return x2;
    }

    public static int suma(int[][] x) {
        int fila = x.length;
        int columna = x[0].length;
        int sum = 0;

        for (int i = 0; i < fila; i++) {
            int sumaFilas = 0;
            for (int j = 0; j < columna; j++) {
                sumaFilas = (sumaFilas << 1) + x[i][j];
            }
            sum += sumaFilas;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int M = input.nextInt();
        int[][] x = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                x[i][j] = input.nextInt();
            }
        }
        input.close();

        int maxSum = sumaMaxima(x);
        System.out.println(maxSum);
    }
}
