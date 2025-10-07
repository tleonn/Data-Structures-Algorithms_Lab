import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Item2 {
    static int menor(int[] arr, int i){ //i es la posicion donde se encuentra el numero menor
        int menor = arr[i];
        int j = i;
        for(int k = i; k < arr.length; k++){
            if(menor > arr[k]){ //Se busca el numero menor dentro del arreglo.
                menor = arr[k];
                j = k;
            }
        }
        return j;
    }
    static void ordenar(int[] arr, int start, int end) {
        int left = start;
        int right = end;
        while (left < right) { 
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }    

    static int Volteo(int[] arr){
        int N = arr.length;
        int costo = 0;
        int j = 0;
        for(int i = 0; i < N-1; i++){
            j = menor(arr, i);
            ordenar(arr,i,j);
            costo += j - i + 1;
        }
        return costo;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int[] x = new int[N];
        for(int i = 0; i < N; i++){
            x[i] = input.nextInt();
        }
        System.out.println(Volteo(x));
    }
}