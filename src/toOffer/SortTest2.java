package toOffer;
/**
 * ��������
 * @author swhe
 *
 */
public class SortTest2 {

	public static class QuickSort {

		public int getMiddle(int[] array, int low, int high) {
			int temp = array[low];
			while(low < high) {

				while(low<high& array[high]>temp) {
					high--;
				}
				array[low] = array[high];
				while(low<high& array[low]<temp) {
					low++;
				}
				array[high] = array[low];
			}
			array[low] = temp;

			return low;

		}


		public int[] quickSort(int[] array, int low, int high) {
			while(low<high){

				int middle = getMiddle(array,low,high);

				quickSort(array , low, middle-1);
//				quickSort(array , middle+1, high);
				low = middle+1; //尾递归
			}


			return array;
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
