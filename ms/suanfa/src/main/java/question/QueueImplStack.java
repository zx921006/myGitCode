package question;

import java.util.Queue;

/**
 * 队列实现栈
 */
public class QueueImplStack {
    private Queue<Integer> queue;

    private Queue<Integer> help;

    public void push(int num){
        queue.offer(num);
    }
    public int pop(){
        while (queue.size()>1){
            //将原来队列中的数据导入到help
            help.offer(queue.poll());
        }
        //拿到需要的数据，然后将queue和help的引用对换
        int ans = queue.poll();
        Queue<Integer> temp=queue;
        queue=help;
        help=temp;
        return ans;
    }
}
