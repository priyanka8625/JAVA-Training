import java.util.Scanner;

public class StartsWith {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ip = sc.nextLine().split(" ");
        String name = ip[0];
        String str = ip[1];

        System.out.println(strStartsWith(name, str));
        sc.close();
    }
    static boolean strStartsWith(String name, String str){
        int i=0, j=0; 
        while(i<name.length() && j<str.length() && name.charAt(i)==str.charAt(j)){
            i++;
            j++;
        }
        if(j==str.length())
            return true;
        return false;
    }
}
