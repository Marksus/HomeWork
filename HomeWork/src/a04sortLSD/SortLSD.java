package a04sortLSD;

public class SortLSD {
	int[] s = new int[15];

	public static void main(String[] args) {
		SortLSD m = new SortLSD();
		fill(m.s);

		m.s = sort(m.s);
		print(m.s);
	}

	public static void fill(int[] massive) {
		for (int i = 0; i < massive.length; i++) {
			massive[i] = (new java.util.Random()).nextInt(1000);
		}
	}

	public static int[] sort(int[] s) {
		int r = 0;
		int x = 0;

		// max of s
		for (int i : s) {
			if (i > x)
				x = i;
		}

		// grade
		while (x != 0) {
			x /= 10;
			r++;
		}
		;

		int[] s1 = new int[s.length];
		int reg = 1;
		int count = 0;

		for (int y = 0; y < r; y++) {
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < s.length; j++) {
					if (((s[j] / reg) % 10) == i) {
						s1[count] = s[j];
						count++;
					}
				}
			}
			s = s1.clone();
			count = 0;
			reg *= 10;
		}
		return s;
	}

	public static void print(int[] s) {
		System.out.print("[" + s[0]);
		for (int i = 1; i < s.length; i++) {
			System.out.print(" ," + s[i]);
		}
		System.out.println("]");
	}

}
