package egame.jpc.view;
import egame.jpc.model.Cell;
import egame.jpc.model.Model;

import java.awt.*;
public class CellView extends GView {
	private Cell cell;
	public CellView(Model model) {
		super(model);
		this.cell = (Cell) model;
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.RED);
		g.drawArc(this.cell.getX(), this.cell.getY(), this.cell.getR(), this.cell.getR(), 0, 360);
		//g.drawString(this.cell.getTag(), this.cell.getX(), this.cell.getY());
	}
}
