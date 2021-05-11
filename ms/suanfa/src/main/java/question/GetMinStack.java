package question;

import java.util.Stack;

/**
 * 实现一个栈在基本功能（push,pop方法）上，实现返回栈中最小元素（getMin）功能,并且时间复杂度为O(1)
 */
public class GetMinStack {
    static class MyStack{
        private Stack<Integer> stackDate;

        private Stack<Integer> stackMin;

        public MyStack(){
            this.stackDate=new Stack<Integer>();
            this.stackMin =new Stack<Integer>();
        }

        public void push(Integer value){
            if(stackMin.isEmpty()){
                stackMin.push(value);
            }else if(value<=getMin()){
                stackMin.push(value);
            }else{
                stackMin.push(getMin());
            }
            stackDate.push(value);
        }
        public Integer pop(){
            if(stackDate.isEmpty()){
                throw new RuntimeException("栈为空，无法pop数据");
            }
            stackMin.pop();
            return stackDate.pop();
        }

        private Integer getMin() {
            if(stackMin.isEmpty()){
                throw new RuntimeException("栈为空，无法获取数据");
            }
            return stackMin.peek();
        }

        public static void main(String[] args) {
            MyStack mystack = new MyStack();
            mystack.push(2);
            mystack.push(3);
            mystack.push(4);
            mystack.push(5);
            mystack.push(7);
            mystack.push(8);
            mystack.push(1);
        }
    }

}
