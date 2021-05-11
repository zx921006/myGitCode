
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 写一个固定容量的同步容器，有put和get方法，以及getCount方法
 * 能够支持两个生产者线程，以及10个消费者线程的阻塞调用
 */
public class TaoBaoTest4<T>{
    final private LinkedList<T> list = new LinkedList<>();
    final private int MAX = 10;//最多10个元素

    private Lock lock = new ReentrantLock();
    private Condition producer = lock.newCondition();//生产者条件
    private Condition consumer = lock.newCondition();//消费者条件

    public void put(T t){
        try {
            lock.lock();
            while (list.size() == MAX){
                producer.await();//在这个条件下，生产者线程全部等待
            }
            list.add(t);
            consumer.signalAll();//通知消费者线程可以进行消费
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public  T get(){
        T t=null;
        try {
            lock.lock();
            while (list.size() == 0) {
                consumer.await();
            }
            t=list.removeFirst();
            producer.signalAll();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return t;

    }

    public static void main(String[] args) {
        TaoBaoTest4 baoTest4 = new TaoBaoTest4();

        for(int i=0;i<10;i++){
            new Thread(()->
            {
                for(int j=0;j<5;j++)
                    System.out.println(baoTest4.get());
            },"customer"+i).start();
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i=0;i<5;i++){
           new Thread(()->
           {    for(int j=0;j<10;j++)
               baoTest4.put(Thread.currentThread().getName()+"->"+j);
           },"producer"+i).start();
        }



    }
}
