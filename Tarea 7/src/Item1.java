import java.util.*;
import java.io.*;

public class Item1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int K = input.nextInt();

        int[] edades = new int[N];

        for (int i = 0; i < N; i++) {
            edades[i] = input.nextInt();
        }
        input.close();
        
        Arrays.sort(edades); //Ordenar ascendente
        int edadSignificativaMinima = Integer.MAX_VALUE;
        for (int i = 0; i <= N - K; i++) {
            int edadSignificativa = edades[i + K - 1] - edades[i]; //Restar la menor y mayor edad
            if (edadSignificativa < edadSignificativaMinima) //Verificar si la edadSignificativa es menor que la minima, de lo contrario se deben cambiar.
                edadSignificativaMinima = edadSignificativa;
        }
        System.out.print(edadSignificativaMinima);
    }
}
