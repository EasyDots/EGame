package egame.jpc.model;

import egame.jpc.world.common.Vector2;

/**
 *
 */
public class Tools {

    public static boolean circleCollision(float x1, float y1, float r1, float x2, float y2, float r2) {
        if ((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) < (r1 + r2) * (r1 + r2))
            return true;
        return false;
    }

    /**
     * 圆形碰撞
     * @param circlePos1 圆1位置
     * @param r1 圆1半径
     * @param circlePos2 圆2位置
     * @param r2 圆2半径
     * @return 碰撞返回true,没碰撞返回false
     */
    public static boolean circleAndCircleCollision(Vector2 circlePos1,float r1, Vector2 circlePos2, float r2){
        if(distance(circlePos1,circlePos2) < r1+r2){
            return true;
        }
        return false;
    }

    /**
     *
     * @param pos1 点的位置一
     * @param pos2 点的位置二
     * @return 点与点的距离
     */
    public static double distance(Vector2 pos1, Vector2 pos2){
        return Math.sqrt(Math.pow(pos1.x - pos2.x,2) + Math.pow(pos1.y - pos2.y,2));
    }
}
