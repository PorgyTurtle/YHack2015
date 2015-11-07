package KameMusic;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
*
*/
public class PaneOrganizer {
	private BorderPane _root;
	private SheetMusic _sheetMusic;
	private double _x;
	private double _y;

	public PaneOrganizer() {
		_root = new BorderPane();
		_sheetMusic = new SheetMusic();
		_root.setCenter(_sheetMusic.getSheetPane());
	}

	/*
	* This method gets and returns the root node.
	*/
	public BorderPane getRoot() {
		return _root;
	}
}