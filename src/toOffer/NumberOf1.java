package toOffer;

public class NumberOf1 {
	public int NumberOf1(int n) {
		return Integer.toBinaryString(n).replaceAll("0", "").length();
	}

	public static void main(String[] args) {
		NumberOf1 a = new NumberOf1();
		System.out.println(a.NumberOf1(1));
		System.out.println(a.NumberOf1(2));
		System.out.println(a.NumberOf1(3));
		System.out.println(a.NumberOf1(4));
		System.out.println(a.NumberOf1(5));
		System.out.println(a.NumberOf1(6));
		System.out.println(a.NumberOf1(7));
	}
}
