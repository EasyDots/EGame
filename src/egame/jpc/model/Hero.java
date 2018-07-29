package egame.jpc.model;

import egame.jpc.model.ui.GLevelCircle;
import egame.jpc.model.ui.GProgressBar;
import egame.jpc.model.ui.GStatusBar;
import egame.jpc.view.HeroView;
import egame.jpc.world.World;
import egame.jpc.world.input.GameListener;

import java.awt.*;
public class Hero extends Cell{
	/*英雄的名字*/
	protected String name;
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

	public Thread getThread() {
		return thread;
	}

	public boolean isGoHoming() {
		return goHoming;
	}

	public void setGoHoming(boolean goHoming) {
		this.goHoming = goHoming;
	}

	public Hero(World world, MainCity mainCity) {
		super(world);
		this.mainCity = mainCity;
		this.gpb = new GProgressBar(world);
		this.gLevelCircle = new GLevelCircle(world);
		this.gHp = new GStatusBar(world);
		this.gMp = new GStatusBar(world);
	}
	public Hero(World world, int x, int y){
		super(world);
		this.setVet2(x,y);
	}

	@Override
	public void init() {
		super.init();
		/*回城进度条初始化*/
		this.gpb.init();
		this.gpb.setVisibility(false);
		this.gpb.setTag("回城");
		/*经验圈初始化*/
		this.gLevelCircle.init();
		this.gHp.init();
		this.gHp.setCur(100);
		this.gHp.setColor(Color.RED);
		this.gHp.setVisibility(true);
		this.gMp.init();
		this.gMp.setCur(100);
		this.gMp.setColor(Color.BLUE);
		this.gMp.setVisibility(true);
		this.r = 60;
		this.color = Color.yellow;
		this.name = "英雄";
		this.tag = this.name;
	}

	@Override
	public void createView() {
		// TODO Auto-generated method stub
		super.createView();
		this.gview = new HeroView(this);
	}
	/**
	 * 回城方法
	 */
	public void goHome(){
		this.goHoming = true;
		this.gpb.setVet2(this.getVet2().x - this.r/3, this.getVet2().y + this.r+10);
		this.gpb.showTime  = 1.5f;
		this.gpb.doProcess();
		thread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					for (Hero.this.startD = 0; Hero.this.startD < 360; Hero.this.startD += 1) {
						Thread.sleep(goHomeTime/(360));
					}
					Hero.this.getVet2().x = mainCity.getVet2().x+mainCity.getR()/5;
					Hero.this.getVet2().y = mainCity.getVet2().y+mainCity.getR()/5;
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
		super.repeat();
		this.gLevelCircle.setFollow(this);
		this.gHp.setFollow(this.getVet2().x + 20, this.getVet2().y - 10);
		this.gMp.setFollow(this.getVet2().x + 20, this.getVet2().y);
	}

	/**
	 * 英雄移动
	 *
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
}
