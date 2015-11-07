package KameMusic;

import javafx.scene.shape.Rectangle;

/**
*
*/
public class BarLine {
	private Rectangle _barLine;

	public BarLine(double x, double y) {
		double barHeight = Constants.LINE_HEIGHT * 5 +
						   Constants.SPACE_HEIGHT * 4;
		_barLine = new Rectangle(Constants.BAR_WIDTH, barHeight);
		this.setXY(x, y);
	}
	
	public Rectangle getBarLine() {
		return _barLine;
	}

	private void setXY(double x, double y) {
		_barLine.setX(x);
		_barLine.setY(y);
	}
}