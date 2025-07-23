import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
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

public class LevelOrderBST {
    Node root;
    LevelOrderBST(){
        root = null;
    }
    Node insert(int v, Node root){
        Node newNode = new Node(v);
        if(root == null){
            root = newNode;
            return root;
        }
        if(v < root.data){
            root.left = insert(v, root.left);
        }else{
            root.right = insert(v, root.right);
        }
        return root;
    }
    void bfs(){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        bfsHelper(q);
    }
    void bfsHelper(Queue<Node> q){
        if(q.isEmpty())
            return;
        
        Node curr = q.remove();
        System.out.print(curr.data + " ");

        if(curr.left != null){
            q.add(curr.left);
        }

        if(curr.right != null){
            q.add(curr.right);
        }

        bfsHelper(q);
    }
    void bfs2(){
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                Node curr = q.remove();
                System.out.print(curr.data+" ");

                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);
            }
        }
    }
    void createTree(Scanner sc){
        System.out.println("Enter no. of nodes: ");
        int e = sc.nextInt();
        System.out.println("Enter nodes: ");
        for(int i=0; i<e; i++){
            int u = sc.nextInt();
            root = insert(u, root);
        }
    }
    public static void main(String[] args) {
        LevelOrderBST g = new LevelOrderBST();
        Scanner sc = new Scanner(System.in);

        g.createTree(sc);

        g.bfs();
        System.out.println();
        g.bfs2();
    }
}
