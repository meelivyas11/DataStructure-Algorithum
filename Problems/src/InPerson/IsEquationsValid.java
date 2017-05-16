package InPerson;

import java.util.ArrayList;
import java.util.List;

/*
 * Q: If you were given a series of equations e.g. [A = B, B = D, C = D, F = G, E = H, H = C] 
	and then another series [A != C, D != H, F != A ] 
	
	Check whether the equations combined is valid. 
	
	For the example given, your program should return 'invalid', because the first series implies that A = C, which contradicts the statement A != C in the second series.
 */
public class IsEquationsValid {

	public static void main(String[] args) {
		
		List<Condition> list1 = new ArrayList<Condition>();
		list1.add(new Condition("A", "=", "B"));
		list1.add(new Condition("A", "=", "C"));
		list1.add(new Condition("B", "=", "D"));
		list1.add(new Condition("C", "=", "D"));
		list1.add(new Condition("F", "=", "G"));
		list1.add(new Condition("E", "=", "H"));
		list1.add(new Condition("H", "=", "C"));
		
		List<Condition> list2 = new ArrayList<Condition>();
		list2.add(new Condition("C", "!=", "A"));
		list2.add(new Condition("D", "!=", "H"));
		list2.add(new Condition("F", "!=", "A"));

		System.out.println("Are Conditions Valid? :" + isValid(list1, list2));
	}
	private static boolean isValid(List<Condition> list1, List<Condition> list2) {
		for(Condition c1: list1) {
			for(Condition c2: list2)
			{
				if((c1.first.equals(c2.first) && c1.second.equals(c2.second)) || (c1.first.equals(c2.second) && c1.second.equals(c2.first))) {
					if(!c1.operator.equals(c2.operator))
						return false;
				}
			}
		}
		return true;
	}
	static class Condition {
		String first, second, operator;
		public Condition(String f, String op, String s) {
			first = f;
			second = s;
			operator = op;
		}
	}
	
	
}
