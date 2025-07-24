// Minimum Score After Removals on a Tree
// There is an undirected connected tree with n nodes labeled from 0 to n - 1 and n - 1 edges.
// You are given a 0-indexed integer array nums of length n where nums[i] represents the value of 
// the ith node. You are also given a 2D integer array edges of length n - 1 where edges[i] = [ai, bi] 
// indicates that there is an edge between nodes ai and bi in the tree.
// Remove two distinct edges of the tree to form three connected components. 
// For a pair of removed edges, the following steps are defined:
// Get the XOR of all the values of the nodes for each of the three components respectively.
// The difference between the largest XOR value and the smallest XOR value is the score of the pair.
// Return the minimum score of any possible pair of edge removals on the given tree.

//Logic:
//Approach1
//Use the double dfs method, calculating the xor of the two components of the tree using 2 dfs, And for the
//xor of third component we use the xor property, xorOfThirComponent = oxrOfTotalTree ^ xorOfFirstComponent ^ xorOfSecondComponent
//Approach2
//In this approach we use the preorder traversal property of the tree, in the preorder traversal of the tree in the subtree
//of the current node is first visited and then subtree of the previous node is visited.
//So, we store the in and out time of each node in the dfs traverse using static counter or reference variable counter
//And, We can conclude that, if Node x is an ancestor of node y, then it must satisfy:
//in[x] < in[y] < out[x]
//we will also maintain the sum array of get the xor of nth root. sum[0] store the total xor from root node to entire tree
//In this method we use only the single dfs
//If u is an ancestor of v:
//    First part: sum[0]⊕sum[u]
//    Second part: sum[u]⊕sum[v]
//    Third part: sum[v]
//If v is an ancestor of u:
//    First part: sum[0]⊕sum[v]
//    Second part: sum[v]⊕sum[u]
//    Third part: sum[u]
//If u and v are not ancestors of each other:
//    First part: sum[0]⊕sum[u]⊕sum[v]
//    Second part: sum[u]
//    Third part: sum[v]
import java.util.*;

public class MinimumScoreAfterRemovalsOnATree {
    static List<Integer> tree[];
    static int nodesValues[];
    static int in[], out[], sum[];
    public static int calcScore(int xor1, int xor2, int xor3) {
        return (Math.max(xor1, Math.max(xor2, xor3)) - Math.min(xor1, Math.min(xor2, xor3)));
    }
    public static void dfs(int node, int parent, int count[]) {
        in[node] = count[0]++;
        sum[node] = nodesValues[node];
        for(int neighbour : tree[node]) {
            if(neighbour == parent) {
                continue;
            }
            dfs(neighbour, node, count);
            sum[node] ^= sum[neighbour];
        }
        out[node] = count[0];
    }

    @SuppressWarnings("unchecked")
    public static int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        nodesValues = nums;
        tree = new ArrayList[n];
        for(int i=0; i<n; ++i) {
            tree[i] = new ArrayList<>();
        }
        for(int e[] : edges) {
            tree[e[0]].add(e[1]);
            tree[e[1]].add(e[0]);
        }
        
        in = new int[n];
        out = new int[n];
        sum = new int[n];
        int count[] = {0};
        dfs(0, -1, count);

        int res = Integer.MAX_VALUE;
        for(int i=1; i<n; ++i) {
            for(int j=i+1; j<n; ++j) {
                if(in[j] > in[i] && in[j] < out[i]) { //node i is ancestor of node j
                    res = Math.min(res, calcScore(sum[0] ^ sum[i], sum[i] ^ sum[j], sum[j]));
                } else if(in[i] > in[j] && in[i] < out[j]) { //node j is ancestor of node i
                    res = Math.min(res, calcScore(sum[0] ^ sum[j], sum[j] ^ sum[i], sum[i]));
                } else { //node i and node j are not ancestors of each other
                    res = Math.min(res, calcScore(sum[0] ^ sum[i] ^ sum[j], sum[i], sum[j]));
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int nums[] = {1,5,5,4,11}, edges[][] = {{0,1},{1,2},{1,3},{3,4}};
        System.out.println(minimumScore(nums, edges));
    }
}