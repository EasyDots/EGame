package egame.jpc.model;

import egame.jpc.model.interfc.IModel;
import egame.jpc.model.interfc.IRepeat;
import egame.jpc.view.GView;
import egame.jpc.view.MainCityView;
import egame.jpc.world.World;

import java.awt.*;

public class MainCity extends Model implements IRepeat, IModel {
	private int r;
	public MainCity(World world) {
		super(world);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createView() {
		// TODO Auto-generated method stub
		this.gview = new MainCityView(this);


	}
	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		this.x = 200;
		this.y = 200;
		this.r = 90;
		this.color = Color.ORANGE;
		world.setRepeatable(this);
		world.getMframe().revalidate();

	}

	@Override
	public void repeat() {
		// TODO Auto-generated method stub
		world.invalidate(this);
		world.getMframe().revalidate();
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		world.remove(this);
		world.removeRepeatable(this);
		System.out.println("MainCity销毁了");
	}
	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}
	@Override
	public GView getView() {
		// TODO Auto-generated method stub
		return this.gview;
	}

}
