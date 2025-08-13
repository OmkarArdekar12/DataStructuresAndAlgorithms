// Power of Three

public class PowerOfThree {
    public static boolean isPowerOfThree(int n) {
        // if(n <= 0) {
        //     return false;
        // }
        // while(n % 3 == 0) {
        //     n /= 3;
        // }
        // return n == 1;

        // //n = 3^x
        // //x = log3(n)
        // //x = log10(n) / log10(3)
        // //x % 1 = 0, means x is an integer value and x can be power of 3.
        // return (Math.log10(n) / Math.log10(3)) % 1 == 0;

        //3^19 = 1162261467, 3^20 exceeds the integer range, So, 3^19, is highest power in integer range
        return (n > 0 && 1162261467 % n == 0);
    }

    public static void main(String[] args) {
        int n = 9;
        System.out.println(isPowerOfThree(n));
    }
}