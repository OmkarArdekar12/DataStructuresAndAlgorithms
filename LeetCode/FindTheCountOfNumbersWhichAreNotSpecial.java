// Find the Count of Numbers Which Are Not Special

public class FindTheCountOfNumbersWhichAreNotSpecial {
    //To any number to be special number is should as proper divisors equal to 2.
    //And every number as 1 as a divisor. So, any number to be a special number is should be the
    //square of the prime number. So, that special number will have exactly two divisors that is 1 and primeNumber, 
    //and that number will be primeNumber^2(primeNumber * primeNumber).
    //So, using Sieve of Ertosthenes Algorithm, n = sqrt(r), TC = O(nloglogn), SC = O(n)
    public static int nonSpecialCount(int l, int r) {
        int size = (int)Math.sqrt(r) + 1;
        boolean isPrime[] = new boolean[size]; //true->NotPrime, false->Prime
        isPrime[0] = isPrime[1] = true;
        for(int i=2; i<size; ++i) {
            if(isPrime[i]) {
                continue;
            }
            for(int j=i*i; j<size; j+=i) {
                isPrime[j] = true;
            }
        }

        int special = 0;
        for(int i=2; i<size; ++i) {
            if(!isPrime[i]) {
                int primeSq = i * i;
                if(l <= primeSq && primeSq <= r) {
                    ++special;
                }
            }
        }
        int total = r - l + 1;
        int notSpecial = total - special;

        return notSpecial;
    }

    public static void main(String[] args) {
        int l = 5, r = 7;
        System.out.println(nonSpecialCount(l, r));
    }
}