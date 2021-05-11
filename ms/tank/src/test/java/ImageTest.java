import org.junit.Test;

import java.io.InputStream;


public class ImageTest {
    @Test
    public void test() throws Exception{
      /*  BufferedImage image=ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("src/test/java/link.jpg"));
        System.out.println(image);*/
        InputStream resourceAsStream = ImageTest.class.getClassLoader().getResourceAsStream("image/link.jpg");
        System.out.println(resourceAsStream);
    }
}
