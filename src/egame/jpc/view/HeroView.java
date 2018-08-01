package egame.jpc.view;

import egame.jpc.model.Hero;
import egame.jpc.model.Model;

import java.awt.*;


public class HeroView extends CellView {
	private Hero hero;
	
	public HeroView(Model model) {
		super(model);
		this.hero = (Hero) model;
	}

	@Override
	public void paint(Graphics g) {
//		super.paint(g);
		drawDebug(g);
		g.setColor(Color.RED);
		g.drawArc(this.hero.getX(), this.hero.getY(), this.hero.getR()*2, this.hero.getR()*2, 0, 360);
//		g.drawOval(this.hero.getX(), this.hero.getY(), this.hero.getR()*2, this.hero.getR()*2);
		g.drawString(this.hero.getTag(), this.hero.getX(), this.hero.getY());
		if(hero.isGoHoming())
		drawGoHome(g);

	}
	public void drawGoHome(Graphics g){

		for(int startR = 0; startR <= 360; startR+=60)
		g.drawArc(this.hero.getX()-5, this.hero.getY()-5, this.hero.getR()+this.hero.deltaR, this.hero.getR()+this.hero.deltaR, startR+this.hero.startD, this.hero.arcWidth);
	}

	public void drawDebug(Graphics g){
		g.setColor(Color.BLACK);
		g.drawString(this.hero.toString(),this.hero.getX(),this.hero.getY()-40);
	}


}
