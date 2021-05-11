package proxy.v1;

/**
 * 静态代理
 */
public class Tank implements Movable{
    @Override
    public void move() {
        System.out.println("tank moving......");
    }

    public static void main(String[] args) {
        new TimeProxy(new LogProxy(new Tank())).move();
    }
}

interface Movable{
    void move();
}
class TimeProxy implements Movable{
    Movable movable;

    public TimeProxy(Movable movable) {
        this.movable = movable;
    }

    @Override
    public void move() {
        System.out.println("timeProxy moving ......");
        movable.move();
    }

}
class LogProxy implements Movable{
    Movable movable;

    public LogProxy(Movable movable) {
        this.movable = movable;
    }

    @Override
    public void move() {
        System.out.println("LogProxy moving ......");
        movable.move();
    }
}
