package proxy.v1;

/**
 *懒汉式
 */
public class DanLI {
    private static volatile DanLI INSTANCE;
    private DanLI(){}

    public static DanLI getInstance(){
        if(INSTANCE==null){
            synchronized (DanLI.class){
                if(INSTANCE==null){
                    INSTANCE = new DanLI();
                }
            }
        }
        return INSTANCE;
    }
}
