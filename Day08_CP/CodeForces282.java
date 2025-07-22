import java.util.Scanner;

public class CodeForces282 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        String[] ins = new String[n];
        for(int i=0; i<n; i++){
            ins[i] = sc.nextLine();
        }
        System.out.println(solve(ins, n));
    }
    static int solve(String[] ins, int n){
        int res = 0;
        for(String s : ins){
            if(isIncrement(s)){
                res++;
            }else{
                res--;
            }
        }
        return res;
    }
    static boolean isIncrement(String s){
        if(s.charAt(0)=='+' || s.charAt(s.length()-1)=='+')
            return true;
        return false;
    }
}
