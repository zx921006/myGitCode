package observer.v4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Childer childer = new Childer();
        childer.wackUp();
    }
}
class Childer{
    private boolean cry=false;
    List<observer> observers = new ArrayList<observer>();
    {
      observers.add(new Dad());
      observers.add(new Mum());
      observers.add(new Dog());
    }
    public void wackUp(){
        cry =true;
        wakeUpEvent event = new wakeUpEvent(System.currentTimeMillis(),"bed",this);
        for(observer o:observers){
            o.actionForWakeUp(event);
        }
    }
}
//观察者公用接口
interface observer{
    void actionForWakeUp(wakeUpEvent event);
}
//第一个观察者
class Dad implements observer{
    public void feed(){
        System.out.println("dad feeding .....");
    }
    @Override
    public void actionForWakeUp(wakeUpEvent event) {
        this.feed();
    }
}
//第二个观察者
class Mum implements observer{
    public void feed(){
        System.out.println("mum feeding .....");
    }
    @Override
    public void actionForWakeUp(wakeUpEvent event) {
        this.feed();
    }
}
//第三个观察者
class Dog implements observer{
    public void feed(){
        System.out.println("dog feeding .....");
    }
    @Override
    public void actionForWakeUp(wakeUpEvent event) {
        this.feed();
    }
}
//事件类
class wakeUpEvent{
    long time;

    String msg;

    Childer source;

    public wakeUpEvent(long time, String msg,Childer source) {
        this.time = time;
        this.msg = msg;
        this.source=source;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
