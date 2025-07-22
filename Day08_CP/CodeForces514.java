import java.util.Scanner;

public class CodeForces514 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        System.out.println(solve(n));
    }
    static String solve(String n){
        StringBuilder res = new StringBuilder();
        for(int i=0; i<n.length(); i++){
            int digit = n.charAt(i)-'0';
            if(i==0 && digit == 9){
                res.append(digit);
            }else if(9-digit < digit){
                res.append(9-digit);
            }else{
                res.append(digit);
            }
        }
        return res.toString();
    }
}
