public class SelectionSort {
    static void sort(int[] arr){
        for(int i=0; i<arr.length; i++){
            //find the smallest one and replace with i'th index
            for(int j=i; j<arr.length; j++){
                if(arr[j]<arr[i]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            } 
        }
    }
    static void print(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {10, 67, 50, 30, 20, 15};
        sort(arr);
        print(arr);
    }
}
