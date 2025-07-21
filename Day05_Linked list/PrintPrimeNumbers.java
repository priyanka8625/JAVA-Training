import java.util.Scanner;

public class PrintPrimeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str[] = sc.nextLine().split(" ");

        int[] arr = new int[str.length];
        int i=0;
        for(String s : str){
            arr[i] = Integer.parseInt(s);
            i++;
        }
        printPrimeNumbers(arr);
        sc.close();
    }
    public static void printPrimeNumbers(int[] arr){
        LinkedList list = new LinkedList();

        for(int i=0; i<arr.length; i++){
            list.insertAtEnd(arr[i]);
        }

        for(int i=0; i<arr.length; i++){
            if(!isPrime(arr[i])){
                list.delete(arr[i]);
            }
        }
        System.out.println("Prime numbers: ");
        list.display();
    }
    static boolean isPrime(int num){
        for(int i=2; i<=num/2; i++){
            if(num%i==0)
                return false;
        }
        return true;
    }
}

class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

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

    void update(int oldData, int newData){
        if(head == null){
            System.out.println(oldData+" not found!");
            return;
        }
        Node current = head;
        while(current != null && current.data != oldData)
            current = current.next;

        if(current != null){
            current.data = newData;
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
        }else{
            System.out.println(data + " not found!");
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
        Node prev = null, curr=head, next=null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
}
