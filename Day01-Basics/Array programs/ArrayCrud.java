import java.util.Scanner;

public class ArrayCrud {
    static int next, n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter no of elements: ");
        n = Integer.parseInt(sc.nextLine());

        int[] arr = new int[n];
        next = 0;

        while(true){
            System.out.println("\n----------------------\nEnter choice: ");
            System.out.println("1. INSERT \n2. DELETE \n3.UPDATE \n4. READ\n5. DISPLAY\n6. EXIT\n-----------------------");
            int ch = Integer.parseInt(sc.nextLine());
            switch(ch){
                case 1:
                    System.out.println("\nEnter element to insert: ");
                    int num = Integer.parseInt(sc.nextLine());
                    insert(arr, num);
                    break;
                case 2:
                    System.out.println("\nEnter element to delete: ");
                    num = Integer.parseInt(sc.nextLine());
                    delete(arr, num);
                    break;
                case 3:
                    System.out.println("\nEnter old value to update: ");
                    int old = Integer.parseInt(sc.nextLine());
                    System.out.println("Enter new value: ");
                    num = Integer.parseInt(sc.nextLine());
                    update(arr, old, num);
                    break;
                case 4:
                    System.out.println("\nEnter element to find: ");
                    num = Integer.parseInt(sc.nextLine());
                    find(arr, num);
                    break;
                case 5:
                    display(arr);
                    break;
                case 6: 
                    System.out.println("Thank you!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter valid choice!");
            }
        }
    }
    static void insert(int[] arr, int num){
        if(next == n){
            System.out.println("Array is FULL!");
            return;
        }
        arr[next++] = num;
        System.out.println("Element inserted!");
    }
    static void delete(int[] arr, int num){
        if(next==0){
            System.out.println("Array is EMPTY!");
            return;
        }
        for(int i=0; i<next; i++){
            if(arr[i] == num){
                //shift values to left
                for(int j=i; j<next-1; j++){
                    arr[j] = arr[j+1];
                }
                arr[next-1] = -1;//default value
                next--;//next empty slot
                System.out.println("Element "+num+" deleted!");
                return;
            }
        }
    }
    static void update(int[] arr, int old, int newele){
        if(next==0){
            System.out.println("Array is EMPTY!");
            return;
        }
        for(int i=0; i<next; i++){
            if(arr[i] == old){
                arr[i] = newele;
                System.out.println("Element "+old+" updated!");
                return;
            }
        }
    }
    static void find(int[] arr, int num){
        if(next==0){
            System.out.println("Array is EMPTY!");
            return;
        }
        for(int i=0; i<next; i++){
            if(arr[i] == num){
                System.out.println("Element "+num+" found at "+i+" index!");
                return;
            }
        }
    }
    static void display(int[] arr){
        if(next==0){
            System.out.println("Array is EMPTY!");
            return;
        }
        for(int i=0; i<next; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
