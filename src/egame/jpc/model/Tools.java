package egame.jpc.model;

public class Tools {

    public static boolean circleCollision(float x1, float y1, float r1, float x2, float y2, float r2) {
        if ((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) < (r1 - r2) * (r1 - r2))
            return true;
        return false;
    }
}
