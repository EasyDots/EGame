package egame.jpc.world.common;

/**
 * @Auther: EasyDots
 * @Date: 2018/7/29 0029 15:20
 * @Description: 基于MKS单元和不同整数最大值的全局调谐常数,翻译自jbox2d.common中Settings
 * @Url: www.ncgds.cn
 */
public class Settings {
    /** 使用“接近零”浮点ε值 */
    public static final float EPSILON = 1.1920928955078125E-7f;

    /** 圆周率. */
    public static final float pi = (float) Math.PI;

    //在这里定义你的单位系统。默认系统是米米秒。为了使调谐工作正常，
    ///你的动态物体应该比卵石更小,比一所房子小。
    ///使用这些设置已被禁止-它们甚至不已经存在于引擎的C++版本中，
    //以及将来的支持,不太可能。
    public static final float lengthUnitsPerMeter = 1.0f;
    public static final float massUnitsPerKilogram = 1.0f;
    public static final float timeUnitsPerSecond = 1.0f;

    // 碰撞
    public static final int maxManifoldPoints = 2;
    public static final int maxShapesPerBody = 64;
    public static final int maxPolygonVertices = 8;

    /** 必须是2的乘幂. */
    public static final int maxProxies = 2048;
    /** 必须是2的乘幂. */
    public static final int maxPairs = 8 * maxProxies;

    // 力学

    /**
     * 用作碰撞和约束公差的小长度。通常，它被认为是有意义的，但视觉上微不足道。
     */
    public static final float linearSlop = 0.005f * lengthUnitsPerMeter; // 0.5 cm

    /**
     * 一个小角度，用作碰撞和约束公差。通常，它被认为是有意义的，但在视觉上是微不足道的。
     */
    public static final float angularSlop = 2.0f / 180.0f * pi; // 2 degrees

    /**
     * 弹性碰撞的速度阈值。任何低于此阈值的相对线性速度的碰撞都将被视为非弹性的。
     */
    public static final float velocityThreshold = 1.0f * lengthUnitsPerMeter
            / timeUnitsPerSecond; // 1 m/s

    /**
     * 在求解约束时使用的最大线性位置校正。这有助于防止超量。
     */
    public static final float maxLinearCorrection = 0.2f * lengthUnitsPerMeter; // 20 cm

    /**
     * 求解约束时的最大角位置校正. 这有助于防止超量
     */
    public static final float maxAngularCorrection = 8.0f / 180.0f * pi; // 8 degrees

    /**
     * 这个比例因子控制重叠的快速解决。理想情况下，
     * 这将是1，从而在一个时间步长中消除重叠。然而，
     * 使用接近1的值往往会导致过冲。
     */
    public static final float contactBaumgarte = 0.2f;

    /** 刚体在睡觉前必须保持静止的时间. */
    public static final float timeToSleep = 0.5f * timeUnitsPerSecond; // half a second

    /** 如果刚体的线速度超过这个公差，刚体就不能休眠。. */
    public static final float linearSleepTolerance = 0.01f
            * lengthUnitsPerMeter / timeUnitsPerSecond; // 1 cm/s

    /** 如果刚体的角速度超过这个公差,刚体不能休眠. */
    public static final float angularSleepTolerance = 2.0f / 180.0f / timeUnitsPerSecond;

    /**
     * 连续碰撞检测（CCD）与核心、收缩的形状一起工作。
     * 这是形状被自动收缩以与CCD一起工作的量。这必须比b2_linearSlop大。
     */
    public static final float toiSlop = 8.0f * linearSlop;

    /**
     * 物体的最大线速度。这个限制是非常大的并且被用来防止数值问题。你不需要调整这个。
     */
    public static final float maxLinearVelocity = 200.0f;
    public static final float maxLinearVelocitySquared = maxLinearVelocity * maxLinearVelocity;

    /**
     *物体的最大角速度。这个限制是非常大的并且被用来防止数值问题。你不需要调整这个。
     */
    public static final float maxAngularVelocity = 250.0f;
    public static final float maxAngularVelocitySquared = maxAngularVelocity * maxAngularVelocity;

    /** 要妥善解决TOI接触的最大数量. */
    public static int maxTOIContactsPerIsland = 32;
}
