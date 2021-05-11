package cglib;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import sun.misc.Unsafe;

import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

public class Main {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        Unsafe unsafe = Unsafe.getUnsafe();
        LongAdder adder = new LongAdder();
        adder.increment();
        Enhancer enhancer = new Enhancer();//增强器
        enhancer.setSuperclass(Tank.class);
        enhancer.setCallback(new TimeMethodInterceptor());
        Tank tank = (Tank)enhancer.create();
        tank.move();

    }

}
class TimeMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before");
        Object result = null;
        result=methodProxy.invokeSuper(o,objects);
        System.out.println(result);
        System.out.println("aaaaa");
//        result=methodProxy.invoke(o,objects);
//        System.out.println(result);
        System.out.println("after");
        return result;
    }
}
final class Tank {
    public void move() {
        System.out.println("tank moving......");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
