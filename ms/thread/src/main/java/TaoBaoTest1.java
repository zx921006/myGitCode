import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class TaoBaoTest1 {
    static volatile List<Integer> list = new ArrayList<>();
    static CountDownLatch latch = new CountDownLatch(1);
    static CountDownLatch latch1 = new CountDownLatch(1);
    static Thread t1,t2;
    public static void main(String[] args) throws InterruptedException {
         t2 = new Thread(() -> {
//                try {
//                    latch.await();
//                    //LockSupport.park();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
                LockSupport.park();
                //latch1.countDown();
             System.out.println("t2 结束");
             LockSupport.unpark(t1);

        },"t2");
        t1 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                add(i);
                System.out.println("add "+ i);
                if(list.size()==5){
//                   latch.countDown();
//                    try {
//                        latch1.await();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    LockSupport.unpark(t2);
                    LockSupport.park();

                }
            }
        },"t1");

        t2.start();
        Thread.sleep(1000);
        t1.start();
    }
    public static void add(int i){
        list.add(i);
    }
    public static Integer getSize(List list){
        return list.size();
    }
}
