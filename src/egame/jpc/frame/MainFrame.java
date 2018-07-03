package egame.jpc.frame;

import javax.swing.*;
import java.awt.*;

/**
 * 游戏主框架
 * @author Administrator
 *
 */
public class MainFrame extends JFrame{

	public MainFrame() throws HeadlessException {
		super();
		// TODO Auto-generated constructor stub
		setAlwaysOnTop(true);
		setBounds(300, 100, 800, 600);
		setVisible(true);
		setTitle("Java游戏引擎");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}


}
