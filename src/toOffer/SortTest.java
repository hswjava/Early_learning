package toOffer;
/**
 * ��������
 * @author swhe
 *
 */
public class SortTest {

	public static class QuickSort {
		public static int getMiddleNum(int[] array, int low, int high) {
			int temp = array[low];
			while (low < high) {

				while (low < high && array[high] > temp) {
					high--;
				}
				array[low] = array[high];
				while (low < high && array[low] < temp) {
					low++;
				}
				array[high] = array[low];
			}
			array[low] = temp;
			return low;
		}

		public static void quickSort(int[] array, int low, int high) {
			if (low < high) {
				int middle = getMiddleNum(array, low, high);
				quickSort(array, low, middle - 1);
				quickSort(array, middle + 1, high);
			}
		}

		public int[] sort(int[] array) {
			quickSort(array, 0, array.length - 1);
			return array;
		}

		public static void main(String[] args) {
			int a[] = { 1, 6, 3, 2, 5 };
			QuickSort quickSort = new QuickSort();
			quickSort.sort(a);
			int length = a.length;
			int i = 0;
			while (i++ < length) {
				System.out.print(a[i - 1]);
				System.out.print(' ');
			}
			// System.out.println(a.toString());
		}
	}
}
