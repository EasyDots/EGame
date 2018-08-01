package egame.jpc.world.common;

/**
 * @Auther: EasyDots
 * @Date: 2018/7/29 0029 15:12
 * @Description:
 * @Url: www.ncgds.cn
 */
/**
 * A 2-dimensional vector class.  Used heavily in JBox2d.
 */
public class Vector2 {
    public float x, y;
    public Vector2() {
        this(0, 0);
    }
    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }
    /** 向量归零 */
    public void setZero() {
        x = 0.0f;
        y = 0.0f;
    }

    /** 设置向量. */
    public void set(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /** 用另一个向量创建 */
    public void set(Vector2 v) {
        this.x = v.x;
        this.y = v.y;
    }

    /** Return the sum of this vector and another; does not alter either one. */
    public Vector2 add(Vector2 v) {
        return new Vector2(x + v.x, y + v.y);
    }

    /** Return the difference of this vector and another; does not alter either one. */
    public Vector2 sub(Vector2 v) {
        return new Vector2(x - v.x, y - v.y);
    }

    /** Return this vector multiplied by a scalar; does not alter this vector. */
    public Vector2 mul(float a) {
        return new Vector2(x * a, y * a);
    }

    /** 返回原点对称向量. */
    public Vector2 negate() {
        return new Vector2(-x, -y);
    }

    /** x,y翻转并返回这个向量 */
    public Vector2 negateLocal() {
        x = -x;
        y = -y;
        return this;
    }

    /** 将另一个向量添加到这个向量并返回结果-改变这个向量. */
    public Vector2 addLocal(Vector2 v) {
        x += v.x;
        y += v.y;
        return this;
    }

    /** 从这一个向量中减去另一个向量，并返回结果-改变这个向量。 */
    public Vector2 subLocal(Vector2 v) {
        x -= v.x;
        y -= v.y;
        return this;
    }

    /** 将这个向量乘以一个数和返回结果-改变这个向量. */
    public Vector2 mulLocal(float a) {
        x *= a;
        y *= a;
        return this;
    }

    /** 返回这个向量的长度. */
    public float length() {
        return (float) Math.sqrt(x * x + y * y);
    }

    /** 返回向量的平方长度. */
    public float lengthSquared() {
        return (x*x + y*y);
    }

    /** 规范化该向量并在归一化之前返回长度。改变向量. */
    public float normalize() {
        float length = length();
        if (length < Settings.EPSILON) {
            return 0f;
        }

        float invLength = 1.0f / length;
        x *= invLength;
        y *= invLength;
        return length;
    }

    /** 向量表示一对有效的、非无限的浮点数 */
    public boolean isValid() {
        return x != Float.NaN && x != Float.NEGATIVE_INFINITY
                && x != Float.POSITIVE_INFINITY && y != Float.NaN
                && y != Float.NEGATIVE_INFINITY && y != Float.POSITIVE_INFINITY;
    }

    /** 返回正值向量 */
    public Vector2 abs() {
        return new Vector2(Math.abs(x), Math.abs(y));
    }

    @Override
    /** 放回该向量的拷贝. */
    public Vector2 clone() {
        return new Vector2(x, y);
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    /*
     * Static
     */

    public static Vector2 abs(Vector2 a) {
        return new Vector2(Math.abs(a.x), Math.abs(a.y));
    }

    public static float dot(Vector2 a, Vector2 b) {
        return a.x * b.x + a.y * b.y;
    }

    public static float cross(Vector2 a, Vector2 b) {
        return a.x * b.y - a.y * b.x;
    }

    public static Vector2 cross(Vector2 a, float s) {
        return new Vector2(s * a.y, -s * a.x);
    }

    public static Vector2 cross(float s, Vector2 a) {
        return new Vector2(-s * a.y, s * a.x);
    }

    public static Vector2 min(Vector2 a, Vector2 b) {
        return new Vector2(a.x < b.x ? a.x : b.x, a.y < b.y ? a.y : b.y);
    }

    public static Vector2 max(Vector2 a, Vector2 b) {
        return new Vector2(a.x > b.x ? a.x : b.x, a.y > b.y ? a.y : b.y);
    }
}