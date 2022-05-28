package elektrana;

public class Baterija {
	//PROVERI NEKIM TEKSTOM SAMO DA LI PUNI BATERIJU I TO JE TO
	private int kolicina_energije;
	private int maksimalni_kapacitet;
	
	public Baterija (int kap) {
		kolicina_energije=kap;
		maksimalni_kapacitet=kap;
	}
	
	public void dodajEnergiju(int kolicina) {
		if(kolicina_energije+kolicina<maksimalni_kapacitet) {
			kolicina_energije+=kolicina;
		}else {
			kolicina_energije=maksimalni_kapacitet;
		}
	}
	
	public void isprazniBateriju() {
		kolicina_energije=0;
	}
	
	public boolean proveriKapacitet() {
		if(kolicina_energije==maksimalni_kapacitet) {
			return true;
		}else {
			return false;
		}
				
	}
	
}
