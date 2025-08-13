// Power of Two

public class PowerOfTwo {
    public static boolean isPowerOfTwo(int n) {
        // if(n <= 0) {
        //     return false;
        // }
        // while(n % 2 == 0) {
        //     n /= 2;
        // }
        // return n == 1;

        // if(n <= 0) {
        //     return false;
        // }
        // return (Math.log10(n) / Math.log10(2)) % 1 == 0;

        if(n <= 0) {
            return false;
        }
        return Integer.bitCount(n) == 1;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(isPowerOfTwo(n));
    }
}