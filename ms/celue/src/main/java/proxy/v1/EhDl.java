package proxy.v1;

/**
 * 饿汉式
 */
public class EhDl {
    private static  final EhDl INSTANCE = new EhDl();
    private EhDl(){}
    public static EhDl getInstance(){
        return INSTANCE;
    };
}
