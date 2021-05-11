import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 按照顺序打印A1B2C3.。。。。Z26
 */
public class TaoBaoTest3 {
    static Object o = new Object();
    static String [] arr = {"a","b","c","d","e","f","g","h"};
    public static void main(String[] args) {
        new Thread(()->{
            synchronized (o) {
                for (int i = 0; i < arr.length; i++) {
                    if (i % 2 == 0) {
                        System.out.println("线程t1打印" + arr[i]);
                        try {
                            o.wait();
                            o.notify();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
        new Thread(()->{
            synchronized (o) {
                for (int i = 0; i < arr.length; i++) {
                    if (i % 2 == 1) {
                        System.out.println("线程t2打印" + arr[i]);
                        try {
                            o.notify();
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        },"t2").start();

    }
}
