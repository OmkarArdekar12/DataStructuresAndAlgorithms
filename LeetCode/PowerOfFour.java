// Power of Four

public class PowerOfFour {
    public static boolean isPowerOfFour(int n) {
        if(n <= 0) {
            return false;
        }
        return (Math.log10(n) / Math.log10(4)) % 1 == 0;
        
        // if(n <= 0) {
        //     return false;
        // }
        // while(n % 4 == 0) {
        //     n /= 4;
        // }
        // return n == 1;
    }

    public static void main(String[] args) {
        int n = 16;
        System.out.println(isPowerOfFour(n));
    }
}
