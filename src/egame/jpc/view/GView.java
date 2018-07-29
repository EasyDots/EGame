package egame.jpc.view;


import egame.jpc.model.Model;

import javax.swing.*;

/**
 * 抽象游戏视图类
 * @author EasyDots
 */
public class GView extends JPanel{
	private Model model;
	public GView(Model model){
		this.model = model;
		/*设置背景无颜色*/
		setBackground(null);
		/*设置背景透明*/
		setOpaque(false);
	}
	public Model getModel(){
		return model;
	}

}