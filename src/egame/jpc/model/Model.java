package egame.jpc.model;

import egame.jpc.model.interfc.IModel;
import egame.jpc.view.GView;
import egame.jpc.world.World;

import java.awt.*;

/**
 * 抽象模型类
 * @author Administrator
 *
 */
public abstract class Model implements IModel {
	/*模型位置x*/
	protected int x;
	/*模型位置y*/
	protected int y;

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
		this.x = point.x;
		this.y = point.y;
	}

	protected Point point;
	/*模型颜色*/
	protected Color color;
	/*模型标签*/
	protected String tag;
	/*模型管理的视图*/
	protected GView gview;
	/*模型所在的游戏世界*/
	protected World world;
	public Model(World world) {
		// TODO Auto-generated constructor stub
		this.world = world;
		createView();
	}


	/**
	 * 初始化游戏模型
	 */
	public void init(){
		this.x = 100;
		this.y = 100;
		this.point = new Point(x, y);
		this.color = Color.BLACK;
		this.tag = "模型";

		world.add(this);
	}
	/**
	 * 销毁游戏模型
	 */
	public void destroy(){
		world.remove(this);
	}


	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
		this.point.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
		this.point.y = y;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}

	public GView getGview() {
		return gview;
	}
	public void setGview(GView gview) {
		this.gview = gview;
	}
}
