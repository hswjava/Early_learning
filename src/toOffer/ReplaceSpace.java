package toOffer;

public class ReplaceSpace {

	public static void main(String[] args) {
		String str = " 12 34 56 ";
		StringBuffer sb = new StringBuffer();
		sb.append(str);
		ReplaceSpace replaceSpace = new ReplaceSpace();
		System.out.println(replaceSpace.replaceSpace(sb));
	}
	
	public String replaceSpace(StringBuffer str) {
		StringBuffer newSb = new StringBuffer();
		for (int index = 0; index < str.length(); index++) {
			if (str.charAt(index) == ' ') {
				newSb.append("%20");
			} else {
				newSb.append(str.charAt(index));
			}
		}
		return newSb.toString();
	}

	public int minNumberInRotateArray(int[] array) {
		if (array.length == 0) {
			return 0;
		}
		for (int i = 0; i < array.length - 1; i++) {

			if (array[i + 1] < array[i]) {
				return array[i + 1];
			}

		}
		return array[0];
	}
}
 