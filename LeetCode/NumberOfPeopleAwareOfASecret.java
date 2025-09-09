// Number of People Aware of a Secret

public class NumberOfPeopleAwareOfASecret {
    // static final int MOD = 1000000007;
    // static Integer memo[];
    // static int getPeopleAwareOfSecretOnDay(int day, int delay, int forget) {
    //     if(day == 1) {
    //         return 1;
    //     }
    //     if(memo[day] != null) {
    //         return memo[day];
    //     }
    //     int curr = 0;
    //     for(int prevDay=day-forget+1; prevDay<=day-delay; ++prevDay) {
    //         if(prevDay <= 0) {
    //             continue;
    //         }
    //         curr = (curr + getPeopleAwareOfSecretOnDay(prevDay, delay, forget)) % MOD;
    //     }
    //     return memo[day] = curr;
    // }
    static final int mod = 1000000007;
    public static int peopleAwareOfSecret(int n, int delay, int forget) { //TC = O(n)
        int dp[] = new int[n + 1];
        dp[1] = 1;
        int count = 0; //sum of window of range (day-forget+1 to day-delay)
        for(int day=2; day<=n; ++day) {
            if(day-delay > 0) {
                count = (count + dp[day - delay]) % mod;
            }
            if(day-forget > 0) {
                count = (count - dp[day - forget] + mod) % mod; //(a - b) % MOD = (a - b + MOD) % MOD
            }
            dp[day] = count;
        }

        int res = 0;
        for(int day=n-forget+1; day<=n; ++day) {
            if(day > 0) {
                res = (res + dp[day]) % mod;
            }
        }

        return res;
        
        // //TC = O(n * (forget - delay))
        // int M = 1000000007;
        // int dp[] = new int[n + 1];
        // dp[1] = 1;
        // for(int day=2; day<=n; ++day) {
        //     int count = 0;
        //     for(int prev=day-forget+1; prev<=day-delay; ++prev) {
        //         if(prev > 0) {
        //             count = (count + dp[prev]) % M;
        //         }
        //     }
        //     dp[day] = count;
        // }
        // int res = 0;
        // for(int day=n-forget+1; day<=n; ++day) {
        //     if(day > 0) {
        //         res = (res + dp[day]) % M;
        //     }
        // }
        // return res;

        // memo = new Integer[n + 1];
        // int res = 0;
        // for(int day=n-forget+1; day<=n; ++day) {
        //     if(day <= 0) {
        //         continue;
        //     }
        //     res = (res + getPeopleAwareOfSecretOnDay(day, delay, forget)) % MOD;
        // }
        // return res;
    }

    public static void main(String[] args) {
        int n = 6, delay = 2, forget = 4;
        System.out.println(peopleAwareOfSecret(n, delay, forget));
    }
}