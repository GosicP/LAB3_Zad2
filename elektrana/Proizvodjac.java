package elektrana;

import java.awt.Color;
import java.util.Random;

public abstract class Proizvodjac extends Parcela implements Runnable{

	private Baterija baterija;
	private int vreme;
	int ukupno_vreme;
	Thread thread;
	
	public Proizvodjac(char oz, Color c, int vreme, Baterija bat) {
		super(oz, c);
		this.vreme=vreme;
		baterija=bat;
		thread=new Thread(this);
		thread.start();
	}
	
	public int izrUkupnoVreme() {
		ukupno_vreme=(int) (vreme+new Random().nextInt(300));
		return ukupno_vreme;
	}

	public synchronized void stani() {
		thread.interrupt();
	}
	
	abstract public int proizvedi();
	
	abstract public boolean neuspeh();
	
	@Override
	public void run() {
		try {
			while(!thread.interrupted()) {
				if ((neuspeh())==false) {
					promeniBojuSlova(Color.RED);
				} //mozda ovo treba da pomeris u while
				
				thread.sleep(izrUkupnoVreme());
				
				baterija.dodajEnergiju(proizvedi());
				
				thread.sleep(300);
				
				
			}
		} catch (InterruptedException e) {
			
		}
	}
	
	

}
