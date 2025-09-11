// Implement Router

import java.util.*;

class Router {
    int maxSize;
    Queue<int[]> q;
    Set<String> set;
    Map<Integer, List<Integer>> map;
    Map<Integer, Integer> index;
    public Router(int memoryLimit) {
        this.maxSize = memoryLimit;
        this.q = new LinkedList<>();
        this.set = new HashSet<>();
        this.map = new HashMap<>();
        this.index = new HashMap<>();
    }
    
    public boolean addPacket(int source, int destination, int timestamp) {
        String hashPacket = source + "s" + destination + "d" + timestamp + "t";
        if(set.contains(hashPacket)) {
            return false;
        }

        if(q.size() >= maxSize) {
            int curr[] = q.poll();
            set.remove(curr[0] + "s" + curr[1] + "d" + curr[2] + "t");
            index.put(curr[1], index.getOrDefault(curr[1], 0) + 1);
        }

        int curr[] = {source, destination, timestamp};
        q.add(curr);
        set.add(hashPacket);
        if(!map.containsKey(destination)) {
            map.put(destination, new ArrayList<>());
        }
        map.get(destination).add(timestamp);

        return true;
    }
    
    public int[] forwardPacket() {
        if(q.isEmpty()) {
            return new int[]{};
        }

        int curr[] = q.remove();
        String hashPacket = curr[0] + "s" + curr[1] + "d" + curr[2] + "t";
        set.remove(hashPacket);
        index.put(curr[1], index.getOrDefault(curr[1], 0) + 1);

        return curr;
    }
    
    public int getCount(int destination, int startTime, int endTime) {
        if(!map.containsKey(destination)) {
            return 0;
        }

        List<Integer> curr = map.get(destination);
        int start = index.getOrDefault(destination, 0);
        int res = upperBound(curr, endTime, start) - lowerBound(curr, startTime, start);

        return res;
    }

    public int lowerBound(List<Integer> l, int target, int start) {
        int si = start, ei = l.size();
        while(si < ei) {
            int mid = (si + ei) / 2;
            if(l.get(mid) < target) {
                si = mid + 1;
            } else {
                ei = mid;
            }
        }
        return si;
    }
    public int upperBound(List<Integer> l, int target, int start) {
        int si = start, ei = l.size();
        while(si < ei) {
            int mid = (si + ei) / 2;
            if(l.get(mid) <= target) {
                si = mid + 1;
            } else {
                ei = mid;
            }
        }
        return si;
    }
}

public class ImplementRouter {
    public static void main(String[] args) {
        Router obj = new Router(3);
        List<String> res = new ArrayList<>();
        res.add("null");
        res.add(Boolean.toString(obj.addPacket(1, 4, 90)));
        res.add(Boolean.toString(obj.addPacket(2, 5, 90)));
        res.add(Boolean.toString(obj.addPacket(1, 4, 90)));
        res.add(Boolean.toString(obj.addPacket(3, 5, 95)));
        res.add(Boolean.toString(obj.addPacket(4, 5, 105)));
        res.add(Arrays.toString(obj.forwardPacket()));
        res.add(Boolean.toString(obj.addPacket(5, 2, 110)));
        res.add(Integer.toString(obj.getCount(5, 100, 110)));
        System.out.println(res);
    }
}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */