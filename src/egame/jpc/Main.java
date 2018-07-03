package egame.jpc;

import egame.jpc.frame.MainFrame;
import egame.jpc.world.World;

public class Main {
	private static World world;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			world = new World(new MainFrame());
			world.init();
			world.createPlayer();
			
	}

}
