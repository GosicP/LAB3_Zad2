package elektrana;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;

public class EnergetskiSistem extends Frame {
	
	public void populateWindow() {
		
		Plac plac= new Plac(5,5);
		Baterija baterija= new Baterija(300);
		Panel centerPanel = new Panel();
		Panel topPanel = new Panel();
		Button dugme = new Button("Dodaj");
		
		plac.crtaj();
		
		centerPanel.add(plac);
		add(plac, BorderLayout.CENTER);
		
		dugme.addActionListener((ae) -> {
			baterija.isprazniBateriju();
			plac.dodajProizvodjaca(new Hidroelektrana(baterija));
			
		});
		
		topPanel.add(dugme);
		add(topPanel, BorderLayout.NORTH);
		
	}
	
	public EnergetskiSistem() {
		setBounds(700,200,500,500);
		setResizable(false);
		
		setTitle("Energetski Sistem");
		populateWindow();
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new EnergetskiSistem();
	}

}
