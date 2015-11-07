package KameMusic;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Clef {

	public Clef() {
	}

	public ImageView makeTreble() {
		Image image = new Image("TrebleClef.png");
		ImageView iv1 = new ImageView();
		iv1.setImage(image);
		return iv1;
	}
}