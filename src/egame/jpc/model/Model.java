package egame.jpc.model;

import egame.jpc.model.interfc.IModel;
import egame.jpc.view.GView;
import egame.jpc.world.World;
import egame.jpc.world.common.Vector2;

import java.awt.*;

/**
 * 抽象模型类
 * @author EasyDots
 *
 */
public abstract class Model implements IModel {

	protected Vector2 position;
	/*模型颜色*/
	protected Color color;
	/*模型标签*/
	protected String tag;
	/*模型管理的视图*/
	protected GView gview;
	/*模型所在的游戏世界*/
	protected World world;
	public Model(World world) {
		this.world = world;
		this.position = new Vector2(100,100);
		this.color = Color.BLACK;
		this.tag = "模型";
		createView();
	}
	/**
	 * 初始化游戏模型
	 */
	public void init(){
		world.add(this);
		world.getMframe().revalidate();
		/**
		 * 子类需要调用world.setRepeatable(this);
		 * 将模型加入集合
		 */
	}
	/**
	 * 销毁游戏模型
	 */
	public void destroy(){
		world.remove(this);
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
	public int getX(){
		return (int) position.x;
	}
	public int getY(){
		return (int)position.y;
	}
	public Vector2 getPosition() {
		return position;
	}
	public void setPosition(Vector2 vet2) {
		this.position = vet2;
	}
	public void setPosition(float x, float y) {
		this.position = new Vector2(x,y);
	}
}
