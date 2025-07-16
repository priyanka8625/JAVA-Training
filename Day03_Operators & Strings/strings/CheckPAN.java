import java.util.Scanner;

public class CheckPAN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String number = sc.nextLine();
        System.out.println(soln1(number)? "Valid" : "Invalid");
    }
    static boolean soln2(String number){
        int len = number.length();
        if(len<=0 || len>10){
            return false;
        }

        int count = 0, index=0;

        while(index<len && isAlpha(number.charAt(index))){
            count++;
            index++;
        }
        if(count != 5)
            return false;
        
        count = 0;
        while(index<len && isDigit(number.charAt(index))){
            count++;
            index++;
        }
        if(count != 4)
            return false;
        
        if(isAlpha(number.charAt(index)))
            return true;
        return false;
    }
    static boolean soln1(String number){
        int len = number.length();
        if(len<=0 || len>10){
            return false;
        }

        int index=0;

        while(index<len && isAlpha(number.charAt(index)))
            index++;

        if(index != 5)
            return false;

        while(index<len && isDigit(number.charAt(index)))
            index++;
        
        if(index != 9)
            return false;
        
        if(isAlpha(number.charAt(index)))
            return true;
        return false;
    }
    static boolean isAlpha(char ch){
        if(ch>='A' && ch<='Z'){
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
}
