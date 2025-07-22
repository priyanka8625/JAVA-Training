import java.util.Scanner;

public class CodeForces25A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        
        String[] eles = sc.nextLine().split(" ");
        int[] scores = new int[n];
        int i=0;
        for(String ele : eles){
            scores[i] = Integer.parseInt(ele);
            i++;
        }

        System.out.println(iqTest(scores, n));
    }
    static int iqTest(int[] scores, int n){
        int[] parity = new int[2];
        int ans = -1;
        for(int i=0; i<n; i++){
            scores[i] = scores[i]%2;
        }
        int evenCnt = 0, oddCnt=0;
        for(int i=0; i<n; i++){
            if(scores[i]==0){
                evenCnt++;
                parity[0] = i+1;
            }else{
                oddCnt++;
                parity[1] = i+1;
            }
        }
        return (evenCnt<oddCnt)? parity[0] : parity[1];
    }
}
