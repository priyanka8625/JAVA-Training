import java.util.Scanner;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class Prg3SortLinkedList {
    Node head;
    Prg3SortLinkedList(){
        this.head = null;
    }
    void addNode(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node curr = head;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = newNode;
    }
    void print(){
        Node curr = head;
        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
    void sort(){
        int n = len();
        for(int i=0; i<n; i++){
            Node curr = head, next = head.next;
            while(next != null){
                if(curr.data > next.data){
                    int temp = curr.data;
                    curr.data = next.data;
                    next.data = temp;
                }
                curr = curr.next;
                next = next.next;
            }
        }
    }
    int len(){
        Node curr = head;
        int n = 0;
        while(curr != null){
            n++;
            curr = curr.next;
        }
        return n;
    }
    public static void main(String[] args) {
        Prg3SortLinkedList l = new Prg3SortLinkedList();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter nodes: ");
        String[] nodes = sc.nextLine().split(" ");
        for(String node : nodes){
            l.addNode(Integer.parseInt(node));
        }
        l.sort();
        l.print();
    }
}
