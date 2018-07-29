package egame.jpc.model;

import egame.jpc.model.ui.GLevelCircle;
import egame.jpc.model.ui.GProgressBar;
import egame.jpc.model.ui.GStatusBar;
import egame.jpc.view.HeroView;
import egame.jpc.world.World;
import egame.jpc.world.common.Vector2;
import egame.jpc.world.input.GameListener;

import java.awt.*;

/**
 * 英雄类
 */
public class Hero extends Cell{
	/*英雄的名字*/
	protected String name;
	/*英雄伤害*/
	protected int damage = 10;
	/*攻击速率,多少秒攻击一次*/
	protected float attackRate = 1F;
	/*攻击的范围*/
	protected int attackRangeRadius = 50;
	/*所在的主城*/
	protected MainCity mainCity;
	/*是否已经回到主城*/
	private boolean goHoming = false;
	/*回城进度条*/
	public GProgressBar gpb;
	/*经验圈*/
	public GLevelCircle gLevelCircle;
	/*HP*/
	public GStatusBar gHp;
	/*MP*/
	public GStatusBar gMp;
	/*回城时间*/
	public int goHomeTime = 1500;
	/*回城特效外圈半径差*/
	public int deltaR = 10;
	/*回城特效开始角度*/
	public int startD = 0;
	/*回城特效结束角度*/
	public int endD = 10;
	/*回城特效外圈弧长度*/
	public int arcWidth = 20;
	/*回城线程*/
	private Thread thread;
	public Hero(World world){
		super(world);
	}
	public Hero(World world, MainCity mainCity) {
		this(world);
		this.mainCity = mainCity;
		this.gpb = new GProgressBar(world, false);
		this.gLevelCircle = new GLevelCircle(world,this.position,0,1,true);
		this.gHp = new GStatusBar(world,20,Color.RED, true);
		this.gMp = new GStatusBar(world, 15, Color.BLUE, true);
	}
	public Hero(World world, MainCity mainCity, int r, Color color) {
		this(world);
		this.mainCity = mainCity;
		this.r = r;
		this.color = color;
		this.gpb = new GProgressBar(world, false);
		this.gLevelCircle = new GLevelCircle(world,this.position,0,1,true);
		this.gHp = new GStatusBar(world,20,Color.RED, true);
		this.gMp = new GStatusBar(world, 15, Color.BLUE, true);
	}
	public Hero(World world, int x, int y){
		this(world);
		this.setPosition(x,y);
	}
	public Hero(World world, Vector2 position){
		super(world);
		this.setPosition(position);
	}


	@Override
	public void init() {
		super.init();
		/*回城进度条初始化*/
		this.gpb.init();
		this.gpb.setTag("回城");
		/*经验圈初始化*/
		this.gLevelCircle.init();
		this.gHp.init();
		this.gMp.init();
		this.name = "英雄";
		this.tag = this.name;
		world.add(this);
		world.setRepeatable(this);
	}

	@Override
	public void createView() {
		this.gview = new HeroView(this);
	}

	@Override
	public void destroy() {
		world.remove(this);
		world.removeRepeatable(this);
	}

	/**
	 * 回城方法
	 */
	public void goHome(){
		this.goHoming = true;
		this.gpb.setPosition(this.getPosition().x - this.r/3, this.getPosition().y + this.r+10);
		this.gpb.showTime  = 1.5f;
		this.gpb.doProcess();
		thread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					for (Hero.this.startD = 0; Hero.this.startD < 360; Hero.this.startD += 1) {
						Thread.sleep(goHomeTime/(360));
					}
					Hero.this.getPosition().x = mainCity.getPosition().x+mainCity.getR()/5;
					Hero.this.getPosition().y = mainCity.getPosition().y+mainCity.getR()/5;
					Hero.this.goHoming = false;
				} catch (InterruptedException e) {
					e.printStackTrace();
					thread.interrupt();
				}
			}
		});
		thread.start();
	}

	@Override
	public void repeat() {
		setPosition(this.getPosition().x+ speedX, this.getPosition().y+ speedY);
		this.gLevelCircle.setFollow(this);
		this.gHp.setFollow(this.getPosition().x + 20, this.getPosition().y - 10);
		this.gMp.setFollow(this.getPosition().x + 20, this.getPosition().y);
		world.invalidate(this);
		world.getMframe().revalidate();
	}

	/**
	 * 英雄移动
	 * @param direction 方向
	 */
	public void move(GameListener.Direction direction) {
		switch (direction) {
			case UP:
				setSpeedY(-1);
				break;
			case LEFT:
				setSpeedX(-1);
				break;
			case DOWN:
				setSpeedY(1);
				break;
			case RIGHT:
				setSpeedX(1);
				break;
		}
	}

	/**
	 * 英雄休息
	 *
	 * @param direction 方向
	 */
	public void idle(GameListener.Direction direction) {
		switch (direction) {
			case UP:
				setSpeedY(0);
				break;
			case LEFT:
				setSpeedX(0);
				break;
			case DOWN:
				setSpeedY(0);
				break;
			case RIGHT:
				setSpeedX(0);
				break;
		}

	}
	/**
	 * 英雄升级
	 */
	public void upgrade(){
		this.gLevelCircle.addExp(2);
	}
	/**
	 * 使用治疗
	 */
	public void useTreatment(){
		this.gHp.setCur(this.gHp.getCur()+2);
	}
	public Thread getThread() {
		return thread;
	}
	public boolean isGoHoming() {
		return goHoming;
	}

	public void setGoHoming(boolean goHoming) {
		this.goHoming = goHoming;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public float getAttackRate() {
		return attackRate;
	}

	public void setAttackRate(float attackRate) {
		this.attackRate = attackRate;
	}

	public int getAttackRangeRadius() {
		return attackRangeRadius;
	}

	public void setAttackRangeRadius(int attackRangeRadius) {
		this.attackRangeRadius = attackRangeRadius;
	}

	public MainCity getMainCity() {
		return mainCity;
	}

	public void setMainCity(MainCity mainCity) {
		this.mainCity = mainCity;
	}


}
