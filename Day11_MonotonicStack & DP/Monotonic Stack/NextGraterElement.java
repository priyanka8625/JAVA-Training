import java.util.Scanner;
import java.util.Stack;

public class NextGraterElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nums = sc.nextLine().split(" ");
        int[] arr = new int[nums.length];
        int i=0;
        for(String num : nums){
            arr[i++] = Integer.parseInt(num);
        }
        nextGraterElement(arr);
        sc.close();
    }
    static void nextGraterElement(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[arr.length];
        int n = arr.length;
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && st.peek() <= arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nge[i] = -1;
            }else{
                nge[i] = st.peek();
            }
            st.push(arr[i]);
        }
        for(int i=0; i<n; i++){
            System.out.print(nge[i] + " ");
        }
    }
}
