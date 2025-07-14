import java.util.Scanner;

public class IndexOf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ip = sc.nextLine().split(" ");
        String name = ip[0];
        char ch = ip[1].charAt(0);
        System.out.println(strIndexOf(name, ch));
        sc.close();
    }
    static int strIndexOf(String name, char ch){
        for(int i=0; i<name.length(); i++){
            if(name.charAt(i) == ch)
                return i;
        }
        return -1;
    }
}
