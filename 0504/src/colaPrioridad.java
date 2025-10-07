import java.util.*;

public class colaPrioridad {
    
    
    public static void main(String[] args) {
        PriorityQueue <Integer> pq = new PriorityQueue<>(
            (a,b) -> a - b //Comparar los valores del arreglo.
        );
        pq.add(1);
        pq.add(7);
        pq.add(3);
        pq.add(10);
        while(!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
        
    }
}
