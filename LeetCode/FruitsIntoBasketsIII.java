// Fruits Into Baskets III

public class FruitsIntoBasketsIII {
    static class SegmentTree {
        int n;
        int tree[];
        public SegmentTree(int arr[]) {
            this.n = arr.length;
            this.tree = new int[4 * n];
            build(1, 0, n - 1, arr);
        }

        public void build(int idx, int si, int ei, int arr[]) {
            if(si == ei) {
                tree[idx] = arr[si];
                return;
            }

            int mid = (si + ei) >> 1; //(si + ei) / 2;
            build(idx << 1, si, mid, arr); //build(2 * idx, si, mid, arr);
            build((idx << 1) | 1, mid + 1, ei, arr); //build(2 * idx + 1, si, mid, arr);
            tree[idx] = Math.max(tree[idx << 1], tree[(idx << 1) | 1]); //tree[idx] = Math.max(tree[2 * idx], tree[2 * idx + 1]);
            return;
        }

        public int query(int idx, int l, int r, int ql, int qr) {
            if(ql > r || qr < l) {
                return Integer.MIN_VALUE;
            }
            if(ql <= l && r <= qr) {
                return tree[idx];
            }

            int mid = (l + r) >> 1;
            int leftMax = query(idx << 1, l, mid, ql, qr);
            int rightMax = query((idx << 1) | 1, mid + 1, r, ql, qr);
            return Math.max(leftMax, rightMax);
        }

        public void update(int idx, int l, int r, int pos, int val) {
            if(l == r) {
                tree[idx] = val;
                return;
            }
            int mid = (l + r) >> 1;
            if(pos <= mid) {
                update(idx << 1, l, mid, pos, val);
            } else {
                update((idx << 1) | 1, mid + 1, r, pos, val);
            }
            tree[idx] = Math.max(tree[idx << 1], tree[(idx << 1) | 1]);
            return;
        }
    }
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        if(n == 0) {
            return n;
        }

        SegmentTree st = new SegmentTree(baskets);
        int res = 0;
        for(int i=0; i<n; ++i) {
            int l = 0, r = n - 1;
            int curr = -1;
            while(l <= r) {
                int mid = (l + r) >> 1;
                if(st.query(1, 0, n - 1, 0, mid) >= fruits[i]) {
                    curr = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            if(curr != -1 && baskets[curr] >= fruits[i]) {
                st.update(1, 0, n - 1, curr, Integer.MIN_VALUE);
            } else {
                ++res;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        FruitsIntoBasketsIII solution = new FruitsIntoBasketsIII();
        int fruits[] = {4, 2, 5};
        int baskets[] = {3, 5, 4};
        System.out.println(solution.numOfUnplacedFruits(fruits, baskets));
    }
}