 package Practice2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    list1 -->aaa,bbb,ddd,xyxz,... 
	list2-->bbb,ccc,ccc,hkp,.. 
	list3> ddd,eee,,ffff,lmn,.. 
	
	Inside a list the words are sorted 
	I want to remove words which are repeated across the list and print in sorted order 
	If the words are repeated in same list its valid. 
	In the above case 
	it should print aaa-->ccc-->ccc-->eee--->fff-->glk-->hkp-->lmn-->xyxz
	
	
	Note:
		This can be done in two ways without using the Collections.sort(list) function
		1) Using extra space:
			Merge list1 and list2 together to List4 
			Merge list3 with above list4 to get the final result list5
			
		2) without extra space:
			while (i1 < l1.size() && i2 < l2.size() && i3 < l3.size()) {}
			// put incomplete list to l1 and l2
			while (i1 < l1.size() && i2 < l2.size()) {}
			// put incomplete list to l1
			while (i1 < l1.size() ) {} 
 */
public class RemoveDuplicatedFrom3Lists {

	public static void main(String[] args) {
		
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("aaa");
		list1.add("bbb");
		list1.add("ddd");
		list1.add("xyxy");
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("bbb");
		list2.add("ccc");
		list2.add("ccc");
		list2.add("hkp");
		ArrayList<String> list3 = new ArrayList<String>();
		list3.add("ddd");
		list3.add("eee");
		list3.add("fff");
		list3.add("lmnn");
		
		withoutExtraSpace(new ArrayList<String>(list1), new ArrayList<String>(list2),new ArrayList<String>(list3));
		usingExtraSpace(list1, list2, list3);
	}
	
	private static void withoutExtraSpace(List<String> list1, List<String> list2, List<String> list3) {
		List<String> finalList = new ArrayList<String>();
		int i=0, j=0, k=0;
		
		/*
		 *  Rubbish idea -- lot of if Conditions
		 * while(i < list1.size() || j <list2.size() || k<list3.size()) {
			
			if(i < list1.size() && j <list2.size() && k<list3.size() ) {
				if(list1.get(i) == list2.get(j) && list2.get(j) == list3.get(k)) {list1.remove(i); list2.remove(j); list3.remove(k); i++;j++;k++;}
				if(list1.get(i) == list2.get(j)) {list1.remove(i); list2.remove(j); i++; j++;}
				if(list1.get(i) == list3.get(k)) {list1.remove(i); list3.remove(k); i++; k++;}
				if(list2.get(j) == list3.get(k)) {list2.remove(j); list3.remove(k); j++; k++;}
				else {i++;}
			}
			else if (i < list1.size() && j <list2.size() ) {
				if(list1.get(i) == list2.get(j)) {list1.remove(i); list2.remove(j);}
				 i++; j++;
			}
			else if(i < list1.size() && k<list3.size()) {
				if(list1.get(i) == list3.get(k)) {list1.remove(i); list3.remove(k);}
				i++; k++;
			}
			else if(j <list2.size() && k<list3.size()) {
				if(list2.get(j) == list3.get(k)) {list2.remove(j); list3.remove(k);}
				j++; k++;
			}
		}*/
		
		for(i=0; i<list1.size(); i++) {
			for(j=0; j<list2.size(); j++) {
				for(k=0; k<list3.size(); k++) {
					if(list1.get(i) == list2.get(j)) {list1.remove(i); list2.remove(j);}
					if(list1.get(i) == list3.get(k)) {list1.remove(i); list3.remove(k);}
					if(list2.get(j) == list3.get(k)) {list2.remove(j); list3.remove(k);}
				}
			}
		}
		
		finalList.addAll(list1);
		finalList.addAll(list2);
		finalList.addAll(list3);
		Collections.sort(finalList);
		System.out.println(finalList); 
	}
	
	private static void usingExtraSpace(List<String> list1, List<String> list2, List<String> list3) {
		ArrayList<String> list = new ArrayList<String>();
		list.addAll(list3);
		list.addAll(list2);
		list.addAll(list1);
		Collections.sort(list);
		
		System.out.println(list);
		
		for (int i = 0; i < list.size(); i++) {
			if(list1.contains(list.get(i)) && (list2.contains(list.get(i)) || list3.contains(list.get(i)))){
				list.remove(list.get(i));
			}if(list2.contains(list.get(i)) && 	(list1.contains(list.get(i)) || list3.contains(list.get(i)))){
				list.remove(list.get(i));
			}if(list3.contains(list.get(i)) && 	(list2.contains(list.get(i)) || list1.contains(list.get(i)))){
				list.remove(list.get(i));
			}if(list1.contains(list.get(i)) && 	list2.contains(list.get(i)) && 	list3.contains(list.get(i))){
				list.remove(list.get(i));
			}
			
		}
		System.out.println(list);
	}

}
