import lombok.Data;

import java.awt.*;

@Data
public class Explode {

    public static final int WIDTH = ResourceMgr.eImages[0].getWidth(),HEIGHT=ResourceMgr.eImages[0].getWidth();

    private int x,y;

    private boolean living=true;

    private TankFrame tankFrame;

    private int step =0;

    public Explode(int x, int y, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.tankFrame = tankFrame;
    }

    public void paint(Graphics g){
        g.drawImage(ResourceMgr.eImages[step++],x,y,null);
        if(step>=ResourceMgr.eImages.length){
            tankFrame.explodes.remove(this);
        }
    }
}
