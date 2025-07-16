import java.util.Scanner;

public class CheckPassword {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(soln2(str)? "Valid" : "Invalid");
    }
    static boolean soln2(String str){
        if(!(str.length()>=8 && str.length()<=15)){
            return false;
        }
        int count = 0, n=str.length();
        for(int i=0; i<n; i++){
            char ch = str.charAt(i);
            if(isUpper(ch)){
                count++;
                break;
            }
        }
        for(int i=0; i<n; i++){
            char ch = str.charAt(i);
            if(isLower(ch)){
                count++;
                break;
            }
        }
        for(int i=0; i<n; i++){
            char ch = str.charAt(i);
            if(isDigit(ch)){
                count++;
                break;
            }
        }
        for(int i=0; i<n; i++){
            char ch = str.charAt(i);
            if(isSpecial(ch)){
                count++;
                break;
            }
        }

        if(count == 4)
            return true;
        return false;
    }
    static boolean isUpper(char ch){
        if(ch>='A' && ch<='Z'){
            return true;
        }
        return false;
    }
    static boolean isLower(char ch){
        if(ch>='a' && ch<='z'){
            return true;
        }
        return false;
    }
    static boolean isDigit(char ch){
        if(ch>='0' && ch<='9'){
            return true;
        }
        return false;
    }
    static boolean isSpecial(char ch){
        if(ch=='@'){
            return true;
        }
        return false;
    }

    
    static boolean soln1(String str){
        if(!(str.length()>=8 && str.length()<=15)){
            return false;
        }
        boolean upper=false, lower=false, digit=false, special=false;
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch>='A' && ch<='Z'){
                upper = true;
            }
            if(ch>='a' && ch<='z'){
                lower = true;
            }
            if(ch>='0' && ch<='9'){
                digit = true;
            }
            if(ch == '@'){
                special = true;
            }
        }
        if(upper && lower && digit && special)
            return true;
        return false;
    }
}
