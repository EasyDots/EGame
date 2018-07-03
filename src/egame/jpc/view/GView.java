package egame.jpc.view;


import egame.jpc.model.Model;

import javax.swing.*;
/**
 * 抽象游戏视图类
 * @author Administrator
 *
 */
public class GView extends JPanel{
	private Model model;
	public GView(Model model){
		this.model = model;
		/*设置背景透明*/
		setBackground(null);
		setOpaque(false);
	}

	public Model getModel(){
		return model;
	}


}