import java.util.Stack;

public class MoveZerosToEnd {
    public static void main(String[] args) {
        int arr[] = {1, 0, 5, 0, 2, 3, 0, 0};
        soln3(arr);
    }
    static void soln3(int[] arr){
        int start=0, end=arr.length-1;
        while(start<=end){
            while(start<end && arr[start]!=0)
                start++;
            while(start<end && arr[end]==0)
                end--;

            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
        print(arr);
    }
    static void soln1(int[] arr){
        int next=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == 0)
                continue;
            arr[next] = arr[i];
            next++;
        }
        while(next<arr.length){
            arr[next] = 0;
            next++;
        }
        print(arr);
    }
    static void soln2(int[] arr){
        int index = 0;
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<arr.length; i++){
            if(arr[i] == 0){
                continue;
            }else{
                st.push(arr[i]);
                index++;
            }
        }
        int i=index-1;
        while(i>=0){
            arr[i--] = st.peek();
            st.pop();
        }
        i = index;
        while(i<arr.length){
            arr[i++] = 0;
        }
        print(arr);
    }
    static void reverse(int[] arr, int last){
        int start=0, end=last-1;
        while(start<=end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    static void print(int[] arr){
        for(int i=0; i<arr.length; i++)
            System.out.print(arr[i] + " ");
    }
    
}
