// Design Skiplist

import java.util.*;

class Skiplist {
    static class Node {
        int val;
        Node next;
        public Node(int v) {
            this.val = v;
            this.next = null;
        }
    }

    Node root;
    public Skiplist() {
        this.root = null;
    }
    
    public boolean search(int target) {
        Node curr = root;
        while(curr != null) {
            if(curr.val == target) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }
    
    public void add(int num) {
        if(root == null) {
            root = new Node(num);
            return;
        }

        if(root.val > num) {
            Node newNode = new Node(num);
            newNode.next = root;
            root = newNode;
            return;
        }

        Node curr = root;
        while(curr.next != null && num >= curr.next.val) {
            curr = curr.next;
        }
        Node newNode = new Node(num);
        newNode.next = curr.next;
        curr.next = newNode;
        return;
    }
    
    public boolean erase(int num) {
        if(root.val == num) {
            root = root.next;
            return true;
        }

        Node curr = root;
        while(curr.next != null) {
            if(curr.next.val == num) {
                curr.next = curr.next.next;
                return true;
            }
            curr = curr.next;
        }
        return false;
    }
}

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */

public class DesignSkiplist {
    public static void main(String[] args) {
        List<String> res = new ArrayList<>();
        Skiplist skiplist = new Skiplist(); res.add("null");
        skiplist.add(1); res.add("null");
        skiplist.add(2); res.add("null");
        skiplist.add(3); res.add("null");
        res.add(Boolean.toString(skiplist.search(0)));
        skiplist.add(4); res.add("null");
        res.add(Boolean.toString(skiplist.search(1)));
        res.add(Boolean.toString(skiplist.erase(0)));
        res.add(Boolean.toString(skiplist.erase(1)));
        res.add(Boolean.toString(skiplist.search(1)));
        System.out.println(res);
    }
}