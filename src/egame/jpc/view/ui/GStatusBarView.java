package egame.jpc.view.ui;

import egame.jpc.model.Model;
import egame.jpc.model.ui.GStatusBar;
import egame.jpc.view.GView;

import java.awt.*;


/**
 * 状态条视图
 */
public class GStatusBarView extends GView {
    private GStatusBar gStatusBar;
    public GStatusBarView(Model model) {
        super(model);
        this.gStatusBar = (GStatusBar) model;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (gStatusBar.isVisibility()) {
            g.setColor(Color.BLACK);
            g.drawRect(this.gStatusBar.getX(), this.gStatusBar.getY(), 100, 10);

            g.setColor(this.gStatusBar.getColor());
            g.fill3DRect(this.gStatusBar.getX(), this.gStatusBar.getY(), gStatusBar.getCur(), 10, true);
            //g.drawString(this.gStatusBar.getTag(),this.gStatusBar.getX()+40, this.gStatusBar.getY()+25);
        }

    }


}