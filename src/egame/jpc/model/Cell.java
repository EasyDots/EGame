package egame.jpc.model;

import egame.jpc.model.interfc.IRepeat;
import egame.jpc.view.CellView;
import egame.jpc.view.GView;
import egame.jpc.world.World;


/**
 * 细胞模型类
 * @author Administrator
 *
 */
public class Cell extends Model implements IRepeat {
	/*细胞半径*/
	protected int r = 1;
	/*细胞速度*/
	protected int speedX = 0;
	protected int speedY = 0;


	public Cell(World world) {
		super(world);
		this.x = 100;
		this.y = 200;
		this.r = 20;
	}
	public Cell(World world, int x, int y, int r){
		super(world);
		this.x = x;
		this.y = y;
		this.r = r;
	}
	@Override
	public void createView() {
		// TODO Auto-generated method stub
		this.gview = new CellView(this);

	}
	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		world.setRepeatable(this);
		world.getMframe().revalidate();
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		world.remove(this);
		world.removeRepeatable(this);
	}
	@Override
	public GView getView() {
		// TODO Auto-generated method stub
		return this.gview;
	}

	@Override
	public void repeat() {
		// TODO Auto-generated method stub
		setX(getX() + speedX);
		setY(getY() + speedY);

		world.invalidate(this);
		world.getMframe().revalidate();
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}
	public int getSpeedX() {
		return speedX;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public int getSpeedY() {
		return speedY;
	}

	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}

}
