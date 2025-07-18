import java.util.Scanner;

public class RemoveVowels {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println(removeVowels(name));
        sc.close();
    }
    public static String removeVowels(String name){
        int n = name.length();

        //create linked list from string
        LinkedList list = new LinkedList();
        for(int i=0; i<n; i++){
            char ch = name.charAt(i);
            list.insertAtEnd(ch);
        }

        //remove the vowels
        for(int i=0; i<n; i++){
            char ch = name.charAt(i);
            if(isVowel(ch)){
                list.delete(ch);
            }
        }

        //convert list to string
        return list.getValue();
    }
    public static boolean isVowel(char ch){
        return (ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U' 
                || ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u');
    }
}

class Node{
    char data;
    Node next;

    Node(char data){
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    LinkedList(){
        this.head = null;
    }

    void insertAtEnd(char data){
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

    void insertAtBegin(char data){
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    void insertAtMid(char data, char prevData){
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

    void update(char oldData, char newData){
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

    void delete(char data){
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
    String getValue(){
        if(head == null){
            System.out.println("List is empty!");
            return "";
        }
        Node current = head;
        String res = "";
        while(current != null){
            res += current.data;
            current = current.next;
        }
        return res;
    
    }
    
}

