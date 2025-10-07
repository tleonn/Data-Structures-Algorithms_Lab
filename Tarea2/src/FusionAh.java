import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FusionAh {
    static void fusion(Queue<Integer> q1, Queue<Integer> q2){
        Queue<Integer> aux = new LinkedList<>();
        while(!q1.isEmpty() && !q2.isEmpty()){
            if(q1.peek() < q2.peek()){
                aux.add(q1.poll());
            }else{
                aux.add(q2.poll());
            }
        }
        while(!q1.isEmpty()){
            aux.add(q1.poll());
        }
        while(!q2.isEmpty()){
            aux.add(q2.poll());
        }
        while(!aux.isEmpty()){
            System.out.print(aux.peek() + " ");
            aux.poll();
        }
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Queue<Integer> p1 = new LinkedList<>();
        Queue<Integer> p2 = new LinkedList<>();
        int N1 = input.nextInt();
        for(int i = 0; i < N1; i++){
            int N = input.nextInt();
            p1.add(N);
        }
        int N2 = input.nextInt();
        for(int i = 0; i < N2; i++){
            int N = input.nextInt();
            p2.add(N);
        }
        input.close();
        fusion(p1, p2);
    }
}
