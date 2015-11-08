package KameMusic;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


/**
*
*/
public class PaneOrganizer {
	private BorderPane _root;
	private SheetMusic _sheetMusic;
	private double _x;
	private double _y;
	private Timeline _timeline;
	public static boolean[] notesPressed;

	public PaneOrganizer() {
		_root = new BorderPane();
		_sheetMusic = new SheetMusic();
		_root.setCenter(_sheetMusic.getSheetPane());
		this.setUpTimeline();
		_timeline.play();
	}

	/*
	* This method gets and returns the root node.
	*/
	public BorderPane getRoot() {
		return _root;
	}
	
	
	/*
	* This class operates the game at the end of each Duration.
	*/
	private class TimeHandler implements EventHandler<ActionEvent> {
		
		/*
		* This method manages the Game.
		*/
		@Override
		public void handle(ActionEvent event) {
			System.out.println("aaa");
			for(int i=0; i<PaneOrganizer.notesPressed.length; i++)
			{
				if(PaneOrganizer.notesPressed[i])
				{	try {
						MidiHelper.play(i);
					} 	catch (javax.sound.midi.MidiUnavailableException mu) {;}
					PaneOrganizer.notesPressed[i]=false;
				} else {
					try {
						MidiHelper.stop(i);
					} 	catch (javax.sound.midi.MidiUnavailableException mu) {;}
				}
			}
			
		}
	}
	
	/*
	* This method sets up the Keyframe and Timeline.
	*/
	private void setUpTimeline() {
		KeyFrame kf = new KeyFrame(Duration.millis(Constants.DURATION), new TimeHandler());
		_timeline = new Timeline(kf);
		_timeline.setCycleCount(1);
	}
}