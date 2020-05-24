package toOffer;

import java.util.Stack;

/**
 * ������ջ��ʾ����
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
		// �Ƚ�ջ1ȫ��push��ջ2
		while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		// ȡջ2�ĵ�һ�������൱��ջ1�ķ���
		int first = stack2.pop();
		// �ٽ�ջ1��ԭ
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
