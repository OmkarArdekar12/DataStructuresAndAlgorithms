// Reordered Power of 2

public class ReorderedPowerOf2 {
    // static String getPowerOfTwoNumberStringSorted(int val) {
    //     // char curr[] = Integer.toString(val).toCharArray();
    //     char curr[] = String.valueOf(val).toCharArray();
    //     Arrays.sort(curr);
    //     return new String(curr);
    // }
    // public static boolean reorderedPowerOf2(int n) {
    //     String number = getPowerOfTwoNumberStringSorted(n);
    //     for(int i=0; i<31; ++i) {
    //         if(getPowerOfTwoNumberStringSorted(1 << i).equals(number)) {
    //             return true;
    //         }
    //     }

    //     return false;
    // }
    static long getPowerOfTwoNumberSorted(int val) {
        long res = 0;
        while(val > 0) {
            res += (int)(Math.pow(10, val % 10));
            val /= 10;
        }
        return res;
    }
    public static boolean reorderedPowerOf2(int n) {
        long number = getPowerOfTwoNumberSorted(n);
        for(int i=0; i<32; ++i) {
            if(getPowerOfTwoNumberSorted(1 << i) == number) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 46;
        System.out.println(reorderedPowerOf2(n));
    }
}