package KameMusic;

import javafx.scene.shape.Rectangle;

/**
*
*/
public class NoteLine {
	private Rectangle _noteLine;

	/*
	*
	*/
	public NoteLine(double length) {
		_noteLine = new Rectangle(length, Constants.LINE_HEIGHT);

	}
	
	/*
	* This method gets and returns the line.
	*/
	public Rectangle getNoteLine() {
		return _noteLine;
	}

	public void setXY(double x, double y) {
		_noteLine.setX(x);
		_noteLine.setY(y);
	}

	public double getX() {
		return _noteLine.getX();
	}

	public double getY() {
		return _noteLine.getY();
	}
}