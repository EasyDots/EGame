package egame.jpc;

import egame.jpc.frame.MainFrame;
import egame.jpc.world.World;

public class Main {
	private static World world;

	public static void main(String[] args) {
			world = new World(new MainFrame());
			world.init();
			world.createPlayer();
//		try {
//			for (int i = 0; i < 2; i++) {
//				for (int j = 0; j < 5; j++) {
//					boolean isok = Texture.cropImage(new FileInputStream("res/num.png"),52*j,50*i,52,50,"png",new File("res/test"+i+""+j+".png"));
//					System.out.println(isok);
//				}
//			}
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

}
