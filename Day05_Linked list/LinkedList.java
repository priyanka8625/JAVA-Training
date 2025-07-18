
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

    void insertAtEnd(int data){
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

    void insertAtBegin(int data){
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    void insertAtMid(int data, int prevData){
        Node newNode = new Node(data);

        if(head == null){
            System.out.println(prevData+" not found!");
            return;
        }
        Node current = head;
        while(current != null && current.data != prevData)
            current = current.next;

        if(current != null){
            newNode.next = current.next;
            current.next = newNode;
        }
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
        linkedList.insertAtBegin(10);
        linkedList.insertAtMid(20, 10);
        linkedList.insertAtMid(30, 10);
        linkedList.display();
        linkedList.insertAtMid(40, 30);
        linkedList.display();
        
        linkedList.delete(20);
        linkedList.display();
        linkedList.delete(30);
        linkedList.display();
        linkedList.delete(10);
        linkedList.display();
    }
}
