package elektrana;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Plac extends Panel {
	
	int red, kolona;
	
	public Plac(int row, int column) {
		red=row;
		kolona=column;
	}
	
	public void paint (Graphics g) {
		drawLines();
	}
	
	public void drawLines() {
		setLayout(new GridLayout(red, kolona, 5, 5));
		for (int i = 0; i<red*kolona ;i++) { 
			if(verovatnoca()==1) {
				add(new TravnataPovrs());
			}else {
				add(new VodenaPovrs());
			}
		}
	}
	
	public int verovatnoca() {
		int verovatnoca = new Random().nextInt(100);
		if (verovatnoca>=30) {
			return 1;
		}else {
			return 2;
		}
	}
	
	public void mouseClicked(MouseEvent e) {
		
	}
	
}
