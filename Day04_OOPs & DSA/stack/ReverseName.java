import java.util.Scanner;

public class ReverseName {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println(reverse(name));
        sc.close();
    }
    static String reverse(String name){
        Stack stack = new Stack(name.length());
        for(int i=0; i<name.length(); i++){
            stack.push(name.charAt(i));
        }
        String rev = "";
        while(!stack.isEmpty()){
            rev += stack.peek();
            stack.pop();
        }
        return rev;
    }
}


class Stack {
    char[] stack;
    int top;
    Stack(int size){
        stack = new char[size];
        top = -1;
    }
    void push(char data){
        if(isFull()){
            System.out.println("Stack overflow!");
            return;
        }
        stack[++top] = data;
    }
    char peek(){
        if(isEmpty()){
            System.out.println("Stack is empty!");
        }
        return stack[top];
    }
    void pop(){
        if(isEmpty()){
            System.out.println("Stack underflow!");
        }
        top--;
    }
    boolean isEmpty(){
        if(top == -1){
            return true;
        }
        return false;
    }
    boolean isFull(){
        if(top == stack.length - 1)
            return true;
        return false;
    }

    void display(){
        for(int i=0; i<=top; i++)
            System.out.print(stack[i] + " ");
        System.out.println();
    }

}
