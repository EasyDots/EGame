package egame.jpc.frame;


import egame.jpc.view.GView;

import java.util.ArrayList;
import java.util.List;

public class GameFrame {
	public final int BUF_SIZE = 100;
	public static final int ADD_VIEW = 1;
	public static final int REM_VIEW = 2;
	public static final int INVALIDATE = 3;
	public static int i = 0;
	public static int j = 0;
	private MainFrame gFrame;
	private GView[] viewBuf = new GView[BUF_SIZE];
	private int[] doWhat = new int[BUF_SIZE];
	private List<GView> gvs= new ArrayList<GView>();
	private List<Integer> whats= new ArrayList<Integer>();

	public GameFrame(MainFrame mframe) {
		this.gFrame = mframe;
	}

	public void dealWith(GView gView, int forWhat) {
			switch (forWhat) {
				case ADD_VIEW:
					gFrame.add(gView);
					break;
				case REM_VIEW:
						gFrame.remove(gView);
					break;
				case INVALIDATE:
						gView.repaint();
					break;
			}

//		viewBuf[i % BUF_SIZE] = gView;
//		doWhat[i % BUF_SIZE] = forWhat;
//		i++;
//
//		while (j < i) {
//			switch (doWhat[j % BUF_SIZE]) {
//			case ADD_VIEW:
//				if (viewBuf[j % BUF_SIZE] != null)
//					gFrame.add(viewBuf[j % BUF_SIZE]);
//				break;
//			case REM_VIEW:
//				if (viewBuf[j % BUF_SIZE] != null){
//					gFrame.remove(viewBuf[j % BUF_SIZE]);
//
//					System.out.println("remove ok");
//				}
//
//				break;
//			case INVALIDATE:
//				if (viewBuf[j % BUF_SIZE] != null)
//					viewBuf[j % BUF_SIZE].repaint();
//				break;
//			}
//			j++;
//		}

	}

}
