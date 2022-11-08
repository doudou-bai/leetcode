package 队列;

import java.util.Stack;

/**
 * Create By 王嘉浩
 * Time 2022-11-05 17:28
 */
public class _232_用栈实现队列 {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public _232_用栈实现队列() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        checkOutStack();
        return outStack.pop();
    }

    /**
     * 获取队头
     *
     * @return
     */
    public int peek() {
        checkOutStack();
        return outStack.peek();
    }

    /**
     * 是否为空
     *
     * @return
     */
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void checkOutStack() {
        if (outStack.isEmpty()) {
            while (!inStack.empty()) {
                outStack.push(inStack.pop());
            }
        }
    }
}
