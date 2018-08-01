package egame.jpc.world.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Auther: EasyDots
 * @Date: 2018/8/2 0002 00:57
 * @Description:
 * @Url: www.ncgds.cn
 */
public class Texture {
    public static boolean clipImageToFile(InputStream inputStream, int x, int y, int w, int h, String sufix, File file) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(inputStream);
        bufferedImage = bufferedImage.getSubimage(x,y,w,h);
        return ImageIO.write(bufferedImage,sufix,file);
    }
    public static BufferedImage getClipImg(String filePath, int x, int y, int w, int h) throws Exception {
        BufferedImage bufferedImage = ImageIO.read(new FileInputStream(filePath));
        bufferedImage = bufferedImage.getSubimage(x,y,w,h);
        return bufferedImage;
    }

}
