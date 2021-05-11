import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceMgr {
    public static BufferedImage goodL,goodR,goodU,goodD,bulletAll,badL,badR,badU,badD;
    public static BufferedImage[] eImages = new BufferedImage[12];
    static {
        try {
            goodU= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/goodTank.png"));
            goodR= ImageUtil.rotateImage(goodU,90);
            goodL= ImageUtil.rotateImage(goodU,-90);
            goodD= ImageUtil.rotateImage(goodU,180);

            badU= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/badTank.gif"));
            badR= ImageUtil.rotateImage(badU,90);
            badL= ImageUtil.rotateImage(badU,-90);
            badD= ImageUtil.rotateImage(badU,180);
            bulletAll= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/bullet.png"));
            //将爆炸图片加入内存
            for(int i=0;i<12;i++) eImages[i]=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("image/e"+(i+1)+".png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
