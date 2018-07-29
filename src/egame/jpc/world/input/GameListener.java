package egame.jpc.world.input;

import egame.jpc.world.World;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 游戏输入监听
 */
public class GameListener {
    private World world;

    /*方向枚举*/
    public enum Direction {
        UP,
        LEFT,
        DOWN,
        RIGHT
    }
    public KeyListener getKeyListener() {
        return keyListener;
    }

    public void setKeyListener(KeyListener keyListener) {
        this.keyListener = keyListener;
    }
    private KeyListener keyListener;
    public GameListener(World world) {
        this.world = world;
        init();
    }
    public void init() {
        keyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_W:
                        world.hero1.move(Direction.UP);
                        break;
                    case KeyEvent.VK_A:
                        world.hero1.move(Direction.LEFT);
                        break;
                    case KeyEvent.VK_S:
                        world.hero1.move(Direction.DOWN);
                        break;
                    case KeyEvent.VK_D:
                        world.hero1.move(Direction.RIGHT);
                        break;

                    /*按U演示经验圈增加*/
                    case KeyEvent.VK_U:
                        world.hero1.upgrade();
                        break;
                        /*按1演示使用血瓶*/
                    case KeyEvent.VK_1:
                        world.hero1.useTreatment();
                        break;
                        /*按J普通攻击*/
                    case KeyEvent.VK_J:

                        break;
                    default:
                        break;
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_W:
                        world.hero1.idle(Direction.UP);
                        break;
                    case KeyEvent.VK_A:
                        world.hero1.idle(Direction.LEFT);
                        break;
                    case KeyEvent.VK_S:
                        world.hero1.idle(Direction.DOWN);
                        break;
                    case KeyEvent.VK_D:
                        world.hero1.idle(Direction.RIGHT);
                        break;
                    case KeyEvent.VK_R:
                        /*回城*/
                        world.hero1.goHome();
                        break;

                    default:
                        break;
                }
            }
        };
    }
}
