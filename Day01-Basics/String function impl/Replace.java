import java.util.Scanner;

public class Replace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ip = sc.nextLine().split(" ");
        String name = ip[0];
        char ch = ip[1].charAt(0);
        char newch = ip[2].charAt(0);
        System.out.println(replaceString(name, ch , newch));
        sc.close();
    }
    static String replaceString(String name, char ch, char newch){
        String res = "";
        for(int i=0; i<name.length(); i++){
            char c = name.charAt(i);
            if(c == ch){
                res += newch;
            }else{
                res += c;
            }
        }
        return res;
    }
}
