import java.util.Scanner;

public class ReverseWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        System.out.println(reverse(line));
        sc.close();
    }
    static String reverse(String line){
        Stack stack = new Stack(line.length());
        String rev = "", word = "";

        for(int i=0; i<line.length(); i++){
            while(i<line.length() && line.charAt(i) != ' '){
                word += line.charAt(i);
                i++;
            }
            stack.push(word);
            word = "";
        }

        while(!stack.isEmpty()){
            rev += stack.peek()+" ";
            stack.pop();
        }
        return rev;
    }
}


class Stack {
    String[] stack;
    int top;
    Stack(int size){
        stack = new String[size];
        top = -1;
    }
    void push(String data){
        if(isFull()){
            System.out.println("Stack overflow!");
            return;
        }
        stack[++top] = data;
    }
    String peek(){
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
