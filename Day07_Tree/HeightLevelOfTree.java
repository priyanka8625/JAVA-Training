import java.util.ArrayList;
import java.util.List;

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

public class HeightLevelOfTree {
    Node root;
    HeightLevelOfTree(){
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
    int height(Node root){
        if(root == null)
            return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
    void level(Node root, List<List<Integer>> levels, int level){
        if(root == null)
            return;
        levels.get(level).add(root.data);
        level(root.left, levels, level+1);
        level(root.right, levels, level+1);
    }
    public static void main(String[] args) {
        HeightLevelOfTree tree = new HeightLevelOfTree();
        tree.root = tree.insert(tree.root, 55);
        tree.root = tree.insert(tree.root, 75);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 13);
        tree.preorder(tree.root);
        System.out.println();

        int height = tree.height(tree.root);
        System.out.println("Height : "+height);

        List<List<Integer>> levels = new ArrayList<>(height);
        for(int i=0; i<height; i++){
            levels.add(new ArrayList<>());
        }

        tree.level(tree.root, levels, 0);
        for(int i=0; i<height; i++){
            System.out.println("Level "+i+": "+levels.get(i));
        }
    }
}
