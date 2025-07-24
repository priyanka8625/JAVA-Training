import java.util.Scanner;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class Prg2ReverseLinkedList {
    Node head;
    Prg2ReverseLinkedList(){
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
    void reverse(){
        Node prev=null, curr=head, next=null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    void print(){
        Node curr = head;
        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Prg2ReverseLinkedList l = new Prg2ReverseLinkedList();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter nodes: ");
        String[] nodes = sc.nextLine().split(" ");
        for(String node : nodes){
            l.addNode(Integer.parseInt(node));
        }
        l.reverse();
        l.print();
    }
}
