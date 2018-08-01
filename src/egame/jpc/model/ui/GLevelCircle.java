package egame.jpc.model.ui;

import egame.jpc.model.Model;
import egame.jpc.model.interfc.IRepeat;
import egame.jpc.view.GView;
import egame.jpc.view.ui.GLevelCircleView;
import egame.jpc.world.World;
import egame.jpc.world.common.Vector2;
import egame.jpc.world.graphics.Texture;

import java.awt.*;
import java.util.ArrayList;

/**
 * 经验值圈
 */
public class GLevelCircle extends Model implements IRepeat {
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
    /*等级文字颜色*/
    protected Color levelTextColor = Color.WHITE;
    /*外圈颜色*/
    protected Color outsideColor = Color.BLACK;
    /*内圈颜色*/
    protected Color insideColor = Color.BLACK;
    /*经验条颜色*/
    protected Color expBarColor = Color.YELLOW;
    /*外圈半径*/
    protected int outsideR = 26;
    /*内圈半径缩放*/
    protected float insideRScale = 0.6f;
    /*经验条半径缩放*/
    protected float expRScale = 0.8f;
    protected int minLevel = 1;
    protected int level = 1;
    protected int maxLevel = 10;
    public ArrayList<Image> levelNumImgs;
    public GLevelCircle(World world) {
        super(world);
        levelNumImgs = new ArrayList<Image>();
    }
    public GLevelCircle(World world, int x, int y, int cur, int level , boolean visibility){
        this(world);
        this.position.set(x,y);
        this.cur = cur;
        this.level = level;
        this.visibility = visibility;
        try {
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 5; j++) {
                        Image image = Texture.getClipImg("res/num_120_46.png",24*j,23*i,24,23);
                        levelNumImgs.add(image);
                    }
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public GLevelCircle(World world, Vector2 position, int cur, int level , boolean visibility){
        this(world);
        this.position.set(position);
        this.cur = cur;
        this.level = level;
        this.visibility = visibility;
        try {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 5; j++) {
                    Image image = Texture.getClipImg("res/num_120_46.png",24*j,23*i,24,23);
                    levelNumImgs.add(image);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void createView() {
        this.gview = new GLevelCircleView(this);
    }

    @Override
    public void init() {
        super.init();
        this.tag = "经验圈";
        world.add(this);
        world.setRepeatable(this);
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
                    e.printStackTrace();
                }
                //setVisibility(false);
            }
        }).start();
    }

    public void setFollow(Model model) {
        setPosition(model.getX()-20, model.getY() - 30);
    }

    @Override
    public void repeat() {
        world.invalidate(this);
        world.getMframe().revalidate();
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

    public Color getExpBarColor() {
        return expBarColor;
    }

    public void setExpBarColor(Color expBarColor) {
        this.expBarColor = expBarColor;
    }

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

    public int getOutsideR() {
        return outsideR;
    }

    public void setOutsideR(int outsideR) {
        this.outsideR = outsideR;
    }
    public float getExpRScale() {
        return expRScale;
    }

    public void setExpRScale(float expRScale) {
        this.expRScale = expRScale;
    }
}
