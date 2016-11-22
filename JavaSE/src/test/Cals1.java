package test;

public class Cals1 {
	public static <T extends Comparable> T max(T []a) {
		T max = a[0];
		for (int i = 0; i < a.length; i++) {
			if (max.compareTo(a[i]) < 0) {
				max = a[i];
			}
		}
		return max;
	}
	public static <T extends Comparable> T min(T []a) {
		T min = a[0];
		for (int i = 0; i < a.length; i++) {
			if (min.compareTo(a[i]) > 0) {
				min = a[i];
			}
		}
		return min;
	}
}
