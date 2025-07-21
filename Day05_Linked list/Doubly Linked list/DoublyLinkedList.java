
class Node{
    int data;
    Node next;
    Node prev;
    Node(int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class DoublyLinkedList {
    Node head, tail;

    DoublyLinkedList(){
        this.head = null;
        this.tail = null;
    }

    void insert(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    void delete(int data){
        if(head.data == data){
            head = head.next;
            head.prev = null;
        }else if(tail.data == data){
            tail = tail.prev;
            tail.next = null;
        }else{
            Node current = head;
            while(current.next!=null && current.next.data != data){
                current = current.next;
            }
            if(current.next != null){
                current.next = current.next.next;
                current.next.prev = current;
            }else{
                System.out.println(data + " not found!");
            }
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
    void reverse(){
        if(head == null){
            System.out.println("List is empty!");
            return;
        }
        Node current = tail;
        while(current != null){
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.display();
        list.delete(20);
        list.display();
    }
}
