import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadAndWriteLock {
    public static void read(Lock lock) {
        try {
            lock.lock();
            Thread.sleep(1000);
            System.out.println("read");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
    public static void write(Lock lock){

        try {
            lock.lock();
            System.out.println("write");
        }finally {
            lock.unlock();
        }

    }
     static Lock reLock = new ReentrantLock();

     static ReentrantReadWriteLock readAndWriteLock = new ReentrantReadWriteLock();

     static Lock readLock = readAndWriteLock.readLock();

     static Lock writeLock = readAndWriteLock.writeLock();
    public static void main(String[] args)  {
        Runnable read = ()->read (readLock);
        Runnable write = ()->write(writeLock);
        for(int i=0;i<20;i++)
            new Thread(read).start();
        for(int i=0;i<2;i++)
            new Thread(write).start();

    }
}
