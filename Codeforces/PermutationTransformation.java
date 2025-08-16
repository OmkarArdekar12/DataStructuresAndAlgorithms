// Permutation Transformation

import java.util.*;
import java.io.*;

public class PermutationTransformation {
    static class Node {
        int val;
        int idx, depth;
        Node left, right;
        public Node(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    static int res[];
    public static void dfs(Node root) {
        if(root == null) {
            return;
        }

        res[root.idx] = root.depth;
        dfs(root.left);
        dfs(root.right);
        return;
    }

    static int arr[];
    public static Node buildTree(int si, int ei, int currDepth) {
        if(si > ei) {
            return null;
        }

        int maxIdx = -1, maxVal = Integer.MIN_VALUE;
        for(int i=si; i<=ei; ++i) {
            if(arr[i] > maxVal) {
                maxVal = arr[i];
                maxIdx = i;
            }
        }

        Node leftSubtree = buildTree(si, maxIdx - 1, currDepth + 1);
        Node rightSubtree = buildTree(maxIdx + 1, ei, currDepth + 1);
        Node currNode = new Node(maxVal);
        currNode.left = leftSubtree;
        currNode.right = rightSubtree;
        currNode.idx = maxIdx;
        currNode.depth = currDepth;

        return currNode;
    }

    public static int[] permutationToTree(int n, int a[]) {
        arr = a;
        Node root = buildTree(0, n - 1, 0);

        res = new int[n]; //depth of each element of permutation in the tree
        dfs(root);

        return res;
    }

    //Concise Code
    static int depth[];
    static void buildPermuationTree(int a[], int left, int right, int currDepth) {
        if(left > right) {
            return;
        }

        int maxIdx = left;
        for(int i=left+1; i<=right; ++i) {
            if(a[i] > a[maxIdx]) {
                maxIdx = i;
            }
        }

        depth[maxIdx] = currDepth;
        buildPermuationTree(a, left, maxIdx - 1, currDepth + 1);
        buildPermuationTree(a, maxIdx + 1, right, currDepth + 1);
        return;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        PrintWriter pw = new PrintWriter(System.out);
        for(int  x=0; x<t; ++x) {
            int n = Integer.parseInt(br.readLine());
            int a[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int d[] = permutationToTree(n, a);
            for(int i=0; i<n; ++i) {
                pw.print(d[i] + " ");
            }
            pw.println();
        }
        pw.flush();
        pw.close();
        br.close();
    }
}