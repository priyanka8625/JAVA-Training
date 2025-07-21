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

class TreeOperations{
    Node root;
    TreeOperations(){
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
    void inorder(Node root){
        if(root == null)
            return;
        
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    void printEven(Node root){
        if(root == null)
            return;
        if(root.data % 2 == 0){
            System.out.print(root.data + " ");
        }
        printEven(root.left);
        printEven(root.right);
    }
    void printOdd(Node root){
        if(root == null)
            return;
        if(root.data % 2 != 0){
            System.out.print(root.data + " ");
        }
        printOdd(root.left);
        printOdd(root.right);
    }
    void printPrime(Node root){
        if(root == null)
            return;
        if(isPrime(root.data)){
            System.out.print(root.data + " ");
        }
        printPrime(root.left);
        printPrime(root.right);
    }
    boolean isPrime(int data){
        for(int i=2; i<=data/2; i++){
            if(data % i == 0)
                return false;
        }
        return true;
    }
    int sumOfAllEven(Node root){
        if(root == null)
            return 0;
        int count = 0;
        if(root.data % 2 == 0){
            count = root.data;
        }
        count += sumOfAllEven(root.left);
        count += sumOfAllEven(root.right);
        return count;
    }
    int sumOfAllOdd(Node root){
        if(root == null)
            return 0;
        int count = 0;
        if(root.data % 2 != 0){
            count = root.data;
        }
        count += sumOfAllOdd(root.left);
        count += sumOfAllOdd(root.right);
        return count;
    }
    public static void main(String[] args) {
        TreeOperations tree = new TreeOperations();
        tree.root = tree.insert(tree.root, 55);
        tree.root = tree.insert(tree.root, 75);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 13);
        tree.inorder(tree.root);
        System.out.println();
        tree.printEven(tree.root);
        System.out.println();
        tree.printOdd(tree.root);
        System.out.println();
        tree.printPrime(tree.root);
        System.out.println();
        System.out.println("sum of all even: "+tree.sumOfAllEven(tree.root));
        System.out.println("sum of all odd: "+tree.sumOfAllOdd(tree.root));
    }
}