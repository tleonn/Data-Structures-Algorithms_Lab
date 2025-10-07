import java.util.*;
import java.io.*;

class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

class ReconstruccionPreOrder{
    public static Node reconstruccion(int[] inOrder, int[] postOrder) {
        if (inOrder.length != postOrder.length || inOrder.length == 0) //Verificar los tamanios para evitar errores
            return null;

        return reconstruccionArbol(inOrder, 0, inOrder.length - 1, postOrder, 0, postOrder.length - 1);
    }

    private static Node reconstruccionArbol(int[] inOrder, int inicioInOrder, int finalInOrder, int[] postOrder, int inicioPostOrder, int finalPostOrder) {
        if (inicioInOrder > finalInOrder || inicioPostOrder > finalPostOrder)
            return null;

        int rootValue = postOrder[finalPostOrder];
        Node root = new Node(rootValue);

        int indiceRaiz = -1;
        for (int i = inicioInOrder; i <= finalInOrder; i++) {
            if (inOrder[i] == rootValue) {
                indiceRaiz = i;
                break;
            }
        }
        int valoresIzquierda = indiceRaiz - inicioInOrder;

        //Reconstruccion del arbol preOrder
        root.left = reconstruccionArbol(inOrder, inicioInOrder, indiceRaiz - 1, postOrder, inicioPostOrder, inicioPostOrder + valoresIzquierda - 1);
        root.right = reconstruccionArbol(inOrder, indiceRaiz + 1, finalInOrder, postOrder, inicioPostOrder + valoresIzquierda, finalPostOrder - 1);

        return root;
    }

    public static void preOrder(Node root) {
        if (root == null)
            return;

        System.out.print(root.value + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
}

public class Item1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();

        int[] inOrder = new int[N];
        int[] postOrder = new int[N];

        for (int i = 0; i < N; i++)
            inOrder[i] = input.nextInt();

        for (int i = 0; i < N; i++)
            postOrder[i] = input.nextInt();

        input.close();
        Node root = ReconstruccionPreOrder.reconstruccion(inOrder, postOrder);
        ReconstruccionPreOrder.preOrder(root);
    }
}