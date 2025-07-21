class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class BinaryTree {
    Node root;
    BinaryTree(){
        this.root = null;
    }
    Node insert(Node root, int data){
        Node newNode = new Node(data);
        root = newNode;
        return root;
    }
    void preorder(Node root){
        if(root == null)
            return;

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = tree.insert(tree.root, 10);
        tree.root.left = tree.insert(tree.root.left, 20);
        tree.root.right = tree.insert(tree.root.right, 5);
        tree.preorder(tree.root);
    }
}
