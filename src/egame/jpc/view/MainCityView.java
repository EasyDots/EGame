package egame.jpc.view;

import egame.jpc.model.MainCity;
import egame.jpc.model.Model;

import java.awt.*;

public class MainCityView extends GView{
	private MainCity mainCity;
	public MainCityView(Model model) {
		super(model);
		this.mainCity = (MainCity) model;
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);

		g.setColor(this.mainCity.getColor());
		g.drawArc(this.mainCity.getX(), this.mainCity.getY(), this.mainCity.getR(), this.mainCity.getR(), 0, 360);
		//显示文本
		g.drawString("主城", this.mainCity.getX(), this.mainCity.getY());
		//System.out.println("主城刷新了");

	}
}
