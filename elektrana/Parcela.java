package elektrana;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Parcela extends Label{
	private char oznaka;
	private Color color;
	public Color boja=Color.WHITE;
	public int indeks;
	private int br=0;
	ArrayList<Parcela> lista  = new ArrayList<>();
	
	public Parcela(char oz, Color c) {
		oznaka=oz;
		color=c;
		setFont(new Font(Font.SERIF, Font.BOLD, 14));
		setForeground(boja);
		setAlignment(FlowLayout.CENTER);
		setBackground(c);
		setText("" + oznaka);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		        Component source = (Component) e.getSource();
		        source.getParent().dispatchEvent(e);      
		        promeniVelicinuFonta(20);
		        /*if (lista.isEmpty()==false) {
		        	lista.remove(lista.size()-1).promeniVelicinuFonta(14);
		        	//parcela_nova.promeniVelicinuFonta(14);
		        	}
		        lista.add((Parcela) source); */
		       
			}
		        
		});
	}


	public void promeniPozadinu(Color c) {
		this.setBackground(c);
	}
	
	public void promeniBojuSlova(Color c) {
		setForeground(c);
	}
	
	public void promeniVelicinuFonta(int n) {
		setFont(new Font(Font.SERIF, Font.BOLD, n));
	}
	
	

}

