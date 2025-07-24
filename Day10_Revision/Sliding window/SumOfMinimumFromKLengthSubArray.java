import java.util.Scanner;

public class SumOfMinimumFromKLengthSubArray {
    static int sumOfMinimumFromKLengthSubArray(int[] nums, int k){
        int sum=0, n=nums.length, left=0, right=k-1, min=Integer.MAX_VALUE;
        while(right<n){
            min = min(nums, left, right);
            sum += min;
            left++;
            right++;
        }
        return sum;
    }
    static int min(int[] nums, int left, int right){
        int min = Integer.MAX_VALUE;
        while(left<=right){
            min = Math.min(nums[left++], min);
        }
        return min;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int[] nums = new int[str.length];
        int i=0;
        for(String s : str){
            nums[i++] = Integer.parseInt(s);
        }
        int k = sc.nextInt();

        System.out.println(sumOfMinimumFromKLengthSubArray(nums, k));
    }
}
