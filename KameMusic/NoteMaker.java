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
		Note newNote= new Note(SheetMusic.getPos(x, y), SheetMusic.getNote(int y), 32, 100);
		SheetMusic.notes.add(newNote);
		wholeNote.setFill(Color.BLUE);
		return wholeNote;
	}

}