import lombok.Data;

import java.awt.*;
import java.util.Random;

@SuppressWarnings("all")
@Data
public class Tank {

    private int x,y;

    private Dir dir;

    private boolean moving=true;

    private Group group;

    private Random random = new Random();

    public static final int WIDTH = ResourceMgr.goodD.getWidth(),HEIGHT=ResourceMgr.goodD.getWidth();

    private static final int SPEED=5;

    private TankFrame tankFrame;

    private boolean living=true;

    public Tank(int x, int y, Dir dir,TankFrame tankFrame,Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame=tankFrame;
        this.group=group;
    }

    public void paint(Graphics g) {
        if(!living) tankFrame.tanks.remove(this) ;
        switch (dir){
            case LEFT:
                g.drawImage(this.group==Group.GOOD?ResourceMgr.goodL:ResourceMgr.badL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(this.group==Group.GOOD?ResourceMgr.goodR:ResourceMgr.badR,x,y,null);
                break;
            case DOWN:
                g.drawImage(this.group==Group.GOOD?ResourceMgr.goodD:ResourceMgr.badD,x,y,null);
                break;
            case UP:
                g.drawImage(this.group==Group.GOOD?ResourceMgr.goodU:ResourceMgr.badU,x,y,null);
                break;
        }

        move();
    }

    private void move() {

        if(!moving){
            return;
        }
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
            default:
                break;
        }
        if(this.group==Group.BAD && random.nextInt(100)>95){
            this.fire();
            randomDir();
        }
        boundCheck();
    }

    private void boundCheck() {
        if(this.x<0)x=0;
        if(this.y<30)y=30;
        if(this.x>tankFrame.getWidth()-this.WIDTH) x=tankFrame.getWidth()-this.WIDTH;
        if(this.y>tankFrame.getHeight()-this.HEIGHT) y=tankFrame.getHeight()-this.HEIGHT;
    }

    private void randomDir() {

        int i = random.nextInt(4);
        switch (i){
            case 1:
                this.dir=Dir.UP;
                break;
            case 2:
                this.dir=Dir.DOWN;
                break;
            case 3:
                this.dir=Dir.LEFT;
                break;
            case 4:
                this.dir=Dir.RIGHT;
                break;
        }
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void fire() {
        int bx=this.x+Tank.WIDTH/2-Bullet.WIDTH/2;
        int by=this.y+Tank.HEIGHT/2-Bullet.HEIGHT/2;
        tankFrame.bullets.add(new Bullet(bx,by,dir,this.tankFrame,this.group));
    }

    public void die() {
        this.living=false;
    }
}
