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
	
	private Pane makeSharp() {
		Image image = new Image("http://imageshack.com/a/img911/1825/GCvEO9.png", 8, 24, false, false);
		ImageView iv = new ImageView();
		iv.setImage(image);
		Pane sharpPane = new Pane();
		sharpPane.getChildren().add(iv);
		return sharpPane;
	}
	
	public Pane makeGMajor() {
		Pane gMajorPane = new Pane();
		Pane sharpPane = this.makeSharp();
		double x = 0;
		double y = -12;
		sharpPane.setTranslateX(x);
		sharpPane.setTranslateY(y);
		gMajorPane.getChildren().add(sharpPane);
		return gMajorPane;
	}
	
	public Pane makeDMajor() {
		Pane dMajorPane = new Pane();
		Pane sharpPane = this.makeSharp();
		double x = 9;
		double y = 2;
		sharpPane.setTranslateX(x);
		sharpPane.setTranslateY(y);
		dMajorPane.getChildren().addAll(this.makeGMajor(), sharpPane);
		return dMajorPane;
	}
	
	public Pane makeAMajor() {
		Pane aMajorPane = new Pane();
		Pane sharpPane = this.makeSharp();
		double x = 18;
		double y = -15;
		sharpPane.setTranslateX(x);
		sharpPane.setTranslateY(y);
		aMajorPane.getChildren().addAll(this.makeDMajor(), sharpPane);
		return aMajorPane;
	}
	
	public Pane makeEMajor() {
		Pane eMajorPane = new Pane();
		Pane sharpPane = this.makeSharp();
		double x = 27;
		double y = -3;
		sharpPane.setTranslateX(x);
		sharpPane.setTranslateY(y);
		eMajorPane.getChildren().addAll(this.makeAMajor(), sharpPane);
		return eMajorPane;
	}
	
	public Pane makeBMajor() {
		Pane bMajorPane = new Pane();
		Pane sharpPane = this.makeSharp();
		double x = 36;
		double y = 11;
		sharpPane.setTranslateX(x);
		sharpPane.setTranslateY(y);
		bMajorPane.getChildren().addAll(this.makeEMajor(), sharpPane);
		return bMajorPane;
	}
	
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
		double x = 0;
		double y = 2;
		flatPane.setTranslateX(x);
		flatPane.setTranslateY(y);
		fMajorPane.getChildren().add(flatPane);
		return fMajorPane;
	}
	
	public Pane makeBbMajor() {
		Pane BbMajorPane = new Pane();
		Pane flatPane = this.makeFlat();
		double x = 9;
		double y = -11;
		flatPane.setTranslateX(x);
		flatPane.setTranslateY(y);
		BbMajorPane.getChildren().addAll(this.makeFMajor(), flatPane);
		return BbMajorPane;
	}
	
	public Pane makeEbMajor() {
		Pane EbMajorPane = new Pane();
		Pane flatPane = this.makeFlat();
		double x = 18;
		double y = 5;
		flatPane.setTranslateX(x);
		flatPane.setTranslateY(y);
		EbMajorPane.getChildren().addAll(this.makeBbMajor(), flatPane);
		return EbMajorPane;
	}
	
	public Pane makeAbMajor() {
		Pane AbMajorPane = new Pane();
		Pane flatPane = this.makeFlat();
		double x = 27;
		double y = -8;
		flatPane.setTranslateX(x);
		flatPane.setTranslateY(y);
		AbMajorPane.getChildren().addAll(this.makeEbMajor(), flatPane);
		return AbMajorPane;
	}
	
	public Pane makeDbMajor() {
		Pane DbMajorPane = new Pane();
		Pane flatPane = this.makeFlat();
		double x = 36;
		double y = 11;
		flatPane.setTranslateX(x);
		flatPane.setTranslateY(y);
		DbMajorPane.getChildren().addAll(this.makeAbMajor(), flatPane);
		return DbMajorPane;
	}
	
	public Pane makeGbMajor() {
		Pane GbMajorPane = new Pane();
		Pane flatPane = this.makeFlat();
		double x = 45;
		double y = -2;
		flatPane.setTranslateX(x);
		flatPane.setTranslateY(y);
		GbMajorPane.getChildren().addAll(this.makeDbMajor(), flatPane);
		return GbMajorPane;
	}
}