package Practice2;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 *  Implement LinkedHashMap class in Java  
 *  
 *  I am using head/tail to point to fist/last element. After and before variables of MyEntry class are used to form doubly linked List.
 *  Checkout the pic of MyLinkedHashMap.PNG for reference
 *  
 *  This can be done by using only head.
 *  
 */

class MyLinkedHashMap {

	MyEntry head, tail;
	
	LinkedList<MyEntry>[] list; 
	int capacity = 16;
	
	public static void main(String[] args) {
		MyLinkedHashMap hashMap = new MyLinkedHashMap();
		hashMap.put(1, "Meeli");
		hashMap.put(3, "Vyas");
		hashMap.put(2, "Harshal");
		hashMap.put(3, "Shah");
		
		System.out.println(hashMap.get(1));
		System.out.println(hashMap.get(2));
		System.out.println(hashMap.get(3));
		
		for(Object k: hashMap.getMyKeySet()){
			System.out.println(k + " : " + hashMap.get(k));
		}
		
		
	}

	MyLinkedHashMap() {
		head = null;
		tail = null;
		list = new LinkedList[capacity];
	}
	
	public void put(Object key, Object value) {
		int hash = key.hashCode();
		hash = hash%capacity;
		
		if(head == null && head == tail) {
			list[hash] = new LinkedList<MyEntry>();
			MyEntry temp = new MyEntry(key, value, null, null);
			list[hash].add(temp);
			head = tail = temp;
		}
		else if(list[hash] == null) {
			list[hash] = new LinkedList<MyEntry>();
			MyEntry temp = new MyEntry(key, value, null, tail);
			tail.after = temp;
			tail = temp;
			list[hash].add(temp);
		}
		else{
			MyEntry currentEntry = getEntry(list[hash], key);
			if(currentEntry == null) {
				MyEntry temp = new MyEntry(key, value, null, tail);
				tail.after = temp;
				tail = temp;
				list[hash].add(temp);
			}
			else {
				currentEntry.V = value;
			}
		}
	}
	
	public Object get(Object key) {
		int hash = key.hashCode();
		hash = hash%capacity;
		return getEntry(list[hash], key).V;
	}
	
	
	public List<Object> getMyKeySet(){
		List<Object> lst = new ArrayList<Object>();
		MyEntry cH = head;
		while (cH!=null) {
			lst.add(cH.K);
			cH = cH.after;
		}
		return lst;
	}
	
	private MyEntry getEntry(LinkedList<MyEntry> lst, Object kk) {
		MyEntry mye = null;
		for(int i =0; i< lst.size(); i++){
			MyEntry aa = (MyEntry)lst.get(i);
			if(aa.K.equals(kk)){
				mye = aa;
			}
		}
		return mye;
	}

	private class MyEntry{
		public Object K;
		public Object V;
		
		// for doubly Linked List
		public MyEntry after;
		public MyEntry before;
		
		public MyEntry(Object k, Object v, MyEntry aft, MyEntry bfr) {
			K = k;
			V = v;
			after = aft;
			before = bfr;
		}
	}
}
