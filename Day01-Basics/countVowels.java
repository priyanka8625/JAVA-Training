import java.util.Scanner;


public class countVowels{
    public static void main(String a[]){
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println(count(name));
        sc.close();
    }
    static int count(String name){
        int count=0;
        for(int i=0; i<name.length(); i++){
            char ch = name.charAt(i);
            if(ch == 'A' || ch=='E' || ch=='I' || ch=='O' || ch=='U'
                || ch =='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                    count++;
            }
        }
        return count;
    }
}