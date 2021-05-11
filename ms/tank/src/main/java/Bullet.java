import lombok.Data;

import java.awt.*;

/**
 * 子弹类
 */
@Data
@SuppressWarnings("all")
public class Bullet {
    //速度
    private static final int SPEED = 10;

    public static final int WIDTH = ResourceMgr.bulletAll.getWidth(),HEIGHT=ResourceMgr.bulletAll.getWidth();

    private int x,y;
    //方向
    private Dir dir;

    private boolean living=true;

    private TankFrame tankFrame;

    private Group group;

    public Bullet(int x, int y, Dir dir,TankFrame tankFrame,Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame=tankFrame;
        this.group=group;
    }

    public void paint(Graphics g) {
        if(!living){
            tankFrame.bullets.remove(this);
        }
        g.drawImage(ResourceMgr.bulletAll,x,y,null);
        move();
    }

    private void move() {
        switch (dir){
            case UP:
                y-=SPEED;
                break;
            case DOWN:
                y+=SPEED;
                break;
            case LEFT:
                x-=SPEED;
                break;
            case RIGHT:
                x+=SPEED;
                break;
        }
        if(x<0 || y<0 || x> tankFrame.GAME_WIDTH||y > tankFrame.GAME_HEIGHT) living=false;
    }
    //子弹与坦克相撞
    public void collideWith(Tank tank) {
        if(this.group==tank.getGroup()){
            return;
        }
        //TODO:用一个Rectangle来记录子弹的位置
        Rectangle bulletRec = new Rectangle(this.x,this.y,WIDTH,HEIGHT);
        Rectangle tankRec = new Rectangle(tank.getX(),tank.getY(),Tank.WIDTH,Tank.HEIGHT);
        if(bulletRec.intersects(tankRec)){
            tank.die();
            this.die();
            int bx=tank.getX()+(Tank.WIDTH/2-Explode.WIDTH/2-50);
            int by=tank.getY()+(Tank.HEIGHT/2-Explode.HEIGHT/2-50);
            tankFrame.explodes.add(new Explode(bx,by,tankFrame));
        }
    }

    private void die() {
        this.living=false;
    }
}
