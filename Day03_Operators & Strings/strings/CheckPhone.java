import java.util.Scanner;

public class CheckPhone {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long number = Long.parseLong(sc.nextLine());
        System.out.println(soln1(number)? "Valid" : "Invalid");
    }
    static boolean soln1(long number){
        int len = length(number);
        if(len<=0 || len>10){
            return false;
        }

        //check the first number
        long first = number / ((long)Math.pow(10, len-1));
        if(first>=6 && first<=9){
            return true;
        }
        return false;
    }
    static int length(long number){
        int len = 0;
        while(number>0){
            len++;
            number /= 10;
        }
        return len;
    }
}
