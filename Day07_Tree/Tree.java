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
public class Tree {
    Node root;
    Tree(){
        this.root = null;
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
    Node delete(Node root, int data){
        if(root == null){
            return null;
        }
        if(data < root.data){
            //find the node at left
            root.left = delete(root.left, data);
        }else if(data > root.data){
            //find in right part
            root.right = delete(root.right, data);
        }else{
            //node found
            //if the left subtree is null, replace root directly with right or vice versa
            if(root.left == null)
                return root.right;
            if(root.right == null)
                return root.left;
            
            //if both subtrees are present, we have two ways to delete the curr root
            //1. replace the root with the smallest ele from right subtree
            //2. replace the root with the largest ele from left subtree
            //let's go with the 1st way
            root.data = min(root.right);//copy smallest one's data

            //now delete the minimum from right subtree to avoid duplicates
            root.right = delete(root.right, root.data);
        }
        return root;
    }
    int min(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root.data;
    }
    void inorder(Node root){
        if(root == null)
            return;
        
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    void preorder(Node root){
        if(root == null)
            return;

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    void postorder(Node root){
        if(root == null)
            return;

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }
    boolean search(Node root, int data){
        if(root==null)
            return false;
        if(root.data == data)
            return true;
        if(data < root.data){
            return search(root.left, data);
        }
        return search(root.right, data);
    }
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 25);
        tree.root = tree.insert(tree.root, 15);
        tree.root = tree.insert(tree.root, 5);
        tree.root = tree.insert(tree.root, 2);
        tree.preorder(tree.root);
        System.out.println();
        System.out.println(tree.search(tree.root, 2)? "Found!":"Not found!");
        System.out.println(tree.search(tree.root, 200)? "Found!":"Not found!");
        
        tree.root = tree.delete(tree.root, 5);
        tree.preorder(tree.root);
    }
}
