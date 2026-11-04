package p706_design_hashmap;

import java.util.Arrays;

class MyHashMap {
    private int[] storage;

    public MyHashMap() {
        this.storage = new int[1_000_001];
        Arrays.fill(this.storage, -1);
    }

    public void put(int key, int value) {
        this.storage[key] = value;
    }

    public int get(int key) {
        return this.storage[key];
    }

    public void remove(int key) {
        this.storage[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such: MyHashMap obj
 * = new MyHashMap(); obj.put(key,value); int param_2 = obj.get(key);
 * obj.remove(key);
 */
