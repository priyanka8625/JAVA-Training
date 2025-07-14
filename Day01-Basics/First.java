public class First{
    public static void main(String a[]){
        int start=21, end=40;
        while(start<=end){
            if(isPrime(start)){
                System.out.println(start);
            }
            start++;
        }
    }
    static boolean isPrime(int num){
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num%i == 0)
                return false;
        }
        return true;
    }
}