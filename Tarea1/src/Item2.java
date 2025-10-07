import java.util.*;
import java.io.*;
public class Item2 { //Escribir un programa que permita crear un subarreglo recursivo de un arreglo de longitud n, dado el punto de partida y la longitud del subarreglo.
    public static void subArreglo(int[] arr, int[] sub, int m, int s, int i){
        if(s == 1){
            sub[i] = arr[m];
            return;
        }
        sub[i] = arr[m];
        m = (m + 1) % arr.length;
        subArreglo(arr, sub, m, s-1, i+1);
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int M = input.nextInt();
        int S = input.nextInt();
        int[] arr = new int[N];
        int[] subArr = new int[S];
        for(int i = 0; i < N; i++){
            arr[i] = input.nextInt();
        }
        input.close();
        subArreglo(arr, subArr, M, S, 0);
        for(int n : subArr){ //Leer arreglo
            System.out.print(n + " ");
        }
    }
}