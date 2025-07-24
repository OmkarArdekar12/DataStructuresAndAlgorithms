// H-Index
// Given an array of integers citations where citations[i] is the number of citations a researcher received 
// for their ith paper, return the researcher's h-index.
//  The h-index is defined as the maximum value of h such that the given researcher has published at 
// least h papers that have each been cited at least h times.

public class HIndex {
    public static int hIndex(int[] citations) {
        int n = citations.length;
        int count[] = new int[n+1];

        for(int i : citations) {
            if(i >= n) {
                count[n]++;
            } else {
                count[i]++;
            }
        }

        int hIdx = 0;
        for(int i = n; i >= 0; --i) {
            hIdx += count[i];
            // The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.
            if(hIdx >= i) {
                return i; // h-index
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int citations[] = {3, 0, 6, 1, 5};
        System.out.println(hIndex(citations));
    }
}