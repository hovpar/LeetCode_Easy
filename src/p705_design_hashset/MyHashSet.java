package p705_design_hashset;

class MyHashSet {

    private boolean[] storage;

    public MyHashSet() {
        this.storage = new boolean[1_000_001];
    }

    public void add(int key) {
        this.storage[key] = true;
    }

    public void remove(int key) {
        this.storage[key] = false;
    }

    public boolean contains(int key) {
        return this.storage[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such: MyHashSet obj
 * = new MyHashSet(); obj.add(key); obj.remove(key); boolean param_3 =
 * obj.contains(key);
 */
