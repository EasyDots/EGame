package egame.jpc.model;

import egame.jpc.model.interfc.IRepeat;
import egame.jpc.view.CellView;
import egame.jpc.view.GView;
import egame.jpc.world.World;
import egame.jpc.world.common.Vector2;


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
		this.setVet2(100,200);
		this.r = 20;
	}
	public Cell(World world,int x, int y, int r){
		super(world);
		this.setVet2(x, y);
		this.r = r;
	}
	public Cell(World world, Vector2 vector2, int r){
		super(world);
		this.setVet2(vector2);
		this.r = r;
	}
	@Override
	public void createView() {
		// TODO Auto-generated method stub
		this.gview = new CellView(this);

	}
	@Override
	public void init() {
		super.init();
		world.setRepeatable(this);
		world.getMframe().revalidate();
	}
	@Override
	public void destroy() {
		super.destroy();
		world.remove(this);
		world.removeRepeatable(this);
	}
	@Override
	public GView getView() {
		return this.gview;
	}

	@Override
	public void repeat() {
		setVet2(this.getVet2().x+ speedX, this.getVet2().y+ speedY);
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
