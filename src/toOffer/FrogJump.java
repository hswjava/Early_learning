package toOffer;

public class FrogJump {
	public int JumpFloor(int target) {
		int sum = 0;
		for (int i = target, j = 0; i > 0; i = i - 2, j++) {
			System.out.println("有" + i + "个一步和" + j + "个两步");
			System.out.println("一共有" + calc(i, i + j) + "种跳法");

				sum += calc(i, i + j);
		

		}
		if (target % 2 == 0) {
			sum++;
		}
		return sum;
	}

	private int calc(int a, int b) {
		int up = b;
		int down = a;
		int count1 = a;
		int count2 = a;
		while (count1-- > 1) {
			up *= --b;
		}

		while (count2-- > 1) {
			down *= --a;
		}

		return up / down;
	}

	public static void main(String[] args) {
		FrogJump frogJump = new FrogJump();
		System.out.println(frogJump.JumpFloor(29));
		// System.out.println(frogJump.calc(1,27));
	}
}
