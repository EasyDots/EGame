package egame.jpc.model;

import egame.jpc.model.interfc.ICollision;
import egame.jpc.model.interfc.IRepeat;
import egame.jpc.model.ui.GStatusBar;
import egame.jpc.view.GView;
import egame.jpc.view.TowerView;
import egame.jpc.world.World;
import egame.jpc.world.common.Vector2;

import java.awt.*;

/**
 * @Auther: EasyDots
 * @Date: 2018/7/29 0029 18:15
 * @Description: 防御塔
 * @Url: www.ncgds.cn
 */
public class Tower extends Model implements IRepeat,ICollision {
    /*防御塔攻击范围*/
    protected int attackRangeRadius;
    /*防御塔攻击速率,多少秒攻击1次*/
    protected float attackRate = 1F;
    /*防御塔攻击伤害*/
    protected int damage;
    /*防御塔等级*/
    protected int level;
    /*防御塔HP*/
    public GStatusBar gStatusBarHp;
    /*敌人*/
    public Hero hero;
    public Tower(World world) {
        super(world);
    }

    public Tower(World world, int x, int y, int attackRangeRadius, Hero hero){
        this(world);
        this.setPosition(x,y);
        this.attackRangeRadius = attackRangeRadius;
        this.hero = hero;

    }
    public Tower(World world, Vector2 position, int attackRangeRadius){
        this(world);
        this.setPosition(position);
        this.attackRangeRadius = attackRangeRadius;
    }

    @Override
    public void init() {
        super.init();
        this.tag = "防御塔";
        this.color = Color.magenta;
        world.add(this);
        world.setRepeatable(this);
    }

    @Override
    public void createView() {
        this.gview = new TowerView(this);
    }

    @Override
    public GView getView() {
        return this.gview;
    }

    @Override
    public void repeat() {
        world.invalidate(this);
        world.getMframe().revalidate();
        onCollision();
    }

    @Override
    public void destroy() {
        world.remove(this);
        world.removeRepeatable(this);
    }

    public int getAttackRangeRadius() {
        return attackRangeRadius;
    }

    public void setAttackRangeRadius(int attackRangeRadius) {
        this.attackRangeRadius = attackRangeRadius;
    }

    public float getAttackRate() {
        return attackRate;
    }

    public void setAttackRate(float attackRate) {
        this.attackRate = attackRate;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public void onCollision() {

        if(Tools.circleAndCircleCollision(new Vector2(this.getX()+this.getAttackRangeRadius(),this.getY()+this.attackRangeRadius),this.getAttackRangeRadius(),new Vector2(this.hero.getX()+this.hero.getR(),this.hero.getY()+this.hero.getR()),this.hero.getR())){
            System.out.println("attacked");
        }
    }
}
