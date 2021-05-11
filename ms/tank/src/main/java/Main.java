

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tf=new TankFrame();
        int tankCount=Integer.parseInt(PropertyMgr.get("initTankCount").toString());
        //初始化敌方坦克
        for(int i=0;i<tankCount;i++){
            tf.tanks.add(new Tank(200+i*200,200,Dir.DOWN,tf,Group.BAD));
        }
        for(;;){
            Thread.sleep(50);
            tf.repaint();
        }
    }
}
