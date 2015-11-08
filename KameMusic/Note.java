package KameMusic;

import javafx.scene.layout.Pane;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Note implements Comparable {
	public int time, note, length, loudness;
	public static boolean startorend;
	public Note(int t, int n, int l, int d)
	{
		time=t; note=n; length=l; loudness=d;
	}

	public static void compMode(boolean a){
		startorend=a;
	}

	public int compareTo(Object a){
		Note n=(Note)a;
		if(Note.startorend){
			if(time>n.time) return 1;
        	if(time==n.time) return 0;
        	return -1;
		}
		if(time+length>n.time+n.length) return 1;
        if(time+length==n.time+n.length) return 0;
        return -1;
        }

     public boolean equals(Object a){ return compareTo(a)==0;}
}