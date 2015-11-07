package KameMusic;

import javafx.scene.shape.Ellipse;
import javafx.scene.paint.Color;

/**
*
*/
public class NoteMaker {

	public NoteMaker() {
	}
	
	public Ellipse makeWholeNote(int x, int y) {
		Ellipse wholeNote = new Ellipse(x, y, 10, 10);
		wholeNote.setFill(Color.BLUE);
		return wholeNote;
	}
}