package toOffer;

public class QuickSort {

	
	public int getMiddle(Integer[] list, int low, int high) {  
        int tmp = list[low];    //����ĵ�һ����Ϊ����  
        while (low < high) {  
            while (low < high && list[high] > tmp) {  
                high--;  
            }  
            list[low] = list[high];   //������С�ļ�¼�Ƶ��Ͷ�  
            while (low < high && list[low] < tmp) {  
                low++;  
            }  
            list[high] = list[low];   //�������ļ�¼�Ƶ��߶�  
        }  
        list[low] = tmp;              //�����¼��β  
        return low;                   //���������λ��  
    }  
	
	
	public void _quickSort(Integer[] list, int low, int high) {  
        if (low < high) {  
            int middle = getMiddle(list, low, high);  //��list�������һ��Ϊ��  
            _quickSort(list, low, middle - 1);        //�Ե��ֱ���еݹ�����  
            _quickSort(list, middle + 1, high);       //�Ը��ֱ���еݹ�����  
        }  
    }  
	
	public void quick(Integer[] str) {  
        if (str.length > 0) {    //�鿴�����Ƿ�Ϊ��  
            _quickSort(str, 0, str.length - 1);  
        }  
    }  
	  
    /**  
     * @param args  
     */  
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
         Integer[] list={34,3,53,2,23,7,14,10};  
         QuickSort qs=new QuickSort();  
         qs.quick(list);  
         for(int i=0;i<list.length;i++){  
             System.out.print(list[i]+" ");  
         }  
         System.out.println();  
    }  
	
	
}
