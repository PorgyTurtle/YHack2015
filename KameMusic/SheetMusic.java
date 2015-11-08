package KameMusic;

import javafx.scene.layout.Pane;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import java.util.ArrayList;

/**
*
*/
public class SheetMusic {
	private Pane _sheetPane;
	private ArrayList<NoteLine> _staffs;
	private NoteLine[] _staffLine;
	private NoteSpace[] _staffSpace;
	private double _x;
	private double _y;
	private KeyMaker _keyMaker;

	public SheetMusic() {
		_staffs = new ArrayList<NoteLine>();
		_keyMaker = new KeyMaker();
		
		this.makeSheetPane();
		this.makeStaffs(8);
		this.makeClefs();
		this.makeKeySignature();
		this.displayTimeSignature();

		ClickHandler clickHandler = new ClickHandler();
		_sheetPane.addEventHandler(MouseEvent.MOUSE_CLICKED, clickHandler);
	}
	
	private void makeKeySignature() {
		double x = 0;
		double y = 0;
		Pane keyPane;
		for (int n = 0; n < _staffs.size(); n++) {
			keyPane = _keyMaker.makeAMajor();
			x = _staffs.get(n).getNoteLine().getX();
			y = _staffs.get(n).getNoteLine().getY();
			keyPane.setTranslateX(x + 22);
			keyPane.setTranslateY(y);
			_sheetPane.getChildren().add(keyPane);
		}
	}

	private void makeClefs() {
		Clef clefMaker = new Clef();
		Pane trebleClef;
		double x = 0;
		double y = 0;
		for (int n = 0; n < _staffs.size(); n++) {
			trebleClef = clefMaker.makeTreble();
			x = _staffs.get(n).getNoteLine().getX();
			y = _staffs.get(n).getNoteLine().getY();
			trebleClef.setTranslateX(x);
			trebleClef.setTranslateY(y - Constants.SPACE_HEIGHT);
			_sheetPane.getChildren().add(trebleClef);
		}
	}

	private class ClickHandler implements EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent e) {
			_x = e.getSceneX();
			_y = e.getSceneY();
			try {
				MidiHelper.play(getNote((int)_y));
			} catch (javax.sound.midi.MidiUnavailableException mu) {;}
			
			// System.out.println("x = " + _x);
			// System.out.println("y = " + _y);
			// boolean isInStaffWidth = _x > _staffLine[0].getX()

			//   && _staffLine[0].getY();
			// if

			e.consume();
		}
	}

	public int getNote(int y)
	{
		int z=y;
		return z;
	}
	
	/*
	* This method gets and returns the _sheetPane.
	*/
	public Pane getSheetPane() {
		return _sheetPane;
	}
	
	/*
	* This method initializes and sets up _sheetPane.
	*/
	private void makeSheetPane() {
		_sheetPane = new Pane();
		_sheetPane.setPrefSize(Constants.SHEET_WIDTH, Constants.SHEET_HEIGHT);
		_sheetPane.setStyle("-fx-background-color: white;");
	}

	private void makeStaffs(int numberOfStaffs) {
		
		for(int n = 0; n < numberOfStaffs; n++) {
			this.makeStaffLine(Constants.STAFF_WIDTH,
							   Constants.SHEET_WIDTH/20,
							   Constants.SHEET_HEIGHT/(numberOfStaffs + 1) * n + 40);
			this.makeStaffSpace(Constants.STAFF_WIDTH,
							   	Constants.SHEET_WIDTH/20,
							   	Constants.SHEET_HEIGHT/(numberOfStaffs + 1)
							   		 * n + 40 +	Constants.LINE_HEIGHT);
//			if (n > 0) {
				this.makeBarLines(Constants.SHEET_WIDTH/20,
						  		  Constants.SHEET_HEIGHT/(numberOfStaffs + 1) * 
						  		  n + 40);
//			}
		}
	}

	private void makeStaffLine(double length, double x, double y) {
		_staffLine = new NoteLine[5];
		for (int n = 0; n < _staffLine.length; n++) {
			_staffLine[n] = new NoteLine(length);
			_staffLine[n].setXY(x, y);
			y += Constants.SPACE_HEIGHT + Constants.LINE_HEIGHT;
			_sheetPane.getChildren().addAll(_staffLine[n].getNoteLine());
		}
		_staffs.add(_staffLine[0]);
	}

	private void makeStaffSpace(double length, double x, double y) {
		_staffSpace = new NoteSpace[4];
		for (int n = 0; n < _staffSpace.length; n++) {
			_staffSpace[n] = new NoteSpace(length);
			_staffSpace[n].setXY(x, y);
			y += Constants.LINE_HEIGHT + Constants.SPACE_HEIGHT;
			_sheetPane.getChildren().addAll(_staffSpace[n].getNoteSpace());
		}
	}

	private void makeBarLines(double x, double y) {
		BarLine[] barLine = new BarLine[9];
		for (int n = 0; n < barLine.length; n++) {
			barLine[n] = new BarLine(x, y);
			x += Constants.STAFF_WIDTH / 8.0;
			_sheetPane.getChildren().addAll(barLine[n].getBarLine());
		}
	}
	
	private void displayTimeSignature() {
		TimeSignatureMaker timeSignatureMaker = new TimeSignatureMaker();
		Pane timePane = timeSignatureMaker.makeTimeSignature();
		double x = 105;
		double y = 40;
		timePane.setTranslateX(x);
		timePane.setTranslateY(y);
		_sheetPane.getChildren().add(timePane);
	}
}