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

public class ValidBST {
    Node root;
    ValidBST(){
        this.root = null;
    }
    boolean isValidBST(Node root, int minVal, int maxVal){
        if(root == null)
            return true;
        
        if(root.data > minVal && root.data < maxVal){
            return isValidBST(root.left, minVal, root.data) && isValidBST(root.right, root.data, maxVal);
        }

        return false;
    }
    void preorder(Node root){
        if(root == null)
            return;

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args) {
        ValidBST tree = new ValidBST();
        tree.root = new Node(50);
        tree.root.left = new Node(20);
        tree.root.right = new Node(70);
        tree.root.right.left = new Node(60);
        tree.root.right.right = new Node(90);

        tree.preorder(tree.root);
        System.out.println();
        System.out.println(tree.isValidBST(tree.root, Integer.MIN_VALUE, Integer.MAX_VALUE)? "valid" : "invalid");
    }
}
