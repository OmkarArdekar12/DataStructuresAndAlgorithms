// Insert Delete GetRandom O(1)
// Implement the RandomizedSet class:
// RandomizedSet() Initializes the RandomizedSet object.
// bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
// bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
// int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when 
// this method is called). Each element must have the same probability of being returned.
// You must implement the functions of the class such that each function works in average O(1) time complexity.

import java.util.*;

class RandomizedSet {
    static Random random = new Random();
    List<Integer> values;
    Map<Integer, Integer> map;
    public RandomizedSet() {
        this.map = new HashMap<>();
        this.values = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) {
            return false;
        }
        int idx = values.size();
        map.put(val, idx);
        values.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) {
            return false;
        }
        int idx = map.get(val);
        if(idx < values.size() - 1) { //if val is not at lastIndex then swap it to lastIndex. So, remove operation can by done in O(1).
            int lastVal = values.get(values.size() - 1);
            values.set(idx, lastVal);
            map.put(lastVal, idx);
        }
        map.remove(val);
        values.remove(values.size() - 1);
        return true;
    }
    
    public int getRandom() {
        int randomIdx = random.nextInt(values.size());
        return values.get(randomIdx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

public class InsertDeleteGetRandomInConstantTime {
    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        List<String> output = new ArrayList<>();
        output.add("null");
        output.add(Boolean.toString(obj.insert(1)));
        output.add(Boolean.toString(obj.remove(2)));
        output.add(Boolean.toString(obj.insert(2)));
        output.add(Integer.toString(obj.getRandom()));
        output.add(Boolean.toString(obj.remove(1)));
        output.add(Boolean.toString(obj.insert(2)));
        output.add(Integer.toString(obj.getRandom()));
        System.out.println(output);
    }
}
