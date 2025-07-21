
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

public class BoundaryTraversal {
    Node root;
    BoundaryTraversal(){
        this.root = null;
    }
    void preorder(Node root){
        if(root == null)
            return;

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    Node insert(Node root, int data){
        Node newNode = new Node(data);
        if(root == null){
            root = newNode;
        }else if(data < root.data){
            root.left = insert(root.left, data);
        }else{
            root.right = insert(root.right, data);
        }
        return root;
    }
    void printBoundary(Node root){
        System.out.print(root.data + " ");
        leftMost(root.left);
        leaves(root);
        rightMost(root.right);
    }
    void leftMost(Node root){
        if(root == null)
            return;
        if(root.left == null && root.right == null)
            return;
            
        System.out.print(root.data + " ");
        leftMost(root.left);
    }
    void rightMost(Node root){
        if(root == null)
            return;
        if(root.left == null && root.right == null)
            return;

        rightMost(root.right);
        System.out.print(root.data + " ");
    }
    void leaves(Node root){
        if(root == null)
            return;
        if(root.left==null && root.right==null)
            System.out.print(root.data + " ");

        leaves(root.left);
        leaves(root.right);
    }
    public static void main(String[] args) {
        BoundaryTraversal tree = new BoundaryTraversal();
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 75);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 5);
        tree.root = tree.insert(tree.root, 7);
        tree.root = tree.insert(tree.root, 25);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 60);
        tree.root = tree.insert(tree.root, 90);
        tree.root = tree.insert(tree.root, 55);
        tree.root = tree.insert(tree.root, 70);
        tree.root = tree.insert(tree.root, 80);
        tree.root = tree.insert(tree.root, 100);

        tree.preorder(tree.root);
        System.out.println();

        tree.printBoundary(tree.root);
    }
}
