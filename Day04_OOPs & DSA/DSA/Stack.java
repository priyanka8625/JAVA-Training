
public class Stack {
    int[] stack;
    int top;
    Stack(int size){
        stack = new int[size];
        top = -1;
    }
    void push(int data){
        if(isFull()){
            System.out.println("Stack overflow!");
            return;
        }
        stack[++top] = data;
    }
    int peek(){
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

    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display();
        System.out.println(stack.peek());
        stack.pop();
        stack.push(40);
        System.out.println(stack.peek());
        stack.pop();
        stack.display();
    }
}
