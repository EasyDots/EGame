package egame.jpc.world;


import egame.jpc.frame.GameFrame;
import egame.jpc.frame.MainFrame;
import egame.jpc.game.conf.Conf;
import egame.jpc.model.Hero;
import egame.jpc.model.MainCity;
import egame.jpc.model.interfc.IModel;
import egame.jpc.model.interfc.IRepeat;
import egame.jpc.world.input.GameListener;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 游戏世界
 */
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

	public MainCity mainCity1;
	public Hero hero1;

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
	}

	/**
	 * 初始化游戏世界
	 */
	public void init(){
		/*创建游戏视图框架*/
		this.gframe = new GameFrame(mframe);
		/*设置按键事件*/
		mframe.addKeyListener(new GameListener(this).getKeyListener());
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
