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

public class DeleteRangeOfEles {
    Node root;
    DeleteRangeOfEles(){
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
        if(root == null)
            return null;
        if(data < root.data){
            root.left = delete(root.left, data);
        }else if(data > root.data){
            root.right = delete(root.right, data);
        }else{
            if(root.left == null)
                return root.right;
            if(root.right == null)
                return root.left;
            
            root.data = min(root.right);
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

    Node deleteInRange(Node root, int start, int end){
        while(start<=end){
            root = delete(root, start);
            start++;
        }
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
        DeleteRangeOfEles tree = new DeleteRangeOfEles();
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 75);
        tree.root = tree.insert(tree.root, 5);
        tree.root = tree.insert(tree.root, 7);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 25);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 60);
        tree.root = tree.insert(tree.root, 90);

        tree.preorder(tree.root);
        System.out.println();
        
        tree.root = tree.deleteInRange(tree.root, 30, 60);

        tree.preorder(tree.root);
    }
}
