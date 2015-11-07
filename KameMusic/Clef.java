package KameMusic;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Clef {

	public Clef() {
	}

	public Pane makeTreble() {
		Image image = new Image("http://imageshack.com/a/img905/5120/kgd0Fl.png", 18, 60, false, false);
		ImageView iv = new ImageView();
		iv.setImage(image);
		Pane treblePane = new Pane();
		treblePane.getChildren().add(iv);
		return treblePane;
	}
}