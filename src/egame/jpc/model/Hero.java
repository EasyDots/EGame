package egame.jpc.model;

import egame.jpc.model.ui.GProgressBar;
import egame.jpc.view.HeroView;
import egame.jpc.world.World;

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
		// TODO Auto-generated constructor stub
		this.mainCity = mainCity;
		this.gpb = new GProgressBar(world);

	}
	public Hero(World world, int x, int y){
		super(world);
		this.x = x;
		this.y = y;
	}
	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		this.gpb.init();
		this.gpb.setVisibility(false);
		this.gpb.setTag("回城");
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
		this.gpb.setX(this.x-this.r/3);
		this.gpb.setY(this.y+this.r+10);
		this.gpb.showTime  = 1.5f;
		this.gpb.doProcess();
//		System.out.println("英雄使用了回城技能");
		thread = new Thread(new Runnable() {
			public boolean canceled = false;
			@Override
			public void run() {
				// TODO Auto-generated method stub

				try {
					for(Hero.this.startD = 0;Hero.this.startD<360;Hero.this.startD+=1){

						Thread.sleep(goHomeTime/(360));
					}
					Hero.this.x = mainCity.x+mainCity.getR()/5;
					Hero.this.y = mainCity.y+mainCity.getR()/5;
					Hero.this.goHoming = false;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					thread.interrupt();
				}

			}

		});
		thread.start();


	}
}
