package elektrana;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.MouseEvent;

public class Parcela extends Label{
	private char oznaka;
	private Color color;
	public Color boja=Color.WHITE;
	
	public Parcela(char oz, Color c) {
		oznaka=oz;
		color=c;
		setFont(new Font(Font.SERIF, Font.BOLD, 14));
		setForeground(boja);
		setAlignment(FlowLayout.CENTER);
		setBackground(c);
		setText("" + oznaka);
	}


	public void promeniPozadinu(Color c) {
		this.setBackground(c);
	}
	
	public void promeniBojuSlova(Color c) {
		setForeground(c);
	}
	
	
	//ovo mi je sumnjivo
	public void mouseClicked(MouseEvent e) {
        Component source = (Component) e.getSource();
        source.getParent().getParent().dispatchEvent(e); 
    }
}
