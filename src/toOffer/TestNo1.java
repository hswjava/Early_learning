package toOffer;

public class TestNo1 {
	public static class Solution {
		public static boolean Find(int target, int[][] array) {
			int len = array.length - 1;
			int i = 0;
			while (len >= 0 && i < array[0].length) {
				if (array[len][i] > target) {
					len--;
				} else if (array[len][i] < target) {
					i++;
				} else {
					return true;
				}
			}
			return false;
		}
	}

	public static void main(String[] args) {
		// int[][] array = {"1,2,3,","2,3,4","3,4,5"} ;
		int[][] array = null;
		array = new int[5][5];
		int temp;
		for (int i = 0; i < 5; i++) {
			temp = i;
			for (int j = 0; j < 5; j++) {
				array[i][j] = temp++;
			}
		}
		int target = 0;
		System.out.println(Solution.Find(target, array));
	}
}
