package Array_String;

import java.net.InetAddress;

public class MyMainChapter1 {
	int j = 0;

	public MyMainChapter1() {
		j = 8;
	}

	public static void main(String[] args) throws Exception {

		int[] a1 = { 1, 2, 3, 4, 56 };
		int[] a2 = a1;
		int[] a3 = a2;
		a3[4] = 7;
		a2[4] = a3[4];
		System.out.println(a1[4]);

		int j = 4;
		double a = (double) j;
		a = Math.sqrt(a);

		System.out.println(j);

		//FileOutputStream fos = new FileOutputStream("asd.dat");
		InetAddress ia = InetAddress.getByName("www.brainbench.com");
		System.out.println(ia);
	}

}
