// Happy Number

public class HappyNumber {
    public static int sqSum(int x) {
        int sum = 0;
        while(x > 0) {
            int ld = x % 10;
            sum += (ld * ld);
            x /= 10;
        }
        return sum;

        // int sum = 0;
        // while(x != 0) {
        //     int lastDigit = x % 10;
        //     sum += (lastDigit * lastDigit);
        //     x /= 10;
        // }
        // return sum;
    }
    public static boolean isHappy(int n) {
        int slow = n, fast = sqSum(n);
        while(slow != 1 && slow != fast) {
            slow = sqSum(slow);
            fast = sqSum(sqSum(fast));
        }
        return slow == 1;
        
        // int slow = n, fast = n;
        // do {
        //     slow = sqSum(slow);
        //     fast = sqSum(sqSum(fast));
        // } while(slow != fast);
        // return slow == 1;
    
        // int slow = n, fast = sqSum(n);
        // while(slow != fast) {
        //     slow = sqSum(slow);
        //     fast = sqSum(sqSum(fast));
        // }
        // return slow == 1;
    
        // int slow = n, fast = sqSum(n);
        // while(fast != 1 && slow != fast) {
        //     slow = sqSum(slow);
        //     fast = sqSum(sqSum(fast));
        // }
        // return fast == 1;
    }

    public static void main(String[] args) {
        int n = 19;
        System.out.println(isHappy(n));
    }
}