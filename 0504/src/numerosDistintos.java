import java.util.Scanner;
import java.util.*;
public class numerosDistintos {
    
    static void numerosDiferentes(int[] n){
        Arrays.sort(n);
        int contador = 1;
        for(int i = 0; i < n.length-1; i++){
            if(n[i] != n[i+1]){
                contador++;
            }
        }
        System.out.println(contador);
    }
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = input.nextInt();
        }
        numerosDiferentes(arr);
    }
}