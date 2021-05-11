import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TankFrame extends Frame {
    static final int GAME_WIDTH=1300,GAME_HEIGHT=1000;
    Tank myTank = new Tank(650,500,Dir.DOWN,this,Group.GOOD);
    List<Bullet> bullets = new ArrayList<Bullet>();
    List<Tank> tanks = new ArrayList<Tank>();
    List<Explode> explodes = new ArrayList<Explode>();
    public TankFrame()  {
        setSize(GAME_WIDTH,GAME_HEIGHT);
        setResizable(false);
        setTitle("tank war");
        setVisible(true);
        addKeyListener(new MyKeyListener());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    Image offScreenImage=null;
    @Override
    public void update(Graphics g){
        if(offScreenImage==null){
            offScreenImage=this.createImage(GAME_WIDTH,GAME_HEIGHT);
        }
        Graphics gs = offScreenImage.getGraphics();
        Color color = gs.getColor();
        gs.setColor(Color.black);
        gs.fillRect(0,0,GAME_WIDTH,GAME_HEIGHT);
        gs.setColor(color);
        paint(gs);
        g.drawImage(offScreenImage,0,0,null);
    }
    /**
     * 窗口打开就会被调用
     * @param g 系统画笔
     */
    @Override
    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        g.drawString("子弹数量为:"+bullets.size(),10,60);
        g.drawString("敌人数量为:"+tanks.size(),10,80);
        myTank.paint(g);
        for(int i=0;i<bullets.size();i++){
            bullets.get(i).paint(g);
        }
        for(int i=0;i<tanks.size();i++){
            tanks.get(i).paint(g);
        }
        for(int i=0;i<bullets.size();i++){
            for(int j=0;j<tanks.size();j++){
                bullets.get(i).collideWith(tanks.get(j));
            }
        }
        for(int i=0;i<explodes.size();i++){
            explodes.get(i).paint(g);
        }
    }


    /**
     * 处理键盘事件
     */
    class MyKeyListener extends KeyAdapter {
        boolean bL=false;
        boolean bR=false;
        boolean bU=false;
        boolean bD=false;
        //按键事件
        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT://键盘左键
                    bL=true;
                    break;
                case KeyEvent.VK_RIGHT://键盘右键
                    bR=true;
                    break;
                case KeyEvent.VK_UP://键盘上键
                    bU=true;
                    break;
                case KeyEvent.VK_DOWN://键盘下键
                    bD=true;
                    break;
                default:
                    break;
            }
           // repaint();//默认调用paint方法
            setMainTankDir();
        }
        //松开键事件
        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT://键盘左键
                    bL=false;
                    break;
                case KeyEvent.VK_RIGHT://键盘右键
                    bR=false;
                    break;
                case KeyEvent.VK_UP://键盘上键
                    bU=false;
                    break;
                case KeyEvent.VK_DOWN://键盘下键
                    bD=false;
                    break;
                case KeyEvent.VK_SPACE:
                    myTank.fire();
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        /**
         * 设置主坦克的方向
         */
        private void setMainTankDir() {
            //如果没有按上下左右键则让tank保持静止
            if(!bL&&!bR&&!bD&&!bU)myTank.setMoving(false);
            else {
                myTank.setMoving(true);
                if (bL) myTank.setDir(Dir.LEFT);
                if (bR) myTank.setDir(Dir.RIGHT);
                if (bD) myTank.setDir(Dir.DOWN);
                if (bU) myTank.setDir(Dir.UP);
            }

        }
    }


}
