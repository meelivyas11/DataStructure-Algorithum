package Practice2;

public class MyConcurrentHashmap {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}

/*public class MyConcurrentHashmap {

	private static final int DEFAULT_CONCURRENCY_LEVEL = 16;

    private static final int INITIAL_CAPACITY = 16;

    private float LOAD_FACTOR = 0.75f;

    private int capacity = INITIAL_CAPACITY;

    private int size;

    private Lock[] locks;

    private MyHashMap myHashMap = new MyHashMap();

    private class MyHashMap {
        private LinkedList[] lists = new LinkedList[INITIAL_CAPACITY];

        private class MapEntry {
            final Object key;
            volatile Object value;

            MapEntry(Object key, Object value) {
                this.key = key;
                this.value = value;
            }
        }

		void put(Object key, Object value) {
            if (key == null)
                throw new IllegalArgumentException("Key Cannot be Null");
            int hash = key.hashCode();
            hash = hash % lists.length;
            if (size >= LOAD_FACTOR * lists.length) {
                capacity = lists.length * 2;
                LinkedList[] tempLists = new LinkedList[capacity];
                System.arraycopy(lists, 0, tempLists, 0, lists.length);
                lists = tempLists;
                reHash();
            }
            if (lists[hash] == null) {
                lists[hash] = new LinkedList<MapEntry>();
                size++;
            }
            int i = 0;
            for (; i < lists[hash].size(); i++) {
                MapEntry mapEntry = (MapEntry) (lists[hash].get(i));
                if (mapEntry != null && mapEntry.key.equals(key)) {
                    mapEntry.value = value;
                    break;
                }
            }
            if (i == lists[hash].size()) {
                lists[hash].addLast(new MapEntry(key, value));
            }
        }

        Object get(Object key) {
            int hash = key.hashCode();
            hash = hash % lists.length;
            Object value = null;
            if (lists[hash] != null) {
                for (int i = 0; i < lists[hash].size(); i++) {
                    MapEntry mapEntry = (MapEntry) (lists[hash].get(i));
                    if (mapEntry != null && mapEntry.key.equals(key)) {
                        value = mapEntry.value;
                        break;
                    }
                }
            }
            return value;
        }

        private void reHash() {
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    int hash = ((MapEntry) lists[i].getFirst()).key.hashCode();
                    hash %= lists.length;
                    if (i != hash) {
                        lists[hash] = lists[i];
                        lists[i] = null;
                    }
                }
            }

        }

        int size() {
            return size;
        }

        int capacity() {
            return capacity;
        }
    }

    public MyConcurrentHashmap(int concurrencyLevel) {
        locks = new Lock[concurrencyLevel];
        for (int i = 0; i < concurrencyLevel; i++) {
            locks[i] = new ReentrantLock(); //ReentrantLock is a concrete implementation of Lock interface
        }
    }

    public MyConcurrentHashmap() {
        this(DEFAULT_CONCURRENCY_LEVEL);
    }

    public void put(Object key, Object value) {
        int hash = key.hashCode();
        hash = hash % myHashMap.capacity();
        
        // added by meeli - start
        if(hash > locks.length) {
        	locks = new Lock[capacity];
            for (int i = 0; i < capacity; i++) {
                locks[i] = new ReentrantLock(); //ReentrantLock is a concrete implementation of Lock interface
            }
        }
        // added by meeli - end
        locks[hash].lock();
        myHashMap.put(key, value);
        locks[hash].unlock();
    }

    public Object get(Object key) {
        return myHashMap.get(key);
    }

    public static void main(String[] args) {
        MyConcurrentHashmap myCCHashMap = new MyConcurrentHashmap();
        for(int i = 0 ; i < 15; i ++ ){
	        myCCHashMap.put(i, "Thomas");
	        myCCHashMap.put(i+1, "Mathew");
	        myCCHashMap.put(17, "Tissa");
	        myCCHashMap.put(9, "Mathew Thomas");
        }
        
        System.out.println(myCCHashMap.get(1));
        System.out.println(myCCHashMap.get(9));
        System.out.println(myCCHashMap.get(17));
    }

}
*/