package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Tank implements Movable {
    @Override
    public void move() {
        System.out.println("tank moving......");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        final Tank tank = new Tank();
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
//       Movable m =(Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(),
//               new Class[]{Movable.class},(proxy,method,args1)->
//               {
//                   System.out.println("method:"+method.getName()+"start");
//                   Object invoke = method.invoke(tank, args1);
//                   System.out.println("method:"+method.getName()+"end");
//                   return invoke;
//               });
        Movable m =(Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(),
               new Class[]{Movable.class},new MyHandler(tank));
        m.move();//move方法肯定调用了invoke方法
    }
}
class MyHandler implements InvocationHandler{
    Tank tank;

    public MyHandler(Tank tank) {
        this.tank = tank;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                   System.out.println("method:"+method.getName()+"start");
                   Object invoke = method.invoke(tank, args);
                   System.out.println("method:"+method.getName()+"end");
                   return invoke;
    }
}
interface Movable{
    void move();
}
