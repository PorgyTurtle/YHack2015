package KameMusic;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

/**
  * 
  *
  * @author Kimberly Le
  *
  */

public class App extends Application {

  public static PaneOrganizer organizer;
    @Override
	public void start(Stage stage) {
		// Create top-level object, set up the scene, and show the stage here.
    	stage.setTitle("KameMusic");
    	organizer = new PaneOrganizer();
    	Scene scene = new Scene(organizer.getRoot());
    	stage.setScene(scene);
    	stage.show();
	}

	/*
	* This is the mainline.
	*/
	public static void main(String[] argv) {
        	// launch is a method inherited from Application
		launch(argv);
	}
}
