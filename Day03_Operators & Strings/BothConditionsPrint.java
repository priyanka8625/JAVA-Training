import java.io.PrintStream;

public class BothConditionsPrint {
    public static void main(String[] args) {
        // execute both if and else with one condition
        System.out.println(System.out.append("hello ").hashCode());
        if(System.out.append("hello ").hashCode() == 1){
            System.out.println("hello");
        }else{
            System.out.println("world");
        }

        if(System.out.append("hello ") == null){
            System.out.println("hello");
        }else{
            System.out.println("world");
        }
        
    }
}
