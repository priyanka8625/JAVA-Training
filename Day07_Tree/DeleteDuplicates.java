import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

public class DeleteDuplicates {
    Node root;
    DeleteDuplicates(){
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

    void getDuplicates(Node root, Map<Integer, Integer> freq){
        if(root == null){
            return;
        }
        if(freq.containsKey(root.data)){
            freq.put(root.data, freq.get(root.data)+1);
        }else{
            freq.put(root.data, 1);
        }
        getDuplicates(root.left, freq);
        getDuplicates(root.right, freq);
    }

    Node deleteDuplicates(Node root, Map<Integer, Integer> eles){
        for(int ele : eles.keySet()){
            int freq = eles.get(ele);
            while(freq-- != 1){
                root = delete(root, ele);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        DeleteDuplicates tree = new DeleteDuplicates();
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 75);//
        tree.root = tree.insert(tree.root, 20);//
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 5);
        tree.root = tree.insert(tree.root, 7);
        tree.root = tree.insert(tree.root, 25);
        tree.root = tree.insert(tree.root, 75);
        tree.root = tree.insert(tree.root, 60);//
        tree.root = tree.insert(tree.root, 90);
        tree.root = tree.insert(tree.root, 55);
        tree.root = tree.insert(tree.root, 70);
        tree.root = tree.insert(tree.root, 60);
        tree.root = tree.insert(tree.root, 60);
        tree.root = tree.insert(tree.root, 100);

        tree.preorder(tree.root);
        System.out.println();

        Map<Integer, Integer> eles = new HashMap<>();
        tree.getDuplicates(tree.root, eles);

        System.out.println("Duplicate elements: ");
        for(int ele : eles.keySet()){
            if(eles.get(ele) > 1){
                System.out.print(ele + " ");
            }
        }
        System.out.println();

        tree.root = tree.deleteDuplicates(tree.root, eles);
        tree.preorder(tree.root);
    }
}
