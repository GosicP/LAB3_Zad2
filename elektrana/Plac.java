package elektrana;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

public class Plac extends Panel {
	
	int red, kolona;
	ArrayList<Parcela> lista  = new ArrayList<>();
	ArrayList<Parcela> lista_parcela = new ArrayList<>();
 	
	public Plac(int row, int column) {
		red=row;
		kolona=column;
		addMouseListener(new MouseAdapter()  {
			@Override
			public void mouseClicked(MouseEvent e) {
		        Parcela source = (Parcela) e.getSource();  
		        source.promeniVelicinuFonta(20);
		        if (lista.isEmpty()==false) {
		        	lista.remove(lista.size()-1).promeniVelicinuFonta(14);
		        }
		        
		        lista.add(source);
			}
		});
	}
	
	public void crtaj () {
		drawLines();
	} 
	
	public void drawLines() {
		setLayout(new GridLayout(red, kolona, 5, 5));
		for (int i = 0; i<red*kolona ;i++) { 
			if(verovatnoca()==1) {
				Parcela travnatapovrs = new TravnataPovrs();
				travnatapovrs.indeks=i;
				lista_parcela.add(travnatapovrs);
				add(travnatapovrs, i);
			}else {
				Parcela vodenapovrs = new VodenaPovrs();
				vodenapovrs.indeks=i;
				lista_parcela.add(vodenapovrs);
				add(vodenapovrs, i);
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

	public void dodajProizvodjaca(Hidroelektrana hidroelektrana) {
		if (lista.isEmpty()==false) {
			Parcela parcela = lista.remove(lista.size()-1);
			int pozicija = parcela.indeks;
			remove(parcela);
			azurirajVodenePovrsi(hidroelektrana, pozicija);
			add(hidroelektrana, pozicija);
			lista_parcela.remove(pozicija);
			lista_parcela.add(pozicija, hidroelektrana);
			validate();
		}
	}

	public void azurirajVodenePovrsi(Hidroelektrana hidroelektrana, int pozicija) {
		int n=0;
		Parcela parcela;
		if(pozicija!=0) {
			parcela = lista_parcela.get(pozicija-1);
			if (parcela instanceof VodenaPovrs) n++;
		}
		if(pozicija!=lista_parcela.size()) {
			parcela = lista_parcela.get(pozicija+1);
			if (parcela instanceof VodenaPovrs) n++;
		}
		
		if(pozicija-kolona>0) {
			parcela = lista_parcela.get(pozicija-kolona);
			if (parcela instanceof VodenaPovrs) n++;
		}
		if(pozicija+kolona<lista_parcela.size()) {
			parcela = lista_parcela.get(pozicija+kolona);
			if (parcela instanceof VodenaPovrs) n++;
		}
		if(pozicija-kolona+1>0) {
			parcela = lista_parcela.get(pozicija-kolona+1);
			if (parcela instanceof VodenaPovrs) n++;
		}
		
		if(pozicija-kolona-1>0) {
			parcela = lista_parcela.get(pozicija-kolona-1);
			if (parcela instanceof VodenaPovrs) n++;
		}
		if(pozicija+kolona+1<lista_parcela.size()) {
			parcela = lista_parcela.get(pozicija+kolona+1);
			if (parcela instanceof VodenaPovrs) n++;
		}
		if(pozicija+kolona-1<lista_parcela.size()) {
			parcela = lista_parcela.get(pozicija+kolona-1);
			if (parcela instanceof VodenaPovrs) n++;
		}
		hidroelektrana.postaviPovrsine(n);
	}
	
	public void zaustaviSve() {
		for (int i = 0; i<lista_parcela.size(); i++) {
				if(lista_parcela.get(i) instanceof Hidroelektrana) {
					((Proizvodjac) lista_parcela.get(i)).stani();
			}
		}
	}
}
 