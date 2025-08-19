// 24 Game

public class TwentyFourGame {
    //EPS or eps = epsilon, a samll value. A small value to check if two numbers are equal or not. 
    //It a tolerance difference that can between two numbers.
    //EPS can be 1e-3, 1e-5 or 1e-6. Commonly it is 1e-6. 1en = 1 * 10^n, 1e-n = 1 * 10^(-n)
    static final double EPS = 1e-6;
    static double arr[];
    public static boolean backtrack(int n) {
        if(n == 1) {
            return Math.abs(arr[0] - 24) < EPS;
        }

        for(int i=0; i<n; ++i) {
            double a = arr[i];
            for(int j=i+1; j<n; ++j) {
                double b = arr[j];
                arr[j] = arr[n - 1];
                arr[i] = a + b;
                if(backtrack(n - 1)) {
                    return true;
                }
                arr[i] = a - b;
                if(backtrack(n - 1)) {
                    return true;
                }
                arr[i] = b - a;
                if(backtrack(n - 1)) {
                    return true;
                }
                arr[i] = a * b;
                if(backtrack(n - 1)) {
                    return true;
                }
                if(Math.abs(b) > EPS) {
                    arr[i] = a / b;
                    if(backtrack(n - 1)) {
                        return true;
                    }
                }
                if(Math.abs(a) > EPS) {
                    arr[i] = b / a;
                    if(backtrack(n - 1)) {
                        return true;
                    }
                }
                arr[i] = a;
                arr[j] = b;
            }
        }
        return false;
    }
    public static boolean judgePoint24(int[] cards) {
        int n = cards.length;
        arr = new double[n];
        for(int i=0; i<n; ++i) {
            arr[i] = cards[i];
        }
        boolean res = backtrack(n);
        return res;
    }
    // static void swap(int arr[], int i, int j) {
    //     int temp = arr[i];
    //     arr[i] = arr[j];
    //     arr[j] = temp;
    // }
    // static void reverse(int arr[], int start, int end) {
    //     while(start < end) {
    //         swap(arr, start, end);
    //         start++;
    //         end--;
    //     }
    // }
    // public static boolean nextPermutation(int[] arr) {
    //     int n = arr.length;

    //     int pivot = -1;
    //     for(int i=n-2; i>=0; --i) {
    //         if(arr[i] < arr[i + 1]) {
    //             pivot = i;
    //             break;
    //         }
    //     }

    //     if(pivot == -1) {
    //         return false;
    //     }

    //     for(int i=n-1; i>pivot; --i) {
    //         if(arr[i] > arr[pivot]) {
    //             swap(arr, pivot, i);
    //             break;
    //         }
    //     }

    //     reverse(arr, pivot + 1, n - 1);

    //     return true;    
    // }
    // static final double val = 1e-6; //some very small value
    // public static boolean isValid(double a, double b) {
    //     if(Math.abs(a + b - 24) <= val || Math.abs(a - b - 24) <= val || Math.abs(a * b - 24) <= val || (b > 0 && Math.abs(a / b - 24) <= val)) {
    //         return true;
    //     }
    //     return false;
    // }
    // public static boolean isValid(double a, double b, double c) {
    //     if(isValid(a + b, c) || isValid(a - b, c) || isValid(a * b, c) || (b > 0 && isValid(a / b, c))) {
    //         return true;
    //     }
    //     if(isValid(a, b + c) || isValid(a, b - c) || isValid(a, b * c) || (c > 0 && isValid(a, b / c))) {
    //         return true;
    //     }
    //     return false;        
    // }
    // public static boolean isValid(int cards[]) {
    //     double a = cards[0], b = cards[1], c = cards[2], d = cards[3];
    //     if(isValid(a + b, c, d) || isValid(a - b, c, d) || isValid(a * b, c, d) || (b > 0 && isValid(a / b, c, d))) {
    //         return true;
    //     }
    //     if(isValid(a, b + c, d) || isValid(a, b - c, d) || isValid(a, b * c, d) || (c > 0 && isValid(a, b / c, d))) {
    //         return true;
    //     }
    //     if(isValid(a, b, c + d) || isValid(a, b, c - d) || isValid(a, b, c * d) || (d > 0 && isValid(a, b, c / d))) {
    //         return true;
    //     }
    //     return false;        
    // }
    // public static boolean judgePoint24(int[] cards) {
    //     int n = cards.length;
    //     Arrays.sort(cards);
    //     if(isValid(cards)) {
    //         return true;
    //     }

    //     while(nextPermutation(cards)) {
    //         if(isValid(cards)) {
    //             return true;
    //         }
    //     }

    //     return false;
    // }

    public static void main(String[] args) {
        int[] cards = {4,1,8,7};
        System.out.println(judgePoint24(cards));
    }
}