package egame.jpc.model.ui;

import egame.jpc.model.Model;
import egame.jpc.model.interfc.IRepeat;
import egame.jpc.view.GView;
import egame.jpc.view.ui.GLevelCircleView;
import egame.jpc.world.World;

import java.awt.*;

/**
 * 经验值圈
 */
public class GLevelCircle extends Model implements IRepeat {

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

    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    /*开始位置*/
    protected int start = 0;
    /*结束位置*/
    protected int end = 100;
    /*当前位置*/
    protected int cur = 0;
    /*每单位时间变化的值*/
    protected int delta = 1;
    /*经验圈默认可见*/
    protected boolean visibility = true;

    public Color getLevelTextColor() {
        return levelTextColor;
    }

    public void setLevelTextColor(Color levelTextColor) {
        this.levelTextColor = levelTextColor;
    }

    public Color getOutsideColor() {
        return outsideColor;
    }

    public void setOutsideColor(Color outsideColor) {
        this.outsideColor = outsideColor;
    }

    public Color getInsideColor() {
        return insideColor;
    }

    public void setInsideColor(Color insideColor) {
        this.insideColor = insideColor;
    }

    public float getInsideRScale() {
        return insideRScale;
    }

    public void setInsideRScale(float insideRScale) {
        this.insideRScale = insideRScale;
    }

    /*等级文字颜色*/
    protected Color levelTextColor = Color.WHITE;

    /*外圈颜色*/
    protected Color outsideColor = Color.BLACK;
    /*内圈颜色*/
    protected Color insideColor = Color.BLACK;
    /*经验条颜色*/
    protected Color expBarColor = Color.YELLOW;

    public Color getExpBarColor() {
        return expBarColor;
    }

    public void setExpBarColor(Color expBarColor) {
        this.expBarColor = expBarColor;
    }

    /*外圈半径*/
    protected int outsideR = 40;

    public int getOutsideR() {
        return outsideR;
    }

    public void setOutsideR(int outsideR) {
        this.outsideR = outsideR;
    }

    /*内圈半径缩放*/
    protected float insideRScale = 0.6f;

    public float getExpRScale() {
        return expRScale;
    }

    public void setExpRScale(float expRScale) {
        this.expRScale = expRScale;
    }

    /*经验条半径缩放*/
    protected float expRScale = 0.8f;

    public int getMinLevel() {
        return minLevel;
    }

    public void setMinLevel(int minLevel) {
        this.minLevel = minLevel;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }

    protected int minLevel = 1;
    protected int level = 1;
    protected int maxLevel = 10;

    public GLevelCircle(World world) {
        super(world);
    }

    @Override
    public void createView() {
        this.gview = new GLevelCircleView(this);
    }

    @Override
    public void init() {
        super.init();
        this.setVet2(this.getVet2().x-40, this.getVet2().y-50);
        this.tag = "经验圈";
        this.cur = 0;
        this.level = 1;
        this.setVisibility(true);
        world.setRepeatable(this);
        world.getMframe().revalidate();
    }

    @Override
    public GView getView() {
        return this.gview;
    }

    /**
     * 经验增加
     *
     * @param exp 经验值
     */
    public void addExp(int exp) {
        /*每10ms加1经验*/
        /*当前的经验值满*/
        if (level < maxLevel) {
            cur += exp;
            if (cur >= end) {
                level++;
                cur = start;
                if (level >= 10)
                    cur = end;
            }
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        world.remove(this);
        world.removeRepeatable(this);
    }

    /**
     * 经验圈自增测试
     */
    public void doProcess() {
        init();
        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    /*每10ms加1经验*/
                    for (cur = start; level < maxLevel; cur++) {
                        Thread.sleep(10);
                        /*当前的经验值满*/
                        if (cur == end) {
                            level++;
                            cur = start;
                            if (level == 10)
                                cur = end;
                        }

                    }

                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                //setVisibility(false);
            }
        }).start();
    }

    public void setFollow(Model model) {
        setVet2(model.getVet2().x-20, model.getVet2().y - 30);
    }

    @Override
    public void repeat() {

    }
}
