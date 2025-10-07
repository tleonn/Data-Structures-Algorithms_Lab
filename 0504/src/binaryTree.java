public class binaryTree {
    static class Node {
        int value;
        Node left;
        Node right;
        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    static class BT {
        Node root;
        BT(int value) {
            root = new Node(value);
        }
        BT() {
            root = null;
        }
        public boolean search(int value){
            return search(value, this.root);
        }
        public boolean search(int value, Node tree) {
            if(tree == null) {
                return false;
            }
            if(tree.value == value) {
                return true;
            }
            if(tree.value > value) {
                return search(value, tree.right);
            }else{
                return search(value, tree.left);
            }
        }

        public Node insert(int value) {
            return insert(root, value);
        }
        public Node insert(Node tree, int value) {
            if(tree == null) {
                tree = new Node(value);
                return tree;
            }
            if(tree.value < value) {
                tree.right = insert(tree.right, value);
            }else tree.left = insert(tree.left, value);
            return tree;
        }
    }
    public static void main(String[] args) {
        
    }
}
