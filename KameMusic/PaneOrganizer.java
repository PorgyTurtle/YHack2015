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
import java.util.*;
import java.io.*;


/**
*
*/
public class PaneOrganizer {
	private BorderPane _root;
	private SheetMusic _sheetMusic;
	private double _x;
	private double _y;
	private Timeline _timeline;
	public static boolean[] notesisPlaying;
	public boolean isPlaying;
	double timer;
	public PriorityQueue<Note> arePlaying;
	public PriorityQueue<Note> willBePlayed;

	public PaneOrganizer() {
		arePlaying=new PriorityQueue<Note>();
		isPlaying=false;
		notesisPlaying= new boolean[1024];
		for(int i=0; i<PaneOrganizer.notesisPlaying.length; i++)
			{notesisPlaying[i]=false;}
		try {MidiHelper.start();}
		catch (javax.sound.midi.MidiUnavailableException mu) {;}
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

	public void getToPos(int sTime)
	{
		timer=sTime;
		arePlaying=new PriorityQueue<Note>();
		willBePlayed=new PriorityQueue<Note>();
		Note.compMode(true);
		for(Note n : SheetMusic.notes)
		{
			if(n.time<=sTime) willBePlayed.add(n);
		}
	}

	public void playMusic()
	{
		isPlaying=true;
	}

	public void stopMusic()
	{
		isPlaying=false;
		MidiHelper.synth.getChannels()[0].allNotesOff();
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
			
			if(isPlaying)
			{
				Note.compMode(true);
				Note n=willBePlayed.peek();
				while(n.time<=timer)
				{
					willBePlayed.remove();
					try {
						MidiHelper.play(n.note);
					} 	catch (javax.sound.midi.MidiUnavailableException mu) {;}
					Note.compMode(false);
					arePlaying.add(n);

					Note.compMode(true);
					n=willBePlayed.peek();
				}

				Note.compMode(false);
				Note m=arePlaying.peek();
				while(m.time+m.length<=timer)
				{
					m=arePlaying.remove();
					try {
						MidiHelper.stop(m.note);
					} 	catch (javax.sound.midi.MidiUnavailableException mu) {;}
					m=arePlaying.peek();
				}
			}

			if(false){_timeline.stop();}
			
		}
	}
	
	/*
	* This method sets up the Keyframe and Timeline.
	*/
	private void setUpTimeline() {
		System.out.println("bbb");
		KeyFrame kf = new KeyFrame(Duration.millis(Constants.DURATION), new TimeHandler());
		_timeline = new Timeline(kf);
		_timeline.setCycleCount(Animation.INDEFINITE);
	}
}