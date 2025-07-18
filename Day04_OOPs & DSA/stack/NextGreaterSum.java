import java.util.Scanner;

public class NextGreaterSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int[] arr = new int[str.length];
        for(int i=0; i<str.length; i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        System.out.println(sum(arr));
        sc.close();
    }
    static int sum(int[] arr){
        Stack stack = new Stack(arr.length);
        int sum = 0, n=arr.length;

        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && stack.peek() <= arr[i])
                stack.pop();
            
            if(stack.isEmpty()){
                sum += -1;
            }else{
                sum += stack.peek();
            }
            stack.push(arr[i]);
        }
        return sum;
    }
}


class Stack {
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
}
