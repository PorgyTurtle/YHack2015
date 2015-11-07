package KameMusic;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
*
*/
public class KeyMaker {

	public KeyMaker() {
	}
	
//	private void makeClefs() {
//		_clefMaker = new Clef();
//		Pane trebleClef;
//		double x = 0;
//		double y = 0;
//		for (int n = 0; n < _staffs.size(); n++) {
//			trebleClef = _clefMaker.makeTreble();
//			x = _staffs.get(n).getNoteLine().getX();
//			y = _staffs.get(n).getNoteLine().getY();
//			trebleClef.setTranslateX(x);
//			trebleClef.setTranslateY(y - Constants.SPACE_HEIGHT);
//			_sheetPane.getChildren().add(trebleClef);
//		}
//	}
	
	private Pane makeFlat() {
		Image image = new Image("http://imageshack.com/a/img911/9238/rc2hok.png", 8, 24, false, false);
		ImageView iv = new ImageView();
		iv.setImage(image);
		Pane flatPane = new Pane();
		flatPane.getChildren().add(iv);
		return flatPane;
	}
	
	public Pane makeFMajor() {
		Pane fMajorPane = new Pane();
		Pane flatPane = this.makeFlat();
		double x = 22;
		double y = 2;
		flatPane.setTranslateX(x);
		flatPane.setTranslateY(y);
		fMajorPane.getChildren().add(flatPane);
		return fMajorPane;
	}
	
//	public Pane makeBbMajor() {
//		Pane BbMajorPane = new Pane();
//		
//		BbMajorPane.getChildren().addAll(this.makeFlat(), );
//		return BbMajorPane;
//	}
}