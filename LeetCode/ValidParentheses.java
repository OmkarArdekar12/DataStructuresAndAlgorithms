// Valid Parentheses

public class ValidParentheses {
    public static boolean isValid(String s) {
        int n = s.length();
        if(n % 2 != 0) {
            return false;
        }
        char stack[] = new char[n];
        int top = -1;
        for(int i=0; i<n; ++i) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{') {
                stack[++top] = ch;
            } else {
                char complement = ch == ')' ? '(' : ch == ']' ? '[' : '{';
                if(top == -1 || stack[top] != complement) {
                    return false;
                } else {
                    --top;
                }
            }
        }
        return top == -1;

        // int n = s.length();
        // Stack<Character> stack = new Stack<>();
        // for(int i=0; i<n; ++i) {
        //     char ch = s.charAt(i);
        //     if(ch == '(' || ch == '[' || ch == '{') {
        //         stack.push(ch);
        //     } else {
        //         char complement = ch == ')' ? '(' : ch == ']' ? '[' : '{';
        //         if(stack.isEmpty() || stack.peek() != complement) {
        //             return false;
        //         } else {
        //             stack.pop();
        //         }
        //     }
        // }
        // return stack.isEmpty();

        // int n = s.length();
        // StringBuilder sb = new StringBuilder("");
        // for(int i=0; i<n; ++i) {
        //     char ch = s.charAt(i);
        //     if(ch == '(' || ch == '[' || ch == '{') {
        //         sb.append(ch);
        //     } else {
        //         char complement = ch == ')' ? '(' : ch == ']' ? '[' : '{';
        //         if(sb.isEmpty() || sb.charAt(sb.length() - 1) != complement) {
        //             return false;
        //         } else {
        //             sb.deleteCharAt(sb.length() - 1);
        //         }
        //     }
        // }
        // return sb.isEmpty();

        // int n = s.length();
        // char stack[] = new char[n];
        // int top = -1;
        // for(int i=0; i<n; ++i) {
        //     char ch = s.charAt(i);
        //     if(ch == '(' || ch == '[' || ch == '{') {
        //         stack[++top] = ch;
        //     } else {
        //         char complement = ch == ')' ? '(' : ch == ']' ? '[' : '{';
        //         if(top == -1 || stack[top] != complement) {
        //             return false;
        //         } else {
        //             --top;
        //         }
        //     }
        // }
        // return top == -1;
    }
    public static void main(String[] args) {
        String s = "([])";
        System.out.println(isValid(s));
    }
}