// Longest Common Prefix
// Write a function to find the longest common prefix string amongst an array of strings.
// If there is no common prefix, return an empty string "".

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        // int n = strs.length;
        // Arrays.sort(strs);
        // StringBuilder result = new StringBuilder("");
        // String si = strs[0];
        // String ei = strs[n-1];
        // n = Math.min(si.length(), ei.length());
        // for(int i = 0; i < n; ++i) {
        //     if(si.charAt(i) != ei.charAt(i)) {
        //         return result.toString();
        //     }
        //     result.append(si.charAt(i));
        // }
        // return result.toString();
        int n = strs.length;
        StringBuilder prefix = new StringBuilder("");
        for(int i=0; i<n; ++i) {
            if(i == 0) {
                prefix.append(strs[i]);
                continue;
            }

            while(!strs[i].startsWith(prefix.toString()) && !prefix.isEmpty()) {
                prefix.deleteCharAt(prefix.length() - 1);
            }

            if(prefix.isEmpty()) {
                break;
            }
        }
        String longestCommonPrefix = prefix.toString();
        return longestCommonPrefix;
    }

    public static void main(String[] args) {
        String strs[] = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}