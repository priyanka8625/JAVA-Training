import java.util.Scanner;

public class CodeForces155A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        String[] nums = sc.nextLine().split(" ");
        int[] arr = new int[nums.length];
        int i=0;
        for(String num : nums){
            arr[i++] = Integer.parseInt(num);
        }

        System.out.println(solve(arr, n));
    }
    static int solve(int[] arr, int n){
        int min=arr[0], max=arr[0], count=0;
        for(int i=1; i<n; i++){
            if(arr[i] > max){
                count ++;
                max = arr[i];
            }
            if(arr[i] < min){
                count++;
                min = arr[i];
            }
        }
        return count;
    }
}
