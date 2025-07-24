import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

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

public class Prg1TreeTraversal {
    Node root;

    Prg1TreeTraversal(){
        this.root = null;
    }
    Node insert(int data, Node root){
        Node newNode = new Node(data);
        if(root == null){
            root = newNode;
            return root;
        }

        if(data < root.data){
            root.left = insert(data, root.left);
        }else{
            root.right = insert(data, root.right);
        }
        return root;
    }
    void inorder(Node root){
        List<Integer> nodes = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node curr = q.remove();
            nodes.add(curr.data);
            if(curr.left != null){
                q.add(curr.left);
            }
            if(curr.right != null){
                q.add(curr.right);
            }
        }
        Collections.sort(nodes);
        System.out.println(nodes);
    }

    void preorder(Node root){
        List<Node> nodes = new ArrayList<>();
        nodes.add(root);
        while(!nodes.isEmpty()){

        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Prg1TreeTraversal t = new Prg1TreeTraversal();

        System.out.println("Enter nodes:");
        String[] nodes = sc.nextLine().split(" ");
        for(String node : nodes){
            t.root = t.insert(Integer.parseInt(node), t.root);
        }

        t.inorder(t.root);
    }
}
