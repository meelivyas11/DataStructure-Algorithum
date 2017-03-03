package Array_String;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MyMainChapter1 {
	int j = 0;

	public MyMainChapter1() {
		j = 8;
	}

	public static void main(String[] args) throws FileNotFoundException {

		int[] a1 = { 1, 2, 3, 4, 56 };
		int[] a2 = a1;
		int[] a3 = a2;
		a3[4] = 7;
		a2[4] = a3[4];
		System.out.println(a1[4]);

		List<String> l = new ArrayList<String>();
		int j = 4;
		// double a = (double) j;
		// a = Math.sqrt(a);

		System.out.println(j);

		FileOutputStream aaa = new FileOutputStream("asd.dat");
		// InetAddress aee = InetAddress.ge("www.brainbench.com");
	}

}
