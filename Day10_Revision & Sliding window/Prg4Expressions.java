import java.util.Scanner;

class Stack{
    int top;
    int size;
    char[] stack;
    Stack(int size){
        this.size = size;
        this.top = -1;
        this.stack = new char[size];
    }
    void push(char data){
        if(top == size-1){
            System.out.println("Overflow");
            return;
        }
        stack[++top] = data;
    }
    void pop(){
        if(top == -1){
            System.out.println("Underflow");
            return;
        }
        top--;
    }
    char peek(){
        if(top == -1){
            System.out.println("Underflow");
            return '0';
        }
        return stack[top];
    }
    boolean isEmpty(){
        if(top == -1){
            return true;
        }
        return false;
    }
}
public class Prg4Expressions {

    void infixToPostFix(String infix){
        Stack stack = new Stack(infix.length());
        StringBuilder postfix = new StringBuilder();

        for(int i=0; i<infix.length(); i++){
            char ch = infix.charAt(i);
            if(ch >='a' && ch<='z'){
                postfix.append(ch);
            }else{
                if(ch == '('){
                    stack.push(ch);
                }else if(ch == ')'){
                    while(!stack.isEmpty() && stack.peek() != '('){
                        postfix.append(stack.peek());
                        stack.pop();
                    }
                    stack.pop();
                }else{
                    // always pop higher or equal precedance stack elements than curr char
                    while(!stack.isEmpty() && getValue(ch) <= getValue(stack.peek()) ){
                        postfix.append(stack.peek());
                        stack.pop();
                    }
                    stack.push(ch);
                }
            }
        }

        while(!stack.isEmpty()){
            postfix.append(stack.peek());
            stack.pop();
        }
        
        System.out.println(postfix);
    }
    void infixToPrefix(String infix){
        Stack stack = new Stack(infix.length());
        StringBuilder ans = new StringBuilder();
        int n = infix.length();

        for(int i=n-1; i>=0; i--){
            char ch = infix.charAt(i);
            if(ch >= 'a' && ch <= 'z'){
                ans.insert(0, ch);
            }else {
                if(ch == ')'){
                    stack.push(ch);
                }else if(ch == '('){
                    while(!stack.isEmpty() && stack.peek() != ')'){
                        ans.insert(0, stack.peek());
                        stack.pop();
                    }
                    stack.pop();
                }else{
                    while(!stack.isEmpty() && getValue(ch) <= getValue(stack.peek())){
                        ans.insert(0, stack.peek());
                        stack.pop();
                    }
                    stack.push(ch);
                }
            }
        }
        while(!stack.isEmpty()){
            ans.insert(0, stack.peek());
            stack.pop();
        }
        System.out.println(ans);
    }
    int getValue( char ch){
        if(ch == '^'){
            return 10;
        }
        if(ch == '*' || ch == '/'){
            return 8;
        }
        if(ch == '+' || ch == '-' ){
            return 5;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String infix = sc.nextLine();
        Prg4Expressions p = new Prg4Expressions();
        p.infixToPostFix(infix);
        p.infixToPrefix(infix);
    }
}
