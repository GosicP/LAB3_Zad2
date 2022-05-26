package elektrana;

import java.awt.Color;

public class Hidroelektrana extends Proizvodjac implements Runnable {
	
	private int vodene_povrsine;

	public Hidroelektrana(char oz, Color c, int vreme, Baterija bat) {
		super('H', Color.BLUE, 1500, bat);
		vodene_povrsine=0;
	}
	
	public void postaviPovrsine(int broj) {
		vodene_povrsine=broj;
	}

	@Override
	public synchronized int proizvedi() {
		if(neuspeh()==false) {
			return vodene_povrsine;
		}
		return 0;
	}

	@Override
	public synchronized boolean neuspeh() {
		if(vodene_povrsine==0) {
			return true;
		}else {
			return false;
		}
	}

}
