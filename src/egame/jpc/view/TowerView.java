package egame.jpc.view;

import egame.jpc.model.Model;
import egame.jpc.model.Tower;

import java.awt.*;

/**
 * @Auther: EasyDots
 * @Date: 2018/7/29 0029 19:13
 * @Description:
 * @Url: www.ncgds.cn
 */
public class TowerView extends GView{
    private Tower tower;
    public TowerView(Model model) {
        super(model);
        this.tower = (Tower)model;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.RED);
        g.drawArc(this.tower.getX(), this.tower.getY(), this.tower.getAttackRangeRadius(), this.tower.getAttackRangeRadius(), 0, 360);
        g.drawString(this.tower.getTag(), this.tower.getX(), this.tower.getY());

    }
}
