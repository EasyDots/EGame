package egame.jpc.model;

/**
 * 点类，位置类
 */
public class Point {
    public int x;
    public int y;

    public Point() {

    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point point) {
        if (point != null) {
            this.x = point.x;
            this.y = point.y;
        }
    }
}
