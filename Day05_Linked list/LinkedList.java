
public class LinkedList {
    Node head;

    class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    LinkedList(){
        this.head = null;
    }

    void insert(int data){
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            return;
        }

        Node current = head;
        while(current.next != null)
            current = current.next;
        current.next = newNode;
    }

    void delete(int data){
        if(head == null){
            System.out.println("List is empty!");
            return;
        }

        if(head.data == data){
            head = head.next;
            return;
        }

        Node current = head;
        while(current.next != null && current.next.data != data){
            current = current.next;
        }
        if(current.next != null){
            current.next = current.next.next;
        }
    }

    void display(){
        if(head == null){
            System.out.println("List is empty!");
            return;
        }
        Node current = head;
        while(current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(10);
        linkedList.insert(20);
        linkedList.insert(30);
        linkedList.display();
        linkedList.delete(20);
        linkedList.display();
        linkedList.delete(30);
        linkedList.display();
        linkedList.delete(10);
        linkedList.display();
    }
}
