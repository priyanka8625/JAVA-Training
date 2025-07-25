import java.util.Scanner;

public class SumOfMaximumFromKLengthSubArray {
    static int sumOfMaximumFromKLengthSubArray(int[] nums, int k){
        int sum=0, n=nums.length, left=0, right=k-1, max=Integer.MIN_VALUE;
        while(right<n){
            max = max(nums, left, right);
            sum += max;
            left++;
            right++;
        }
        return sum;
    }
    static int max(int[] nums, int left, int right){
        int max = Integer.MIN_VALUE;
        while(left<=right){
            max = Math.max(nums[left++], max);
        }
        return max;
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

        System.out.println(sumOfMaximumFromKLengthSubArray(nums, k));
    }
}
