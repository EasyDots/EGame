package egame.jpc.model;

import egame.jpc.model.interfc.IModel;
import egame.jpc.model.interfc.IRepeat;
import egame.jpc.view.GView;
import egame.jpc.view.MainCityView;
import egame.jpc.world.World;

import java.awt.*;

/**
 * 主城类
 */
public class MainCity extends Model implements IRepeat, IModel {
	private int r;
	public MainCity(World world) {
		super(world);
	}

	@Override
	public void createView() {
		this.gview = new MainCityView(this);


	}
	@Override
	public void init() {
		super.init();
		this.setVet2(200,200);
		this.r = 90;
		this.color = Color.ORANGE;
		world.setRepeatable(this);
		world.getMframe().revalidate();

	}

	@Override
	public void repeat() {
		world.invalidate(this);
		world.getMframe().revalidate();
	}
	@Override
	public void destroy() {
		super.destroy();
		world.remove(this);
		world.removeRepeatable(this);
	}
	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}
	@Override
	public GView getView() {
		return this.gview;
	}

}
