public class IncrementOperator {
    public static void main(String[] args) {
        // when to use i++ and ++i in for loops
        int i=1, prev=i;
        for(; i<=5; System.out.print(i++ + " ")){
        }
        i=1;
        System.out.println();
        for(; i<=5; System.out.print(++i + " ")){
        }
    }
}
