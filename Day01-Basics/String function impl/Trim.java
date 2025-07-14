import java.util.Scanner;

public class Trim {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println(trimString(name));
        sc.close();
    }
    static String trimString(String name){
        String res = "";
        int i=0; 
        while(i<name.length()){
            if(name.charAt(i) == ' ')
                i++;
            else
                break;
        }
        int start=i, end=name.length()-1;
        i=name.length()-1;
        while(i<name.length()){
            if(name.charAt(i) == ' ')
                i--;
            else
                break;
        }
        end = i;

        for(; start<=end; start++){
            res += name.charAt(start);
        }
        return res;
    }
}
