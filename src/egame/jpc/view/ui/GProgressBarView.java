package egame.jpc.view.ui;

import egame.jpc.model.Model;
import egame.jpc.model.ui.GProgressBar;
import egame.jpc.view.GView;

import java.awt.*;


/**
 * 进度条视图
 * @author EasyDots
 *
 */
public class GProgressBarView extends GView {

	private GProgressBar gProgressBar;
	public GProgressBarView(Model model) {
		super(model);
		this.gProgressBar = (GProgressBar)model;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if(gProgressBar.isVisibility()){
//			System.out.println("go home");
			g.setColor(Color.black);
			g.draw3DRect(this.gProgressBar.getX(), this.gProgressBar.getY(), 100, 10, false);
			g.fill3DRect(this.gProgressBar.getX(), this.gProgressBar.getY(), gProgressBar.getCur(), 10, true);
			g.drawString(this.gProgressBar.getTag(),this.gProgressBar.getX()+40, this.gProgressBar.getY()+25);
		}


	}


}