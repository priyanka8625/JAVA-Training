import java.util.List;

public class SwapNumbers {
    static int a = 10;
    static int b = 5;
    public static void main(String[] args) {
        //swap the numbers without using temp and arithmetic operations
        swap(a, b);
        System.out.println(a + " " + b);
    }
    static void swap(int a, int b){
        SwapNumbers.a = b;
        SwapNumbers.b = a;
    }
}
