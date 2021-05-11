import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.LockSupport;

public class TaoBaoTest2 {
    static volatile List<Integer> list = new ArrayList<>();
    public static void main(String[] args)  {
        TaoBaoTest2 t = new TaoBaoTest2();
        t.add(1);
        t.size(list);
    }
    public  static void add(int i){
        list.add(i);
    }
    public  static Integer size(List list){
        return list.size();
    }
}
