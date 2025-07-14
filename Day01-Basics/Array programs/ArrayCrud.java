import java.util.Scanner;

public class ArrayCrud {
    int next, n;
    ArrayCrud(int size){
        this.n = size;
        this.next = 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter no of elements: ");
        int size = Integer.parseInt(sc.nextLine());
        ArrayCrud obj = new ArrayCrud(size);

        int[] arr = new int[size];

        while(true){
            System.out.println("\n----------------------\nEnter choice: ");
            System.out.println("1. INSERT \n2. DELETE \n3. UPDATE \n4. READ\n5. DISPLAY\n6. EXIT\n-----------------------");
            int ch = Integer.parseInt(sc.nextLine());
            switch(ch){
                case 1:
                    System.out.println("\nEnter element to insert: ");
                    int num = Integer.parseInt(sc.nextLine());
                    obj.insert(arr, num);
                    break;
                case 2:
                    System.out.println("\nEnter element to delete: ");
                    num = Integer.parseInt(sc.nextLine());
                    obj.delete(arr, num);
                    break;
                case 3:
                    System.out.println("\nEnter old value to update: ");
                    int old = Integer.parseInt(sc.nextLine());
                    System.out.println("Enter new value: ");
                    num = Integer.parseInt(sc.nextLine());
                    obj.update(arr, old, num);
                    break;
                case 4:
                    System.out.println("\nEnter element to find: ");
                    num = Integer.parseInt(sc.nextLine());
                    obj.find(arr, num);
                    break;
                case 5:
                    obj.display(arr);
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
    void insert(int[] arr, int num){
        if(next == n){
            System.out.println("Array is FULL!");
            return;
        }
        arr[next++] = num;
        System.out.println("Element inserted!");
    }
    void delete(int[] arr, int num){
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
                n--;
                System.out.println("Element "+num+" deleted!");
                return;
            }
        }
    }
    void update(int[] arr, int old, int newele){
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
    void find(int[] arr, int num){
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
     void display(int[] arr){
        if(next==0){
            System.out.println("Array is EMPTY!");
            return;
        }
        for(int i=0; i<next; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
