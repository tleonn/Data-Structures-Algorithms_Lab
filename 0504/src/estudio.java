import java.io.IOException;
import java.util.*;
import java.util.*;
public class estudio{
    public static class Node {
        int val;
        Node next;

        Node(int x){
            this.val = x;
            this.next = null;
        }
        Node(int x, Node next){
            this.val = x;
            this.next = next;
        }
        public void readNode(Node n){
            while(n != null){
                System.out.println(n.val);
                n = n.next;
            }
        }
    }

    public static Node F2(Node head){
        if(head == null){
            return head;
        }
        Node first = head;
        Node second = head.next;
        Node prev = null;
        while(first != null && second != null){
            Node temp = second.next;
            if(head == first){
                head = second;
                second.next = first;
                first.next = temp;
            }
            if(prev != null){
                prev.next = second;
            }
            prev = first;
            first = first.next;
            if(first != null){
                second = first.next;
            }
        }
        return head;
    }
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);
        Node n1 = new Node(1);
        Node n2 = new Node(2,n1);
        Node n3 = new Node(2,n2);
        Node n4 = new Node(1,n3);
        n4.readNode(n4);
        System.out.println();
        Node n5 = F2(n4);
        n5.readNode(n5);
        int mas = Integer.parseInt("+");
        System.out.println("\n " + mas);
    }   
}