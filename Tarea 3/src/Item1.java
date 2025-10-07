import java.util.*;
import java.io.*;

public class Item1 {
    public static int sumaMax(int arr[], int l, int r) {
        if(l == r){
            return arr[l];
        }else{
            int mid = (l + r) / 2;
            //Metodo Divide and Conquer.
            int sumaMaxL = sumaMax(arr, l, mid);
            int sumaMaxR = sumaMax(arr, mid + 1, r);
            int sumaMaxMid = sumaMaxM(arr, l, r, mid);
            //Comparar que suma es la maxima.
            return Math.max(Math.max(sumaMaxL,sumaMaxR), sumaMaxMid);
        }
    }
    public static int sumaMaxM(int arr[], int l, int r, int m) {
        int sumaL = 0;
        int sumaR = 0;
        int aux = 0;
        for(int i = m; i >= l; i--){
            aux += arr[i];
            sumaL = Math.max(sumaL, aux);
        }
        aux = 0;
        for(int i = m+1; i <= r; i++){
            aux += arr[i];
            sumaR = Math.max(sumaR, aux);
        }
        return sumaL + sumaR;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int x[] = new int[N];
        for(int i = 0; i < N; i++){
            x[i] = input.nextInt();
        }
        input.close();
        int mayorInterferencia = sumaMax(x, 0, N-1);

        System.out.print(mayorInterferencia);
    }
}