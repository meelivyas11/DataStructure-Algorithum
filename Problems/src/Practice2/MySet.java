package Practice2;

import java.util.ArrayList;
import java.util.List;

/*
 * Implement Java Set using TDD
 */
public class MySet<E> {

	List<E> lst;
	
	MySet(){
		lst = new ArrayList<E>();
	}
	
	void addSet(E obj) {
		boolean flag = true;
		for(E e: lst) {
			if(e.equals(obj)) flag = false;
		}
		if(flag) lst.add(obj);
	}
	
	int getSetSize(){
		return this.lst.size();
	}
	public static void main(String[] args) {
		MySet<String> ms = new MySet<String>();
		ms.addSet("Meeli");
		ms.addSet("Meeli");
		ms.addSet("Harshal");
		
		System.out.println("Set size is: " + ms.getSetSize());
	}

}
