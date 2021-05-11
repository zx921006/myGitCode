import java.util.ArrayList;
import java.util.List;
public class TaoBaoTest {
    static volatile List<Integer> list = new ArrayList<>();
    static Object lock = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    add(i);
                    System.out.println("add " + i);
                    if (list.size() == 5) {
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        },"t1");
        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                if (getSize(list) != 5) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t2 结束");
                lock.notify();
            }

        },"t2");
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
