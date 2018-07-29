package egame.jpc.view;

import egame.jpc.model.Hero;
import egame.jpc.model.Model;
import egame.jpc.model.interfc.ICollision;

import java.awt.*;


public class HeroView extends CellView implements ICollision {
	private Hero hero;
	
	public HeroView(Model model) {
		super(model);
		// TODO Auto-generated constructor stub
		this.hero = (Hero) model;
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.setColor(Color.RED);
		g.drawArc(this.hero.getX(), this.hero.getY(), this.hero.getR(), this.hero.getR(), 0, 360);
		g.drawString(this.hero.getTag(), this.hero.getX(), this.hero.getY());
		if(hero.isGoHoming())
		drawGoHome(g);
	}
	public void drawGoHome(Graphics g){

		for(int startR = 0; startR <= 360; startR+=60)
		g.drawArc(this.hero.getX()-5, this.hero.getY()-5, this.hero.getR()+this.hero.deltaR, this.hero.getR()+this.hero.deltaR, startR+this.hero.startD, this.hero.arcWidth);
	}

	@Override
	public void onCollision() {

	}
}
