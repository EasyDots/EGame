package egame.jpc.model;

import egame.jpc.model.interfc.IModel;
import egame.jpc.model.interfc.IRepeat;
import egame.jpc.view.GView;
import egame.jpc.view.MainCityView;
import egame.jpc.world.World;
import egame.jpc.world.common.Vector2;

import java.awt.*;

/**
 * 主城类
 * 英雄回到主城,可以加HP,金币
 * @author EasyDots
 */
public class MainCity extends Model implements IRepeat, IModel {
	/*主城半径*/
	protected int r;

	/*主城回血速率,多少秒回一次血*/
	protected float bloodRecoveryRate = 1F;
	/*主城回血一次回血数量*/
	protected int bloodRecoveryCount = 10;
	/*主城给英雄多少秒增加一次金币*/
	protected int coinsAddRate = 1;
	/*主城给英雄一次增加的金币数量*/
	protected int coinsAddCount = 10;
	public MainCity(World world) {
		super(world);
	}
	public MainCity(World world, int x, int y, int r,Color color){
		this(world);
		this.setPosition(x,y);
		this.r = r;
		this.color = color;
	}
	public MainCity(World world, Vector2 position, int r, Color color){
		this(world);
		this.setPosition(position);
		this.r = r;
		this.color = color;
	}
	@Override
	public void createView() {
		this.gview = new MainCityView(this);
	}
	@Override
	public void init() {
		super.init();
		this.tag = "主城";
		world.add(this);
		world.setRepeatable(this);
	}

	@Override
	public void repeat() {
		world.invalidate(this);
		world.getMframe().revalidate();
	}
	@Override
	public void destroy() {
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

	public float getBloodRecoveryRate() {
		return bloodRecoveryRate;
	}

	public void setBloodRecoveryRate(float bloodRecoveryRate) {
		this.bloodRecoveryRate = bloodRecoveryRate;
	}

	public int getBloodRecoveryCount() {
		return bloodRecoveryCount;
	}

	public void setBloodRecoveryCount(int bloodRecoveryCount) {
		this.bloodRecoveryCount = bloodRecoveryCount;
	}

	public int getCoinsAddRate() {
		return coinsAddRate;
	}

	public void setCoinsAddRate(int coinsAddRate) {
		this.coinsAddRate = coinsAddRate;
	}

	public int getCoinsAddCount() {
		return coinsAddCount;
	}

	public void setCoinsAddCount(int coinsAddCount) {
		this.coinsAddCount = coinsAddCount;
	}

}
