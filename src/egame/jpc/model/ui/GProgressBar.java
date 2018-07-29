package egame.jpc.model.ui;


import egame.jpc.model.Model;
import egame.jpc.model.interfc.IRepeat;
import egame.jpc.view.GView;
import egame.jpc.view.ui.GProgressBarView;
import egame.jpc.world.World;

/**
 * 进度条
 * @author EasyDots
 *
 */
public class GProgressBar extends Model implements IRepeat {
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getCur() {
		return cur;
	}
	public void setCur(int cur) {
		this.cur = cur;
	}
	public int getDelta() {
		return delta;
	}
	public void setDelta(int delta) {
		this.delta = delta;
	}

	protected int start = 0;
	protected int end = 100;
	protected int cur = 0;
	protected int delta = 1;
	/*显示时间 单位秒*/
	public float showTime = 1;

	public boolean isVisibility() {
		return visibility;
	}
	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}

	protected boolean visibility = true;
	public GProgressBar(World world) {
		super(world);
	}
	@Override
	public void init() {
		super.init();
		this.tag = "进度条";
		world.setRepeatable(this);
		world.getMframe().revalidate();
	}
	@Override
	public void createView() {
		this.gview = new GProgressBarView(this);
	}

	@Override
	public GView getView() {
		return this.gview;
	}

	/**
	 * 进度条进度显示
	 */
	public void doProcess(){
		setVisibility(true);
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					for(cur = start; cur < end; cur++){
						for(int i = 0; i < showTime*10; i++){
							Thread.sleep(1);
						}
					}

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				setVisibility(false);
			}
		}).start();
	}


	@Override
	public void destroy() {
		super.destroy();
		world.remove(this);
		world.removeRepeatable(this);
	}

	@Override
	public void repeat() {

	}
}
