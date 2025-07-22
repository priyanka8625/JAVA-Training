import java.util.Scanner;

public class CodeForces158A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nums = sc.nextLine().split(" ");
        int n = Integer.parseInt(nums[0]);
        int k = Integer.parseInt(nums[1]);
        
        String[] eles = sc.nextLine().split(" ");
        int[] scores = new int[n];
        int i=0;
        for(String ele : eles){
            scores[i] = Integer.parseInt(ele);
            i++;
        }

        System.out.println(nextRound(scores, n, k));
    }
    static int nextRound(int[] scores, int n, int k){
        int target = scores[k-1];
        int count = 0;

        for(int i=0; i<n; i++){
            if(scores[i]>0 && scores[i]>=target){
                count++;
            }else{
                break;
            }
        }
        
        return count;
    }
}
