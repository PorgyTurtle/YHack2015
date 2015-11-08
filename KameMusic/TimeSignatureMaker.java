package KameMusic;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
*
*/
public class TimeSignatureMaker {
	//Represents 2/2 time, 2/4 time, 3/4 time, etc.
	private Image _22Time;
	private Image _24Time;
	private Image _34Time;
	private Image _44Time;
	private Image _64Time;
	private Image _38Time;
	private Image _68Time;
	private Image _98Time;
	private Image _128Time;

	public TimeSignatureMaker() {
		_22Time = new Image("http://imageshack.com/a/img907/3176/HA2aqu.png", 18, 45, false, false);
		_24Time = new Image("http://imageshack.com/a/img910/6703/diDNYD.png", 18, 45, false, false);
		_34Time = new Image("http://imageshack.com/a/img911/628/h7t5gM.png", 18, 45, false, false);
		_44Time = new Image("http://imageshack.com/a/img907/9065/Iqm7SR.png", 16, 40, false, false);
		_64Time = new Image("http://imageshack.com/a/img908/7893/sqfdpR.png", 18, 45, false, false);
		_38Time = new Image("http://imageshack.com/a/img911/5484/gtyZkX.png", 18, 45, false, false);
		_68Time = new Image("http://imageshack.com/a/img911/8092/cdVgjH.png", 18, 45, false, false);
		_98Time = new Image("http://imageshack.com/a/img907/3438/HXUx25.png", 18, 45, false, false);
		_128Time = new Image("http://imageshack.com/a/img907/7452/XK7DQ6.png", 18, 45, false, false);
	}
	
	public Pane makeTimeSignature() {
		Image timeSignature;
		timeSignature = _44Time;
		ImageView iv = new ImageView();
		iv.setImage(timeSignature);
		Pane timePane = new Pane();
		timePane.getChildren().add(iv);
		return timePane;
	}
}