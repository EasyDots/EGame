package egame.jpc.view.ui;

import egame.jpc.model.Model;
import egame.jpc.model.ui.GLevelCircle;
import egame.jpc.view.GView;

import java.awt.*;
import java.awt.image.ImageObserver;

/**
 * 经验值圈视图
 */
public class GLevelCircleView extends GView implements ImageObserver {
    private GLevelCircle gLevelCircle;

    public GLevelCircleView(Model model) {
        super(model);
        this.gLevelCircle = (GLevelCircle) model;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        /*可见则绘制*/
        if (gLevelCircle.isVisibility()) {

            /*绘制经验圈*/
            g.setColor(this.gLevelCircle.getOutsideColor());
            g.fillArc(this.gLevelCircle.getX() - this.gLevelCircle.getOutsideR(), this.gLevelCircle.getY() - this.gLevelCircle.getOutsideR(), this.gLevelCircle.getOutsideR()*2, this.gLevelCircle.getOutsideR()*2, 0, 360);

            g.setColor(this.gLevelCircle.getExpBarColor());
            g.fillArc((int) (this.gLevelCircle.getX() - this.gLevelCircle.getExpRScale() * this.gLevelCircle.getOutsideR()), (int) (this.gLevelCircle.getY() - this.gLevelCircle.getExpRScale() * this.gLevelCircle.getOutsideR()), (int) (this.gLevelCircle.getOutsideR() * this.gLevelCircle.getExpRScale())*2, (int) (this.gLevelCircle.getOutsideR() * this.gLevelCircle.getExpRScale())*2, this.gLevelCircle.getStart(), (int) ((this.gLevelCircle.getCur() / 100.0) * 360));

            g.setColor(this.gLevelCircle.getInsideColor());
            g.fillArc((int) (this.gLevelCircle.getX() - this.gLevelCircle.getInsideRScale() * this.gLevelCircle.getOutsideR()), (int) (this.gLevelCircle.getY() - this.gLevelCircle.getInsideRScale() * this.gLevelCircle.getOutsideR()), (int) (this.gLevelCircle.getOutsideR() * this.gLevelCircle.getInsideRScale())*2, (int) (this.gLevelCircle.getOutsideR() * this.gLevelCircle.getInsideRScale())*2, 0, 360);

            /*绘制等级文字*/
            if(this.gLevelCircle.getLevel() <= 10)
            g.drawImage(this.gLevelCircle.levelNumImgs.get(this.gLevelCircle.getLevel()-1),this.gLevelCircle.getX()-this.gLevelCircle.levelNumImgs.get(0).getWidth(this)/2,this.gLevelCircle.getY()-this.gLevelCircle.levelNumImgs.get(0).getHeight(this)/2, this);
//            g.setColor(this.gLevelCircle.getLevelTextColor());
//            Font font = new Font("Arial", Font.BOLD, 16);
//            g.setFont(font);
//            g.drawString(this.gLevelCircle.getLevel() + "", this.gLevelCircle.getX() - 8, this.gLevelCircle.getY() + 8);
        }
    }

}
