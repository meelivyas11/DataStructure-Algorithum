package InPerson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/*
 * Write a iterator wrapper to remove duplicates from collections without using temporary storage. 

	For Example: 
	ArrayList A = {RAT,CAT,BAT} 
	ArrayList B = {RAT,CAT,MAT} 
	
	ResultIterator itr = new ResultIterator(); 
	itr.next() should display {RAT,CAT,BAT,MAT} 
	
	
	Program skeleton: 
	
	class ResultIterator { 
	ResultIterator(iterator itr1, iterator itr2) { 
	} 
	
	bool hasnext { 
	// implement this method 
	} 
	
	E next() { 
	// implement this method 
	} 
}
 */
public class IteratorWrapperToRemoveDuplicates {

	public static void main(String[] args) {
		List<String> list1 = new ArrayList<String>(Arrays.asList("RAT","CAT","BAT"));
		List<String> list2 = new ArrayList<String>(Arrays.asList("RAT","CAT","MAT"));
		
		ResultIterator<String> resItr = new ResultIterator<String>(list1.iterator(), list2.iterator());
		while(resItr.hasnext()) {
			System.out.println(resItr.next());
		}
	}
	
	static class ResultIterator<E> { 
		Set<E> set = new LinkedHashSet<E>();
		Iterator<E> resultIterator;
		ResultIterator(Iterator<E> itr1, Iterator<E> itr2) { 
			while(itr1.hasNext()){
				set.add(itr1.next());
			}
			while(itr2.hasNext()){
				set.add(itr2.next());
			}
			resultIterator = set.iterator();
		} 
		
		boolean hasnext() { 
		 return resultIterator.hasNext();
		} 
		
		E next() {
			return (E) resultIterator.next(); 
		} 
	
	}

}
