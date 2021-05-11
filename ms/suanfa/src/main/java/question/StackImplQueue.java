package question;

import java.util.Stack;

/**
 * 栈(先进后出)实现队列（先进先出）
 */
public class StackImplQueue {
    private Stack<Integer> popStack;

    private Stack<Integer> pushStack;

    public StackImplQueue(){
        this.popStack=new Stack<Integer>();
        this.pushStack=new Stack<Integer>();
    }

    public void push(int num){
        pushStack.push(num);
        pushToPop();
    }
    public int pop(){
        if(popStack.isEmpty()&&pushStack.isEmpty()){
            throw new RuntimeException("无数据");
        }
        pushToPop();
        return popStack.pop();
    }
    private void pushToPop(){
        if(popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
    }
}
