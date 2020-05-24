package toOffer;

import java.util.ArrayList;

public class ListNodeTest {
	ArrayList<Integer> arrayList=new ArrayList<Integer>();
	
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
    if(listNode!=null){
    	this.printListFromTailToHead(listNode.next);
    	arrayList.add(listNode.val);
    		}
    	return arrayList;
    }
        
	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}
}
