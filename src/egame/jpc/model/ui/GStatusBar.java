package egame.jpc.model.ui;


import egame.jpc.model.Model;
import egame.jpc.model.Point;
import egame.jpc.model.interfc.IModel;
import egame.jpc.model.interfc.IRepeat;
import egame.jpc.view.GView;
import egame.jpc.view.ui.GStatusBarView;
import egame.jpc.world.World;

/**
 * 状态条
 *
 * @author Administrator
 */
public class GStatusBar extends Model implements IModel, IRepeat {
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


    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    protected boolean visibility = true;

    public GStatusBar(World world) {
        super(world);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() {
        // TODO Auto-generated method stub
        super.init();
        this.tag = "状态条";
        world.setRepeatable(this);
        world.getMframe().revalidate();
    }

    @Override
    public void createView() {
        // TODO Auto-generated method stub
        this.gview = new GStatusBarView(this);
    }

    @Override
    public void destroy() {
        super.destroy();
        world.remove(this);
        world.removeRepeatable(this);
    }

    @Override
    public GView getView() {
        // TODO Auto-generated method stub
        return this.gview;
    }

    /**
     * 显示测试
     */
    public void doProcess() {
        setVisibility(true);
        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    for (cur = start; cur < end; cur++) {
                        for (int i = 0; i < 10; i++) {
                            Thread.sleep(1);
                        }
                    }

                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                setVisibility(false);
            }
        }).start();
    }

    @Override
    public void repeat() {
        world.invalidate(this);
        world.getMframe().revalidate();
    }

    public void setFollow(Point point) {
        setPoint(new Point(point.x - 20, point.y - 30));
    }
}