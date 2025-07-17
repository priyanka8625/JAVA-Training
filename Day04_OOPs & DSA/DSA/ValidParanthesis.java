import java.util.Scanner;

public class ValidParanthesis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(isValid(str)? "valid" : "invalid");
        sc.close();
    }
    static boolean isValid(String str){
        Stack stack = new Stack(str.length());
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch == '(' || ch=='[' || ch=='{'){
                stack.push(ch);
            }else{
                if(!stack.isEmpty() && (ch==')' && stack.peek()=='(') || (ch==']' && stack.peek()=='[') || (ch=='}' && stack.peek()=='{')){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        if(stack.isEmpty())
            return true;
        return false;
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
