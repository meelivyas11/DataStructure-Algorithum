package Practice2;

import java.util.LinkedList;

class MyHashMap {

	int capacity = 16;
	LinkedList[] list;
	
	public static void main(String[] args) {
		MyHashMap myHm = new MyHashMap();
		myHm.put(1, "Meeli");
		myHm.put(2, "Harshal");
		myHm.put(3, "Vyas");
		myHm.put(3, "Shah");
		
		System.out.println(myHm.get(1));
		System.out.println(myHm.get(2));
		System.out.println(myHm.get(3));
	}
	
	public MyHashMap() {
		list = new LinkedList[capacity];
	}
	
	public void put(Object key, Object value){
		int hash = key.hashCode();
		hash = hash % capacity;
		
		if(list[hash] == null) {
			list[hash] = new LinkedList<MyEntry>();
			list[hash].add(new MyEntry(key, value));
		}
		else {
			LinkedList aa = list[hash];
			MyEntry myE = getEntry(aa,key);
			if(myE == null){
				aa.add(new MyEntry(key, value));
			}
			else {
				myE.V = value;
			}
		}
	}
	
	public Object get(Object key) {
		int hash = key.hashCode();
		hash = hash % capacity;
		MyEntry myE = getEntry(list[hash], key);
		return myE.V;
		
	}
	
	private MyEntry getEntry(LinkedList l, Object key){
		MyEntry mye = null;
		for(int i=0; i<l.size() ; i++){
			MyEntry current = (MyEntry) l.get(i);
			if(key.equals(current.K)){
				mye = current;
				break;
			}
				
		}
		return mye;
	}
	
	private class MyEntry{
		public Object K;
		public Object V;
		
		public MyEntry(Object k, Object v) {
			K = k;
			V = v;
		}
		
	}
	
}
