package egame.jpc.model;

import egame.jpc.model.interfc.IRepeat;
import egame.jpc.view.CellView;
import egame.jpc.view.GView;
import egame.jpc.world.World;
import egame.jpc.world.common.Vector2;


/**
 * 细胞模型类
 * @author EasyDots
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
	}
	public Cell(World world,int x, int y, int r){
		this(world);
		this.setPosition(x, y);
		this.r = r;
	}
	public Cell(World world, Vector2 vector2, int r){
		this(world);
		this.setPosition(vector2);
		this.r = r;

	}
	@Override
	public void createView() {
		this.gview = new CellView(this);
	}
	@Override
	public void init() {
		super.init();
		this.tag = "细胞";
		world.add(this);
		world.setRepeatable(this);
	}
	@Override
	public void destroy() {
		world.remove(this);
		world.removeRepeatable(this);
	}
	@Override
	public GView getView() {
		return this.gview;
	}
	@Override
	public void repeat() {
		setPosition(this.getPosition().x+ speedX, this.getPosition().y+ speedY);
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
