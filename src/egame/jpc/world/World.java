package egame.jpc.world;


import egame.jpc.frame.GameFrame;
import egame.jpc.frame.MainFrame;
import egame.jpc.game.conf.Conf;
import egame.jpc.model.Hero;
import egame.jpc.model.MainCity;
import egame.jpc.model.interfc.IModel;
import egame.jpc.model.interfc.IRepeat;
import egame.jpc.model.ui.GProgressBar;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class World implements EasyGame{
	/*窗口*/
	private GameFrame gframe;
	private MainFrame mframe;
	public MainFrame getMframe() {
		return mframe;
	}

	/*是否销毁*/
	private boolean destroyed;
	/*模型集合*/
	List<IRepeat> modelList = new CopyOnWriteArrayList<IRepeat>();
	/*线程*/
	Thread thread;
	/*细胞主角*/
//	private Cell cell;
//	private MainCity mainCity;
//	private Cell cell2;
//	private Hero myHero;
	private GProgressBar gpb;
	private MainCity mainCity1;
	private Hero hero1;
	private MainCity mainCity2;
	private Hero hero2;
	public World(MainFrame frame){
		this.mframe = frame;
	}
	/**
	 * 创建玩家角色
	 */
	public void createPlayer() {

		/*创建玩家1*/
		mainCity1 = new MainCity(this);
		mainCity1.init();
		mainCity1.setX(100);
		mainCity1.setY(400);
		hero1 = new Hero(this, mainCity1);
		hero1.init();

		/*创建玩家2*/
//		mainCity2 = new MainCity(this);
//		mainCity2.init();
//		mainCity2.setX(400);
//		mainCity2.setY(400);
//		hero2 = new Hero(this, mainCity2);
//		hero2.init();
//		hero2.setX(400);

//		LinkedList<Model> heros = new LinkedList<Model>();
//		heros.add(new Hero(this,mainCity));
//		heros.get(0).init();
//		/*创建一个自己的英雄*/
//		myHero = new Hero(this, mainCity);
//		myHero.init();


	}
	/**
	 * 初始化游戏世界
	 */
	public void init(){
		/*创建游戏视图框架*/
		this.gframe = new GameFrame(mframe);
		/*设置按键事件*/
		mframe.addKeyListener(new KeyListener() {



			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				switch (e.getKeyCode()) {
					case KeyEvent.VK_W:
						hero1.setSpeedY(0);
						break;
					case KeyEvent.VK_A:
						hero1.setSpeedX(0);
						break;
					case KeyEvent.VK_S:
						hero1.setSpeedY(0);
						break;
					case KeyEvent.VK_D:
						hero1.setSpeedX(0);
						break;
					case KeyEvent.VK_UP:
						hero2.setSpeedY(0);
						break;
					case KeyEvent.VK_LEFT:
						hero2.setSpeedX(0);
						break;
					case KeyEvent.VK_DOWN:
						hero2.setSpeedY(0);
						break;
					case KeyEvent.VK_RIGHT:
						hero2.setSpeedX(0);
						break;
                    /*按U演示经验圈增加*/
                    case KeyEvent.VK_U:
                        hero1.gLevelCircle.addExp(2);
                        break;
					default:
						break;
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				switch (e.getKeyCode()) {
					case KeyEvent.VK_W:
						hero1.setSpeedY(-1);
						break;
					case KeyEvent.VK_A:
						hero1.setSpeedX(-1);
						break;
					case KeyEvent.VK_S:
						hero1.setSpeedY(1);
						break;
					case KeyEvent.VK_D:
						hero1.setSpeedX(1);
						break;
					case KeyEvent.VK_UP:
						hero2.setSpeedY(-1);
						break;
					case KeyEvent.VK_LEFT:
						hero2.setSpeedX(-1);
						break;
					case KeyEvent.VK_DOWN:
						hero2.setSpeedY(1);
						break;
					case KeyEvent.VK_RIGHT:
						hero2.setSpeedX(1);
						break;
					case KeyEvent.VK_R:
						/*回城*/
						hero1.goHome();
						break;
					case KeyEvent.VK_0:
						/*回城*/
						hero2.goHome();
					default:
						break;
				}
			}
		});
		/*实例化线程类*/
		thread = new Thread(new Runnable() {
			@Override
			 public void run() {
				// TODO Auto-generated method stub
				synchronized (modelList){
					while(!destroyed){
						Iterator<IRepeat> li = modelList.iterator();
						while(li.hasNext()){
							li.next().repeat();

						}
						try {

							Thread.sleep(Conf.FPS);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
				}

				}
			}
		});

		thread.start();

	}
	/**
	 * 销毁游戏世界
	 */
	public void destroy(){
		destroyed = true;
	}
	/**
	 * 游戏逻辑
	 */
	@Override
	public void logic() {
		// TODO Auto-generated method stub

	}

	/**
	 * 模型层操作
	 * @param iRepeat
	 */
	/**
	 * 添加模型
	 */
	public void setRepeatable(IRepeat iRepeat) {
		modelList.add(iRepeat);

	}
	/**
	 * 删除模型
	 * @param iRepeat
	 */
	public void removeRepeatable(IRepeat iRepeat){
		Iterator<IRepeat> it = modelList.iterator();
		while(it.hasNext()){
			IRepeat ir = it.next();
			if(ir == iRepeat)
				it.remove();
		}
	}
	/*
	 * 视图层操作
	 */

	public void add(IModel model){
		gframe.dealWith(model.getView(), GameFrame.ADD_VIEW);
	}

	public void remove(IModel model) {
		gframe.dealWith(model.getView(),GameFrame.REM_VIEW);
	}

	public void invalidate(IModel model) {
		gframe.dealWith(model.getView(), GameFrame.INVALIDATE);
	}
}
