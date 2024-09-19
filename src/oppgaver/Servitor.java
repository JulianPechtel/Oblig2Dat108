package oppgaver;

public class Servitor extends Thread {
	
	private final HamburgerBrett brett;
	private final String navn;
	
	public Servitor(HamburgerBrett brett, String navn) {
		this.brett = brett;
		this.navn = navn;
	}
	
	@Override
	public void run() {
		try {
			while (true) { //Servitøren jobber kontinuerlig
				Thread.sleep((int) (Math.random() * 4000) + 2000); // 2 til 6 sekunder
				
				//Prøver å ta en hamburger fra brettet, venter om brett tomt
				brett.taAvHamburger(navn);
			}
		} catch (InterruptedException e) {
			e.printStackTrace(); //unntak om brett er tomt
		}
	}

	

}
