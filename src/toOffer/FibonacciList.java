package toOffer;

public class FibonacciList {
	public int Fibonacci(int n) {
		if (n <= 1) {
			return n;
		} else if (n == 2) {
			return 1;
		} else {
			return Fibonacci(n - 1) + Fibonacci(n - 2);
		}
	}
	
	public static void main(String[] args) {
		FibonacciList fibonacciList = new FibonacciList();
		System.out.println(fibonacciList.Fibonacci(0));
		System.out.println(fibonacciList.Fibonacci(1));
		System.out.println(fibonacciList.Fibonacci(2));
		System.out.println(fibonacciList.Fibonacci(3));
		System.out.println(fibonacciList.Fibonacci(4));
		System.out.println(fibonacciList.Fibonacci(5));
		System.out.println(fibonacciList.Fibonacci(6));
		System.out.println(fibonacciList.Fibonacci(7));
		System.out.println(fibonacciList.Fibonacci(8));
		System.out.println(fibonacciList.Fibonacci(9));
		
		System.out.println(fibonacciList.Fibonacci2(0));
		System.out.println(fibonacciList.Fibonacci2(1));
		System.out.println(fibonacciList.Fibonacci2(2));
		System.out.println(fibonacciList.Fibonacci2(3));
		System.out.println(fibonacciList.Fibonacci2(4));
		System.out.println(fibonacciList.Fibonacci2(5));
		System.out.println(fibonacciList.Fibonacci2(6));
		System.out.println(fibonacciList.Fibonacci2(7));
		System.out.println(fibonacciList.Fibonacci2(8));
		System.out.println(fibonacciList.Fibonacci2(9));
	}
	
	
	
	public int Fibonacci2(int n) {
		if (n<=1) {
			return n;
		}
		int[] result = new int[n+1];
		
		result [0] = 0;
		result [1] = 1;
		
		for (int i = 2; i<n+1; i++) {
			result[i] = result[i-1] + result[i-2];
		}
		return result[n];
		
	}
}
