import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.util.Stack;

public class MaxArea {
    public static int maxArea(int[] n) {
    int maxArea = 0;
    Stack<Integer> s = new Stack<>();
    for (int i = 0; i <= n.length; i++) {
        int altura;
        if(i == n.length){
            altura = 0;
        }else{
            altura = n[i];
        }
        while (!s.isEmpty() && altura < n[s.peek()]) {
            int top = s.pop();
            int ancho;
            if(s.isEmpty()){
                ancho = i;
            }else{
                ancho = i - s.peek() - 1;
            }
            int area = n[top] * ancho;
            maxArea = Math.max(maxArea, area);
        }
        s.push(i);
    }
    return maxArea;
}


    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int[] casas = new int[N];
        for(int i = 0; i < N; i++){
            int Ni = input.nextInt();
            casas[i] = Ni;
        }
        System.out.println(maxArea(casas));
    }    
}
