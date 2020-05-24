package toOffer;

import java.util.Stack;

/**
 * 用两个栈表示队列
 * @author swhe
 *
 */
public class StackToQueue {
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	public void push(int node) {
		stack1.push(node); 
	}

	public int pop() {
		// 先将栈1全部push到栈2
		while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		// 取栈2的第一个数，相当于栈1的反向
		int first = stack2.pop();
		// 再将栈1还原
		while (!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
		return first;
	}
	
	public static void main(String[] args) {
		StackToQueue stackToQueue = new StackToQueue();
		stackToQueue.push(1);
		stackToQueue.pop();
		stackToQueue.push(2);
		stackToQueue.push(3);
		stackToQueue.push(4);
		stackToQueue.pop();
		System.out.println(stackToQueue.stack1);
		
	}
}
