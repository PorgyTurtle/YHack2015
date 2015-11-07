package KameMusic;

import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

/**
*
*/
public class NoteSpace {
	private Rectangle _noteSpace;
	private int _noteX;
	private int _noteY;

	/*
	*
	*/
	public NoteSpace(double length) {
		_noteSpace = new Rectangle(length, Constants.SPACE_HEIGHT);
		_noteSpace.setFill(Color.WHITE);
	}
	
	/*
	* This method gets and returns the line.
	*/
	public Rectangle getNoteSpace() {
		return _noteSpace;
	}

	public void setXY(double x, double y) {
		_noteSpace.setX(x);
		_noteSpace.setY(y);
	}
}