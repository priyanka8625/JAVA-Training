import java.util.Scanner;


public class CountWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println(count(name));
        sc.close();
    }
    static int count(String name){
        int count=0;
        for(int i=0; i<name.length(); i++){
            while(i<name.length() && name.charAt(i) != ' '){
                i++;
            }
            while(i<name.length() && name.charAt(i) == ' '){
                i++;
            }
            count++;
        }
        return count;
    }
}
