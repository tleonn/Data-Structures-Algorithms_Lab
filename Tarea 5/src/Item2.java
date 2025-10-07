import java.util.*;
import java.io.*;

class Node {
    int poder;
    String nombre;
    Node left;
    Node right;
    Node(int poder, String nombre) {
        this.poder = poder;
        this.nombre = nombre;
        this.left = null;
        this.right = null;
    }
    Node insert(Node root, int poder, String nombre) {
        if(root == null){
            root = new Node(poder, nombre);
            return root;
        }if(root.poder < poder)
            root.right = insert(root.right, poder, nombre);
        if(root.poder > poder)
            root.left = insert(root.left, poder, nombre);
        return root;
    }
}

public class Item2 {
    static Node Participante(Node root, String p1, String p2) {
        if(root == null || root.nombre.equals(p1) || root.nombre.equals(p2)) 
            return root;
        
        Node participanteIzquierdo = Participante(root.left, p1, p2);
        Node participanteDerecho = Participante(root.right, p1, p2);

        if(participanteIzquierdo == null)
            return participanteDerecho;
        else if(participanteDerecho == null)
            return participanteIzquierdo;
        else
            return root;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        Node Torneo = null;
        for(int i = 0; i < N; i++){
            String nombre = input.next();
            int poder = input.nextInt();
            if(Torneo == null)
                Torneo = new Node(poder, nombre);
            else
                Torneo.insert(Torneo, poder, nombre);
        }
        String p1 = input.next();
        String p2 = input.next();
        System.out.println(Participante(Torneo, p1, p2).nombre);
    }
}
