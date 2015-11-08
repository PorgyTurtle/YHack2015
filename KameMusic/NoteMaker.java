package KameMusic;

import javafx.scene.shape.Ellipse;
import javafx.scene.paint.Color;

/**
*
*/
public class NoteMaker {

	public NoteMaker() {
	}
	
	public Ellipse makeQuarterNote(int x, int y) {
		Ellipse quarterNote = new Ellipse(x, y, 10, 10);
		quarterNote.setFill(Color.BLUE);
		return quarterNote;
	}
}