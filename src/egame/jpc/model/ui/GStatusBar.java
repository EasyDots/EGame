package egame.jpc.model.ui;

import egame.jpc.model.Model;
import egame.jpc.model.interfc.IModel;
import egame.jpc.model.interfc.IRepeat;
import egame.jpc.view.GView;
import egame.jpc.view.ui.GStatusBarView;
import egame.jpc.world.World;
import egame.jpc.world.common.Vector2;

import java.awt.*;

/**
 * 状态条
 * @author EasyDots
 */
public class GStatusBar extends Model implements IModel, IRepeat {
    protected int start = 0;
    protected int end = 100;
    protected int cur = 0;
    protected int delta = 1;
    protected boolean visibility = true;

    public GStatusBar(World world) {
        super(world);
    }

    public GStatusBar(World world, int cur , Color color, boolean visibility){
        this(world);
        this.cur = cur;
        this.color = color;
        this.visibility = visibility;
    }
    @Override
    public void init() {
        super.init();
        this.tag = "状态条";
        world.add(this);
        world.setRepeatable(this);
    }

    @Override
    public void createView() {
        this.gview = new GStatusBarView(this);
    }

    @Override
    public void destroy() {

        world.remove(this);
        world.removeRepeatable(this);
    }

    @Override
    public GView getView() {
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
                try {
                    for (cur = start; cur < end; cur++) {
                        for (int i = 0; i < 10; i++) {
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
    public void repeat() {
        world.invalidate(this);
        world.getMframe().revalidate();
    }
    public void setFollow(Vector2 vector2) {
        setPosition(vector2.x - 20, vector2.y - 30);
    }
    public void setFollow(float x, float y) {
        setPosition(x - 20, y - 30);
    }

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
        if(cur > 100 || cur < 0)return;
        this.cur = cur;
    }

    public int getDelta() {
        return delta;
    }

    public void setDelta(int delta) {
        this.delta = delta;
    }
    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

}
