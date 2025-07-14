import java.util.Scanner;

public class Length {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println(count(name));
        sc.close();
    }
    static int count(String name){
        int i=0;
        try{
            while(name.charAt(i) != '\n'){
                i++;
            }
        }catch(StringIndexOutOfBoundsException e){
            return i;
        }
        return 0;
    }
}
