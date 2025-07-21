import java.util.Scanner;

class Node{
    String data;
    Node left;
    Node right;
    Node(String data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class ArrangeWordsAsc {
    Node root;
    ArrangeWordsAsc(){
        this.root = null;
    }
    Node insert(Node root, String data){
        Node newNode = new Node(data);
        if(root == null){
            root = newNode;
        }else if(compare(root.data, data) == -1){
            root.left = insert(root.left, data);
        }else{
            root.right = insert(root.right, data);
        }
        return root;
    }
    int compare(String s1, String s2){
        int i=0;
        while(i<s1.length() && i<s2.length()){
            if(s1.charAt(i)<s2.charAt(i)){
                return 1;
            }else if(s1.charAt(i)>s2.charAt(i)){
                return -1;
            }
            i++;
        }
        if(s1.length() < s2.length()){
            return 1;
        }
        return -1;
    }
    void inorder(Node root){
        if(root == null)
            return;
        
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public static void main(String[] args) {
        ArrangeWordsAsc tree = new ArrangeWordsAsc();

        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String word = "";
        for(int i=0; i<line.length(); ){
            word = "";
            while(i<line.length() && line.charAt(i)!=' '){
                word += line.charAt(i);
                i++;
            }
            while(i<line.length() && line.charAt(i) == ' '){
                i++;
            }
            tree.root= tree.insert(tree.root, word);
        }
        tree.inorder(tree.root);
    }
}
