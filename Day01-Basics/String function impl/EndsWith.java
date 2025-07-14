import java.util.Scanner;

public class EndsWith {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ip = sc.nextLine().split(" ");
        String name = ip[0];
        String str = ip[1];

        System.out.println(strEndsWith(name, str));
        sc.close();
    }
    static boolean strEndsWith(String name, String str){
        int i=name.length()-1, j=str.length()-1; 
        while(i>=0 && j>=0 && name.charAt(i)==str.charAt(j)){
            i--;
            j--;
        }
        if(j==-1)
            return true;
        return false;
    }
}
