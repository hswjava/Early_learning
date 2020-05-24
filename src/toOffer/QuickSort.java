package toOffer;

public class QuickSort {

	
	public int getMiddle(Integer[] list, int low, int high) {  
        int tmp = list[low];    //????????????????  
        while (low < high) {  
            while (low < high && list[high] > tmp) {  
                high--;  
            }  
            list[low] = list[high];   //??????§³??????????  
            while (low < high && list[low] < tmp) {  
                low++;  
            }  
            list[high] = list[low];   //????????????????  
        }  
        list[low] = tmp;              //????????¦Â  
        return low;                   //?????????¦Ë??  
    }  
	
	
	public void _quickSort(Integer[] list, int low, int high) {  
        if (low < high) {  
            int middle = getMiddle(list, low, high);  //??list?????????????  
            _quickSort(list, low, middle - 1);        //????????§Ö??????  
            _quickSort(list, middle + 1, high);       //????????§Ö??????  
        }  
    }  
	
	public void quick(Integer[] str) {  
        if (str.length > 0) {    //????????????  
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
